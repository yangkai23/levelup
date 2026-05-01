package lld.meetingscheduler;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Anirudh
 * @since 18/04/26
 */
public class MeetingRoomManager {
    Set<MeetingRoom> meetingRooms;

    MeetingRoomManager() {
        meetingRooms = new HashSet<>();
    }

    public void addMeetingRoom(MeetingRoom meetingRoom) {

        if (meetingRooms.contains(meetingRoom)) {
            System.err.println("Meeting room already available");
            return;
        }
        meetingRooms.add(meetingRoom);
    }

    public void removeMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.remove(meetingRoom);
    }

    public void updateMeetingRoom(MeetingRoom meetingRoom) {
        Optional<MeetingRoom> room = meetingRooms.stream()
                .filter(mr -> mr.id == meetingRoom.id)
                .findFirst();

        if (room.isEmpty()) {
            System.err.println("Meeting room not found");
            return;
        }

        meetingRooms.remove(room.get());

        meetingRooms.add(meetingRoom);
    }

    public List<MeetingRoom> getMeetingRoomsByCapacity(int capacity) {
        return meetingRooms.stream()
                .filter(room -> room.getCapacity() >= capacity)
                .toList();

    }

    public Optional<MeetingRoom> getMeetingRoomById(long id) {
        return meetingRooms.stream()
                .filter(meetingRoom -> meetingRoom.id == id)
                .findFirst();
    }
}
