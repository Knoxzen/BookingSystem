package ShowBooking;

import java.util.HashSet;
import java.util.Set;

public class Auditorium {
    int auditoriumNumber;
    int eventID;
    int capacity;
    int bookedSeats;
    Set<Integer> underBooking;

    public Auditorium(int auditoriumNumber, int eventID, int capacity) {
        this.auditoriumNumber = auditoriumNumber;
        this.eventID = eventID;
        this.capacity = capacity;
        this.bookedSeats = 0;
        this.underBooking = new HashSet<>();
    }

    public int getAuditoriumNumber() {
        return auditoriumNumber;
    }

    public void setAuditoriumNumber(int auditoriumNumber) {
        this.auditoriumNumber = auditoriumNumber;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
