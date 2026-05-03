package lld.parkinglot;

/**
 * @author Anirudh
 * @since 03/05/26
 */
public class LowestFloorStrategy implements ParkingStrategy {

    private final ParkingLot parkingLot;

    public LowestFloorStrategy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }


    @Override
    public ParkingSpot allocateSpot(Vehicle vehicle) {
        for (Floor floor : parkingLot.getAllFloors()) {
            ParkingSpot spot = floor.findParkingSpotByVehicleType(vehicle.vehicleType());
            if (spot != null) return spot;
        }
        return null;
    }
}
