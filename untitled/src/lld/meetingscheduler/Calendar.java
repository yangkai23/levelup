package lld.meetingscheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Anirudh
 * @since 17/04/26
 */
public class Calendar {
    List<Booking> bookings;
    MeetingRoomManager meetingRoomManager;


    Calendar(MeetingRoomManager meetingRoomManager) {
        this.bookings = new ArrayList<>();
        this.meetingRoomManager = meetingRoomManager;
    }

    public void addBookingToCalendar(Booking booking) {
        boolean bookingExists = bookings.stream()
                .anyMatch(booking1 -> booking1.id == booking.id);
        if (bookingExists) {
            System.out.println("Meeting already added to Calendar");
            return;
        }
        bookings.add(booking);
    }

    public List<Booking> getBookingsByDate(LocalDateTime dateTime) {
        return bookings.stream()
                .filter(booking -> booking.getDuration().startTime.toLocalDate().equals(dateTime.toLocalDate()))
                .toList();
    }

    public List<Booking> getBookingsByRoom(long roomId) {
        return bookings.stream()
                .filter(booking -> booking.getMeetingRoom().id == roomId)
                .toList();
    }

    public List<MeetingRoom> getAvailableRooms(Duration duration, int capacity) {

        List<MeetingRoom> availableMeetingRooms = new ArrayList<>();
        List<MeetingRoom> meetingRoomsByCapacity = meetingRoomManager.getMeetingRoomsByCapacity(capacity);

        for (MeetingRoom meetingRoom : meetingRoomsByCapacity) {

            meetingRoom.lock.lock();
            boolean isAvailable = meetingRoom.isAvailable(duration);

            if (isAvailable)
                availableMeetingRooms.add(meetingRoom);
            meetingRoom.lock.unlock();
        }

        return availableMeetingRooms;
    }

    public Optional<Booking> getBookingById(Long bookingId) {
        return bookings.stream()
                .filter(booking -> booking.id == bookingId)
                .findFirst();
    }


    public void removeBookingFromCalendar(Booking booking) {
        bookings.removeIf(b -> b.id == booking.id);
    }

}
