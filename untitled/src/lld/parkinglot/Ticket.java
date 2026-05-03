package lld.parkinglot;

/**
 * @author Anirudh
 * @since 02/05/26
 */
public class Ticket {

    private final long entryTime;
    private long exitTime;

    private final Vehicle vehicle;

    private final ParkingSpot parkingSpot;

    private final long ticketId;

    private double charges;


    public Ticket(long entryTime, Vehicle vehicle, ParkingSpot parkingSpot, long ticketId) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.ticketId = ticketId;

    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getTicketId() {
        return ticketId;
    }
}
