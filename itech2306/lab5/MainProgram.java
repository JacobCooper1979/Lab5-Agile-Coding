package itech2306.lab5;

public class MainProgram {
	public static void main(String[] args) {
		MainProgram theMainProgram = new MainProgram();
		theMainProgram.testing();

		MenuSystem theMenu = new MenuSystem();
		theMenu.runMenu(); // Starts the menu of options, which repeats until selecting quit.
	}

	public void testing() {
		// DECLARE Movie variables
		Movie movieSonic;
		Movie movieBadBoys;
		Movie movieBarbie;
		Movie moveOppen;

		// INSTANTIATE Movies
		movieSonic = new Movie("Sonic the Hedgehog", 12.50, 8.50, 98);
		movieBadBoys = new Movie("Bad Boys for Life", 17.80, 11.20, 124);
		movieBarbie = new Movie("The Barbie Movie", 16.65, 12.35, 85);
		moveOppen = new Movie("Oppenheimer", 21.65, 16.35, 103);

		// Create RoomSchedules
		RoomSchedule room1 = new RoomSchedule("Room 1");
		RoomSchedule room2 = new RoomSchedule("Room 2");

		// Add movies to room1
		room1.addMovie(movieBarbie);
		room1.addMovie(movieSonic);
		room1.addMovie(movieBarbie);
		room1.addMovie(movieBadBoys);
		room1.addMovie(moveOppen);
		room1.addMovie(movieSonic);

		// Add movies to room2
		room2.addMovie(movieBadBoys);
		room2.addMovie(moveOppen);
		room2.addMovie(movieBarbie);

		// Adding null movie to room1
		boolean nullAdded = room1.addMovie(null);
		System.out.println("Was null added? " + nullAdded);

		// Attempt to add a 7th movie
		boolean extraAdded = room1.addMovie(movieBarbie);
		System.out.println("Was a 7th movie added? " + extraAdded);

		// Add additional movies to room1 (testing limits)
		System.out.println("Was Barbie added? " + room1.addMovie(movieBarbie));
		System.out.println("Was Sonic added? " + room1.addMovie(movieSonic));
		System.out.println("Was second Barbie added? " + room1.addMovie(movieBarbie));
		System.out.println("Was Bad Boys added? " + room1.addMovie(movieBadBoys));
		System.out.println("Was Oppenheimer added? " + room1.addMovie(moveOppen));

		// Add to room2 again
		System.out.println("Was Oppenheimer added to room2? " + room2.addMovie(moveOppen));

		// Try to add more to room1 (should be full)
		System.out.println("Was Sonic added again? " + room1.addMovie(movieSonic));

		// Retrieve scheduled movies
		Movie first = room1.getMovie(0);
		if (first != null) {
			System.out.println("First scheduled movie: " + first.getName());
		}

		Movie fourth = room1.getMovie(3);
		if (fourth != null) {
			System.out.println("Fourth scheduled movie: " + fourth.getName());
		}

		Movie invalid = room1.getMovie(6);
		if (invalid == null) {
			System.out.println("Tried to retrieve a non-existent 7th movie - returned null as expected.");
		}

		room1.printTotalMovies();

		// CALL METHODS on movies
		System.out.println("Testing the Movie Class\n");
		System.out.println("First movie is: " + movieSonic.getName());
		System.out.println(" total running time: " + movieSonic.getDuration() + " minutes");
		System.out.println(" adult tickets: $" + movieSonic.getPriceAdult());
		System.out.println(" child tickets: $" + movieSonic.getPriceChild() + "\n");

		System.out.println("Second movie is: " + movieBadBoys.getName());
		System.out.println(" total running time: " + movieBadBoys.getDuration() + " minutes");
		System.out.println(" adult tickets: $" + movieBadBoys.getPriceAdult());
		System.out.println(" child tickets: $" + movieBadBoys.getPriceChild() + "\n");

		System.out.println("The toString of the first movie is:  " + movieSonic.toString());
		System.out.println("The implicit toString for the second movie is: " + movieBadBoys);
		
		System.out.println("Modifying the prices of the movies\n");
		// Modify ticket prices.
		movieBadBoys.setPriceAdult(10000.22);
		movieBadBoys.setPriceChild(225555.33);
		System.out.println("After modifications, the prices of tickets are:");
		System.out.println(" adult tickets: $" + movieBadBoys.getPriceAdult());
		System.out.println(" child tickets: $" + movieBadBoys.getPriceChild() + "\n");

		// Attempt invalid ticket prices
		movieBadBoys.setPriceAdult(-1.11);
		movieBadBoys.setPriceChild(-0.11);
		System.out.println("After second-round modification attempts, the prices of tickets are:");
		System.out.println(" adult tickets: $" + movieBadBoys.getPriceAdult());
		System.out.println(" child tickets: $" + movieBadBoys.getPriceChild() + "\n");

		///////////////////////////////////
		// TESTING of MovieTheatre CLASS //
		///////////////////////////////////
		System.out.println("Testing the Movie Theatre Class\n");
		MovieTheatre village;
		MovieTheatre hoyts;

		village = new MovieTheatre("Village Cinemas, Melbourne Central", "Mon-Fri 8:00-21:00, Sat-Sun 8:00-23:30", 3);
		hoyts = new MovieTheatre("Hoyts, Rundle Mall Adelaide", "Mon-Thur 8:00-20:00, Fri-Sun 8:00-Midnight", 4);

		System.out.println("First theatre is at: " + village.getLocation());
		System.out.println("  opening hours are: " + village.getOpenHours());

		System.out.println("Second is: " + hoyts.toString());
		System.out.println("  opening hours are: " + hoyts.getOpenHours());

		hoyts.setOpenHours("Mon-Sat 9:00-21:00");
		System.out.println("  the updated opening hours are: " + hoyts.getOpenHours());
		System.out.println("\n");

	

		Movie second = room1.getMovie(1);
		if (second != null) {
			System.out.println("Second scheduled movie: " + second.getName());
		}

		boolean invalidRoomAdd = village.addMovieToRoomSchedule(5, movieBarbie); // invalid room
		System.out.println("Was movie added to non-existent room 5? " + invalidRoomAdd);
		System.out.println("\n");
		System.out.println("End of Testing.");
		System.out.println("\n");


		
	}

	public void start() {
		// Placeholder for start logic
	}
}
