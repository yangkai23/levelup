package lld.meetingscheduler;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Anirudh
 * @since 17/04/26
 */
public class Booking {

    long id;
    MeetingRoom meetingRoom;
    Set<Attendee> attendees;
    Duration duration;
    String title;
    Attendee organizer;
    BookingStatus bookingStatus;

    Booking(MeetingRoom meetingRoom, Duration duration, String title, Attendee organizer) {
        this.meetingRoom = meetingRoom;
        this.duration = duration;
        this.title = title;
        this.organizer = organizer;
        this.bookingStatus = BookingStatus.CONFIRMED;
        attendees = new HashSet<>();
        attendees.add(organizer);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public Set<Attendee> getAttendees() {
        return attendees;
    }


    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Attendee getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Attendee organizer) {
        this.organizer = organizer;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


    public void addAttendee(Attendee attendee) {
        if (attendees.contains(attendee)) {
            System.out.println("Attendee already added to meeting");
            return;
        }
        attendees.add(attendee);
    }

    public void removeAttendee(Attendee attendee) {
        if (!attendees.contains(attendee)) {
            System.out.println("Attendee not added to this meeting");
            return;
        }
        attendees.remove(attendee);
    }

    public boolean conflictsWith(Duration duration) {
        return this.duration.overLaps(duration);
    }



}
