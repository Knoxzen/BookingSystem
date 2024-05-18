package ShowBooking;


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp;

        int totalNumberOfAuditoriums = Integer.parseInt(br.readLine().trim());
        int[] capacityOfAuditorium = new int[totalNumberOfAuditoriums];
        int[] eventIdInAuditorium = new int[totalNumberOfAuditoriums];

        inp = br.readLine().split(" ");
        for (int i = 0; i < totalNumberOfAuditoriums; i++) {
            eventIdInAuditorium[i] = Integer.parseInt(inp[i]);
        }

        inp = br.readLine().split(" ");
        for (int i = 0; i < totalNumberOfAuditoriums; i++) {
            capacityOfAuditorium[i] = Integer.parseInt(inp[i]);
        }

        IRepo repo = new Repo();
        for (int i = 0; i < totalNumberOfAuditoriums; i++) {
            repo.registerEventInAuditorium(i, eventIdInAuditorium[i], capacityOfAuditorium[i]);
        }

        IBookingService bookingService = new BookingService(repo);
        int totalNumberOfRequests = Integer.parseInt(br.readLine().trim());
        for (int requestNumber = 1; requestNumber <= totalNumberOfRequests; requestNumber++) {
            inp = br.readLine().split(" ");
            String query = inp[0];
            int eventId, userId;
            switch (query) {
                case "startBookingProcess":
                    eventId = Integer.parseInt(inp[1]);
                    userId = Integer.parseInt(inp[2]);
                    boolean didStartBookingProcess = bookingService.startBookingProcess(eventId, userId);
                    System.out.println(didStartBookingProcess);
                    break;
                case "confirmBookingStatus":
                    eventId = Integer.parseInt(inp[1]);
                    userId = Integer.parseInt(inp[2]);
                    boolean isSuccessfulBooking = Boolean.parseBoolean(inp[3]);
                    BookingConclusion bookingConclusion = bookingService.confirmBookingStatus(eventId, userId, isSuccessfulBooking);
                    System.out.println((bookingConclusion.bookingSuccessful ? "successful" : "failed") + " " + bookingConclusion.auditorium);
                    break;
            }
        }
        System.out.flush();
        System.out.close();
    }
}

