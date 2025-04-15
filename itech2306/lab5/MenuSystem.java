package itech2306.lab5;

import java.util.Scanner;

import java.util.ArrayList;

/** The purpose of this class is to be the main Use Case Handler class of the program. */
public class MenuSystem {
	private boolean stillRunning;
	private Scanner scan;
	
	private MovieTheatre curTheatre;		// The "current" MovieTheatre.
	
	public MenuSystem()
	{
		 scan = new Scanner(System.in);			// Create a Scanner for the class to use for inputs
		 
		 // Create an initial object to be the "current" movie theatre - it will have 3 rooms.
		 curTheatre = new MovieTheatre("Village Cinemas, Melbourne Central", "Mon-Fri 8:00-21:00, Sat-Sun 8:00-23:30",3);
	}
	
	public void runMenu() {
        stillRunning = true;			// The menu will still present itself.

        while (stillRunning) {
            System.out.println("The following are your options:");
            System.out.println("1. Add a new Room to the Movie Theatre");
            System.out.println("2. Add a movie to a Room's schedule");
            System.out.println("3. Display a Room's current schedule of movies");
            System.out.println("4. Display summary about the Movie Theatre");
            System.out.println("0. Quit");
            System.out.println("What do you want to do next?");
            int choice = scan.nextInt();

            switch (choice) {
                case 0:
                    stillRunning = false;
                    break;
                case 4:  // Displaying a summary Cloned about the Movie Theatre.
                    displayTheatreSummaryCloned();
                    break;
                case 2:  // Adding a movie to a Room's schedule.
                    addMovieToRoom();
                    break;
                case 3:  // Displaying a Rooms current Cloned schedule of movies.
                    showScheduleCloned();
                    break;
                case 1:  // Add a new Room to the movie Theatre.
                    addNewRoom();
                    break;
                default:
                    System.out.println("I'm sorry it was either an invalid input or their is nothing to show.");
            }
        }

        System.out.println("Finished running the program :)  Goodbye!");
    }
	
	// Methods for adding data.
	
	// Method to add a new Room to the MovieTheatre.
    public void addNewRoom() {
        System.out.println("Enter a name for the new room:");
        scan.nextLine();  // Consume the newline.
        String roomName = scan.nextLine();

        // Add the new room to the MovieTheatre.
        curTheatre.addRoom(new RoomSchedule(roomName));

        System.out.println("New room added successfully!");
    }
    
    
    // Method to prompt the user for movie details and return a Movie object.
    public Movie obtainMovieDetails() {
        scan.nextLine();  // Consume the newline left by nextInt().

        System.out.println("Enter movie title:");
        String title = scan.nextLine();

        System.out.println("Enter adult price:");
        double adultPrice = scan.nextDouble();

        System.out.println("Enter child price:");
        double childPrice = scan.nextDouble();

        System.out.println("Enter movie duration (in minutes):");
        int duration = scan.nextInt();

        // Create and return the Movie object.
        return new Movie(title, adultPrice, childPrice, duration);
    }
    
    // Method to add a movie to a selected room's schedule.
    public void addMovieToRoom() {
        int roomIndex = selectRoom();  // Get the selected room index.
        Movie movie = obtainMovieDetails();  // Get the movie details from the user.

        // Try to add the movie to the selected room's schedule
        boolean success = curTheatre.addMovieToRoomSchedule(roomIndex, movie);

        // Show the result of the attempt.
        if (success) {
            System.out.println("Movie added successfully!");
        } else {
            System.out.println("Failed to add the movie to the room schedule.");
        }
    }
    
    
    // Methods for retriving data. 
    
    // Method for displaying the Cloned moive Theatre summary.
    public void displayTheatreSummaryCloned() {
    	MovieTheatre clonedCurTheatre = curTheatre.clone(); // clone only when needed

    	System.out.println("Movie Theatre: " + clonedCurTheatre.getLocation() + "(Cloned)");
    	System.out.println("Opening Hours: " + clonedCurTheatre.getOpenHours() + "(Cloned)");
    	System.out.println("Number of Rooms: " + clonedCurTheatre.getRoomSchedules().size() + "(Cloned)");
    }
    
    // Method to display the list of rooms and get the users room selection.
    public int selectRoom() {
        System.out.println("The current Movie Theatre has the following rooms:");
        // Ensures that Rooms are displayed as human readable Numbers.
        for (int i = 0; i < curTheatre.getRoomSchedules().size(); i++) {
            System.out.println((i + 1) + ". " + curTheatre.getRoomSchedules().get(i).getRoomName());
        }

        // Ask the user to select a room.
        System.out.println("Please select a room (1 to " + curTheatre.getRoomSchedules().size() + "):");
        int roomChoice = scan.nextInt();

        // Return the option based on the array chosen by the user as arrays start at 0 but we cant have room 0 for the user.
        return roomChoice - 1;
    }
    
    // Method to display the current schedule of movies for a selected room using cloned data.
    public void showScheduleCloned() {
        int roomIndex = selectRoom();  // Get the selected room index.
        RoomSchedule selectedRoom = curTheatre.getRoomSchedules().get(roomIndex);

        // Clone the selected room's schedule.
        RoomSchedule clonedRoom = selectedRoom.clone();

        // Display the movies scheduled in the cloned room.
        System.out.println("Movies scheduled in " + clonedRoom.getRoomName() + ": ");
        clonedRoom.displaySchedule();  // Uses the displaySchedule method from RoomSchedule class.
    }
}