package ShowBooking;

public class BookingConclusion {
    int auditorium;
    int userID;
    boolean bookingSuccessful;

    public BookingConclusion(int auditorium, boolean bookingSuccessful) {
        this.auditorium = auditorium;
        this.bookingSuccessful = bookingSuccessful;
    }
}
