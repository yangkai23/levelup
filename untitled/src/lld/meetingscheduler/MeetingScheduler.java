package lld.meetingscheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anirudh
 * @since 18/04/26
 */
public class MeetingScheduler {


    public static void main(String[] args) {

        MeetingRoomManager meetingRoomManager = new MeetingRoomManager();
        addMeetingRooms(meetingRoomManager);
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(60);

        Duration duration = new Duration(start, end);

        List<Attendee> attendees = new ArrayList<>();

        Attendee organizer = new Attendee(1, "Anirudh", "anirudh@gmail.com");

        attendees.add(organizer);
        attendees.add(new Attendee(2, "hrushi", "hrushi@gmail.com"));
        attendees.add(new Attendee(3, "revanth", "revanth@gmail.com"));
        attendees.add(new Attendee(3, "vishnu", "revanth@gmail.com"));

        BookingRequest request = new BookingRequest(5, duration, attendees, "Catch up", null, organizer);
        NotificationService notificationService = new NotificationService();
        Calendar calendar = new Calendar(meetingRoomManager);
        BookingManager bookingManager = new BookingManager(calendar, notificationService, meetingRoomManager);
        Booking booking = bookingManager.bookMeeting(request);


        bookingManager.cancelMeeting(booking.getId());

    }

    private static void addMeetingRooms(MeetingRoomManager meetingRoomManager) {
        MeetingRoom skypiea = new MeetingRoom(1, "Skypiea", 2);
        MeetingRoom dressrosa = new MeetingRoom(2, "dressrosa", 4);
        MeetingRoom wanoKuni = new MeetingRoom(3, "WanoKuni", 6);
        meetingRoomManager.addMeetingRoom(skypiea);
        meetingRoomManager.addMeetingRoom(dressrosa);
        meetingRoomManager.addMeetingRoom(wanoKuni);
    }


}
