package lld.nullobjectpattern;

/**
 * @author Anirudh
 * @since 03/11/25
 */
public class VehicleFactory {
    static Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("car")) {
            return new Car();
        } else {
            return new NullObject();
        }
    }

}
