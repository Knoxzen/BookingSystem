package ShowBooking;

public interface IRepo {
    void registerEventInAuditorium(int auditoriumNumber, int eventID, int capacity);
    Auditorium getAuditoriumDetailsForEvent(int eventID);
    int getNumberOfSeatsBookedOrUnderBookingForEvent(int eventID );
    void addUnderBooking(int eventID , int userID);
    void removeUnderBooking(int eventID, int userID);
    void addSuccessfulBooking(int eventID,int userID);
}
