package itech2306.lab5;

import java.util.ArrayList;

/** A MovieTheatre is a complex containing multiple rooms in which movies are presented. */
public class MovieTheatre {
	// FIELDS to store the data about each movie theatre represented in the program...
	private String location;			// Describes where the theatre is, e.g. shopping centre, some major road, etc.
	private String openHours;			// Describes the opening hours - when people may go to the theatre
	private ArrayList<RoomSchedule> roomSchedules;
	
	// CONSTRUCTOR to create new objects that represent a particular MovieTheatre:
    public MovieTheatre(String location, String openHours, int totalRooms) {
        this.location = location;
        this.openHours = openHours;
        this.roomSchedules = new ArrayList<RoomSchedule>();

        // Loop to create and add RoomSchedule objects
        for (int i = 1; i <= totalRooms; i++) {
            String roomName = "Room " + i;
            RoomSchedule room = new RoomSchedule(roomName);
            roomSchedules.add(room);
        }
    }

    // Getters for all fields required for MovieTheatre Class.
    public String getLocation() {
        return location;
    }

    public String getOpenHours() {
        return openHours;
    }
    
    
    public void addRoom(RoomSchedule newRoom) {
        roomSchedules.add(newRoom);
    }

    public ArrayList<RoomSchedule> getRoomSchedules() {
        return roomSchedules;
    }

    // Setters
    public void setLocation(String newLocation) {
        location = newLocation;
    }

    public void setOpenHours(String newHours) {
        openHours = newHours;
    }

    // Method to add a movie to a specific room's schedule
    public boolean addMovieToRoomSchedule(int roomIndex, Movie movie) {
        if (roomIndex < 0 || roomIndex >= roomSchedules.size()) {
            return false;  // Invalid room index
        }
        RoomSchedule room = roomSchedules.get(roomIndex);
        return room.addMovie(movie);
    }
    
    // Cloneing method for MovieTheatre to help ensure privacy.
    public MovieTheatre clone() {
        // Create a new MovieTheatre with the same location and open hours
        MovieTheatre clonedTheatre = new MovieTheatre(this.location, this.openHours, this.roomSchedules.size());

        // Clone each RoomSchedule and add it to the cloned theatre's roomSchedules
        for (RoomSchedule roomSchedule : roomSchedules) {
            clonedTheatre.addRoom(roomSchedule.clone());  // Clone each RoomSchedule
        }

        return clonedTheatre;
    }

    // A toString method:
    @Override
    public String toString() {
        String description = location + " (opening hours: " + openHours + ", rooms: " + roomSchedules.size() + ")";
        return description;
    }
}
