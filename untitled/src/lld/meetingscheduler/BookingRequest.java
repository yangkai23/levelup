package lld.meetingscheduler;

import java.util.List;

/**
 * @author Anirudh
 * @since 18/04/26
 */
public class BookingRequest {
    int capacity;
    Duration duration;
    List<Attendee> attendees;
    String title;
    Long roomId;
    Attendee organizer;

    public BookingRequest(int capacity, Duration duration, List<Attendee> attendees, String title, Long roomId, Attendee organizer) {
        this.capacity = capacity;
        this.duration = duration;
        this.attendees = attendees;
        this.title = title;
        this.roomId = roomId;
        this.organizer = organizer;
    }
}
