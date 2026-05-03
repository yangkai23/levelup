package lld.parkinglot;

/**
 * @author Anirudh
 * @since 03/05/26
 */
public class ParkingSpotLocater {

    private final ParkingStrategy parkingStrategy;

    ParkingSpotLocater(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot allocate(Vehicle vehicle) {
        return parkingStrategy.allocateSpot(vehicle);
    }
}
