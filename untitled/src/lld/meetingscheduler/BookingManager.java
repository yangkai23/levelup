package lld.meetingscheduler;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Anirudh
 * @since 18/04/26
 */
public class BookingManager {
    Calendar calendar;
    NotificationService notificationService;
    MeetingRoomManager meetingRoomManager;

    public BookingManager(Calendar calendar, NotificationService notificationService, MeetingRoomManager meetingRoomManager) {
        this.calendar = calendar;
        this.notificationService = notificationService;
        this.meetingRoomManager = meetingRoomManager;
    }


    public Booking bookMeeting(BookingRequest request) {

        MeetingRoom selectedRoom = null;

        // Case 1: specific room requested
        if (Objects.nonNull(request.roomId)) {
            Optional<MeetingRoom> roomOpt = meetingRoomManager.getMeetingRoomById(request.roomId);

            if (roomOpt.isEmpty()) {
                System.err.println("Meeting room not found");
                return null;
            }

            MeetingRoom room = roomOpt.get();

            if (room.getCapacity() < request.capacity) {
                System.err.println("Room capacity is insufficient");
                return null;
            }
            selectedRoom = room;

        }
        // Case 2: auto-assign room
        else {
            List<MeetingRoom> availableRooms =
                    calendar.getAvailableRooms(request.duration, request.capacity);

            if (availableRooms.isEmpty()) {
                System.err.println("No rooms available");
                return null;
            }

            selectedRoom = availableRooms.getFirst();
        }

        Booking booking;

        selectedRoom.lock.lock();
        try {
            boolean isAvailable = selectedRoom.isAvailable(request.duration);

            if (!isAvailable) {
                System.err.println("Room is already booked for given time");
                return null;
            }

            // Create booking
            booking = new Booking(
                    selectedRoom,
                    request.duration,
                    request.title,
                    request.organizer
            );

            for (Attendee attendee : request.attendees) {
                booking.addAttendee(attendee);
            }


            selectedRoom.getBookings().add(booking);
            calendar.addBookingToCalendar(booking);

        } finally {
            selectedRoom.lock.unlock();
        }

        notificationService.notify(booking);
        return booking;

    }

    public void cancelMeeting(long bookingId) {

        Optional<Booking> booking = calendar.getBookingById(bookingId);

        if (booking.isEmpty()) {
            System.err.println("No booking found");
            return;
        }

        MeetingRoom meetingRoom = booking.get().meetingRoom;

        meetingRoom.getBookings().removeIf(b -> b.id == bookingId);

        calendar.bookings.removeIf(b -> b.id == bookingId);

    }

    public Booking updateBooking(Booking booking) {
        //TODO
        return null;

    }
}
