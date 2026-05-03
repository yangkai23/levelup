package lld.parkinglot;

/**
 * @author Anirudh
 * @since 03/05/26
 */
public interface ParkingStrategy {
    ParkingSpot allocateSpot(Vehicle vehicle);
}
