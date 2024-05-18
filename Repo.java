package ShowBooking;

import java.util.HashMap;
import java.util.Map;

public class Repo implements IRepo {
    private Map<Integer, Auditorium> auditoriumMap = new HashMap<>();
    private Map<Integer, Auditorium> eventtoAuditoriumMap = new HashMap<>();

    @Override
    public void registerEventInAuditorium(int auditoriumNumber, int eventID, int capacity) {
        Auditorium auditorium = new Auditorium(auditoriumNumber, eventID, capacity);
        auditoriumMap.put(auditoriumNumber, auditorium);
        eventtoAuditoriumMap.put(eventID, auditorium);
    }

    @Override
    public Auditorium getAuditoriumDetailsForEvent(int eventID) {
        return eventtoAuditoriumMap.get(eventID);
    }

    @Override
    public int getNumberOfSeatsBookedOrUnderBookingForEvent(int eventID) {
        Auditorium currentAuditorium = getAuditoriumDetailsForEvent(eventID);
        if (currentAuditorium != null) {
            return currentAuditorium.bookedSeats + currentAuditorium.underBooking.size();
        }
        return 0;
    }

    @Override
    public void addUnderBooking(int eventID, int userID) {
        Auditorium currentBooking = getAuditoriumDetailsForEvent(eventID);
        if (currentBooking != null) {
            currentBooking.underBooking.add(userID);
        }
    }

    @Override
    public void removeUnderBooking(int eventID, int userID) {
        Auditorium currentBooking = getAuditoriumDetailsForEvent(eventID);
        if (currentBooking != null) {
            currentBooking.underBooking.remove(userID);
        }
    }

    @Override
    public void addSuccessfulBooking(int eventID, int userID) {
        Auditorium currentBooking = getAuditoriumDetailsForEvent(eventID);
        if (currentBooking != null) {
            currentBooking.underBooking.remove(userID);
            currentBooking.setBookedSeats(currentBooking.getBookedSeats() + 1);
        }
    }
}
