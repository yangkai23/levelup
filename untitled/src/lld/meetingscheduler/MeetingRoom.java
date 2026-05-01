package lld.meetingscheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Anirudh
 * @since 17/04/26
 */
public class MeetingRoom {
    long id;
    String name;
    int capacity;
    List<Booking> bookings;
    AvailabilityStatus availabilityStatus;
    Lock lock;


    public MeetingRoom(long id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        bookings = new ArrayList<>();
        availabilityStatus = AvailabilityStatus.AVAILABLE;
        lock = new ReentrantLock();
    }

    public boolean isAvailable(Duration duration) {
        return bookings.stream()
                .noneMatch(b -> b.getDuration().overLaps(duration));
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MeetingRoom that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }
}
