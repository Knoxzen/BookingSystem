package ShowBooking;

public class BookingService implements IBookingService{
    public IRepo repo;

    public BookingService(IRepo repo) {
        this.repo = repo;
    }

    @Override
    public boolean startBookingProcess(int eventID, int userID) {
        Auditorium currentAuditorium = repo.getAuditoriumDetailsForEvent(eventID);
        if(currentAuditorium == null){
            return false;
        }
        int currentBooking = repo.getNumberOfSeatsBookedOrUnderBookingForEvent(eventID);
        if (currentAuditorium.getCapacity() > currentBooking)
        {
            currentAuditorium.underBooking.add(userID);
            return true;
        }
        return false;
    }

    @Override
    public BookingConclusion confirmBookingStatus(int eventID, int userID, boolean bookingSuccessful) {
        Auditorium currentAuditorium = repo.getAuditoriumDetailsForEvent(eventID);
        if(currentAuditorium == null)
        {
            return new BookingConclusion(-1,false);
        }
        if(bookingSuccessful)
        {
            repo.addSuccessfulBooking(eventID,userID);
        }
        else
        {
            repo.removeUnderBooking(eventID,userID);
        }

        return new BookingConclusion(currentAuditorium.getAuditoriumNumber(),bookingSuccessful);
    }
}
