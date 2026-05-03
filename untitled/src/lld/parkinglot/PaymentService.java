package lld.parkinglot;

/**
 * @author Anirudh
 * @since 03/05/26
 */
public class PaymentService {


    private double getGst(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> 2.5;
            case FOUR_WHEELER -> 10.02;
            case EIGHT_WHEELER -> 22.8;
        };
    }

    private double getStandardPrices(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> 60;
            case FOUR_WHEELER -> 100;
            case EIGHT_WHEELER -> 150;
        };
    }


    public double calculateParkingPrice(Ticket ticket) {

        double hrs = (ticket.getExitTime() - ticket.getEntryTime()) / 3600000.0;

        double parkingPrice;

        double standardPrices = getStandardPrices(ticket.getVehicle().vehicleType());

        parkingPrice = (standardPrices * hrs);

        parkingPrice += (parkingPrice * getGst(ticket.getVehicle().vehicleType()) / 100);
        return parkingPrice;


    }
}
