package lld.nullobjectpattern;

/**
 * @author Anirudh
 * @since 03/11/25
 */
public class Main {
    public static void main(String[] args) {
            Vehicle vehicle=VehicleFactory.getVehicle("Bike");
            printVehicleInfo(vehicle);
    }

    public static void printVehicleInfo(Vehicle vehicle) {
        System.out.println("Tank capacity : " + vehicle.getTankCapacity());
        System.out.println("Seat capacity : " + vehicle.getSeatCapacity());
    }
}
