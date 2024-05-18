package ShowBooking;

public interface IBookingService {
    boolean startBookingProcess(int eventID, int userID);
    BookingConclusion confirmBookingStatus(int eventID , int userID, boolean bookingSuccessful);
}
