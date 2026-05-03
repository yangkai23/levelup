package lld.parkinglot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 03/05/26
 */
public class ParkingLot {

    Map<Integer, Floor> floors;

    ParkingLot() {
        floors = new HashMap<>();

    }

    public void addFloor(Floor floor) {
        floors.put(floor.getFloorId(), floor);
    }

    public void removeFloor(Floor floor) {
        floors.remove(floor.getFloorId());
    }


    public Floor getFloor(int floorId) {
        return floors.get(floorId);
    }

    public int floorsAvailable() {
        return floors.size();
    }

    public void addParkingSpotToFloor(ParkingSpot parkingSpot) {
        Floor floor = getFloor(parkingSpot.floorId());

        floor.addParkingSpot(parkingSpot);
    }

    public Collection<Floor> getAllFloors() {
        return floors.values();
    }

    public boolean isFull() {
        return floors.values().stream()
                .allMatch(Floor::isFull);
    }

}
