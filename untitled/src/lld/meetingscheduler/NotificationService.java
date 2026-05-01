package lld.meetingscheduler;

/**
 * @author Anirudh
 * @since 18/04/26
 */
public class NotificationService {

    NotificationService() {
    }

    public void notify(Booking booking) {
        for (Attendee attendee : booking.getAttendees()) {
            sendEmail(attendee, booking);
        }
    }

    private void sendEmail(Attendee attendee, Booking booking) {
        System.out.println("Sending email to " + attendee.email);
    }


}
