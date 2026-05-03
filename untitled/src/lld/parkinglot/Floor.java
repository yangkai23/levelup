package lld.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Anirudh
 * @since 02/05/26
 */
public class Floor {

    public int getFloorId() {
        return floorId;
    }

    private final int floorId;


    private final Map<SpotType, Queue<ParkingSpot>> spotTypeQueueMap;

    public Floor(int floorId) {
        this.floorId = floorId;
        this.spotTypeQueueMap = new HashMap<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {

        Queue<ParkingSpot> parkingSpots = spotTypeQueueMap.computeIfAbsent(parkingSpot.spotType(), spotType -> new ConcurrentLinkedQueue<>());

        parkingSpots.offer(parkingSpot);

    }

    public ParkingSpot findParkingSpotByVehicleType(VehicleType vehicleType) {

        SpotType spotType = getSpotType(vehicleType);
        Queue<ParkingSpot> queue = spotTypeQueueMap.get(spotType);

        if (queue == null || queue.isEmpty()) {
            System.err.println("No slot available in given floor");
            return null;
        }

        return queue.poll();
    }


    public SpotType getSpotType(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> SpotType.TWO_WHEELER;
            case FOUR_WHEELER -> SpotType.FOUR_WHEELER;
            case EIGHT_WHEELER -> SpotType.EIGHT_WHEELER;
        };
    }
    public boolean isFull() {
        return spotTypeQueueMap.values().stream().allMatch(Queue::isEmpty);
    }

}
