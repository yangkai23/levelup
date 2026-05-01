package lld.meetingscheduler;

import java.time.LocalDateTime;

/**
 * @author Anirudh
 * @since 17/04/26
 */
public class Duration implements Comparable<Duration> {

    LocalDateTime startTime;
    LocalDateTime endTime;

    Duration(LocalDateTime start, LocalDateTime end) {
        if (end.isAfter(start)) {
            this.startTime = start;
            this.endTime = end;
        } else {
            throw new IllegalArgumentException("end time should be greater than start time");
        }

    }

    public boolean overLaps(Duration other) {
        return !this.startTime.isAfter(other.endTime) && !this.endTime.isBefore(other.startTime);
    }


    @Override
    public int compareTo(Duration dur) {

        return this.startTime.compareTo(dur.startTime);
    }
}
