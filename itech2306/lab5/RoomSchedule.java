package itech2306.lab5;
import java.util.ArrayList;

public class RoomSchedule {
    // Setting Private Fields for RoomSchedule.
    private String roomName;
    private Movie[] scheduledMovies;
    private int movieCount;

    // Constructor
    public RoomSchedule(String roomName) {
        this.roomName = roomName;
        this.scheduledMovies = new Movie[6];  // Assuming there are 6 slots for movies per room
        this.movieCount = 0;
    }
    

    // Adding a movie to a rooms schedule.
    public boolean addMovie(Movie movie) {
        if (movie == null) {
            System.out.println("Sorry but you need to enter a Movie.");
            return false;
        }

        if (movieCount >= scheduledMovies.length) {
            System.out.println("The Movie Schedule is full for this Room.");
            return false;
        }

        scheduledMovies[movieCount++] = movie;
        return true;
    }

    // Retrieve a movie from the rooms schedule by index in the array.
    public Movie getMovie(int index) {
        if (index >= 0 && index < movieCount) {
            return scheduledMovies[index];
        } else {
            return null;
        }
    }


    // Creates and returns an ArrayList containing the scheduled movies.
    public ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (int i = 0; i < movieCount; i++) {
            movies.add(scheduledMovies[i]);
        }
        return movies;
    }

    // Displaying all scheduled movies.
    public void displaySchedule() {
        System.out.println("Movie Schedule for Room: " + roomName);
        if (movieCount == 0) {
            System.out.println("No movies scheduled.");
        } else {
            for (int i = 0; i < movieCount; i++) {
                System.out.println((i + 1) + ". " + scheduledMovies[i]);
            }
        }
    }

    // Printing the total movies in the scheduled.
    public void printTotalMovies() {
        System.out.println("Total movies scheduled today: " + movieCount);
    }

    // Getter for room name.
    public String getRoomName() {
        return roomName;
    }

    // Setter for room name.
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    // toString method to combine roomName and movieCount.
    public String toString() {
        return "Room: " + roomName + " with " + movieCount + " movies scheduled.";
    }
    
    
    // Cloning method for RoomSchedule to help ensure privacy.
    
    //public RoomSchedule clone() {
    	/*
        // Create a new RoomSchedule with the same room name.
        RoomSchedule clonedRoomSchedule = new RoomSchedule(this.roomName);
        // ----------------------------------------------------------------
        // Not required as it was an extra loop causing a logical error!!!!!!!!
        // Clone each Movie in the scheduledMovies array.
        for (int i = 0; i < movieCount; i++) {
            clonedRoomSchedule.addMovie(scheduledMovies[i].clone());  // Clone each movie.
        }
        //return clonedRoomSchedule;
    //}
        // -----------------------------------------------------------------
        ///
         */
        
        
    // Working copy 
    public RoomSchedule clone() {
        RoomSchedule clonedRoomSchedule = new RoomSchedule(this.roomName);
        for (int i = 0; i < movieCount; i++) {
            clonedRoomSchedule.scheduledMovies[i] = this.scheduledMovies[i];  
        }
        clonedRoomSchedule.movieCount = this.movieCount;
        return clonedRoomSchedule;
    }
}
