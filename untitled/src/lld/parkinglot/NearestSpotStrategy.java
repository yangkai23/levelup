package lld.parkinglot;

/**
 * @author Anirudh
 * @since 03/05/26
 */
public class NearestSpotStrategy implements ParkingStrategy {
    private final int floor;
    private final ParkingLot parkingLot;

   public NearestSpotStrategy(int floor, ParkingLot parkingLot) {
        this.floor = floor;
        this.parkingLot = parkingLot;
    }

    @Override
    public ParkingSpot allocateSpot(Vehicle vehicle) {
        Floor parkingLotFloor = parkingLot.getFloor(floor);

        return parkingLotFloor.findParkingSpotByVehicleType(vehicle.vehicleType());
    }
}
