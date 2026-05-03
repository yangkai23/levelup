package lld.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Anirudh
 * @since 03/05/26
 */
public class TicketManager {

    private final ParkingSpotLocater parkingSpotLocater;

    ConcurrentHashMap<Long, Ticket> ticketMap;

    private final List<Ticket> openTickets;

    private final ParkingLot parkingLot;

    private final AtomicInteger ticketCounter;

    public TicketManager(ParkingSpotLocater parkingSpotLocater, ParkingLot parkingLot) {
        this.parkingSpotLocater = parkingSpotLocater;
        this.parkingLot = parkingLot;
        ticketCounter = new AtomicInteger(1);
        ticketMap = new ConcurrentHashMap<>();
        openTickets = Collections.synchronizedList(new ArrayList<>());
    }

    public Ticket createTicket(Vehicle vehicle) {

        ParkingSpot parkingSpot = parkingSpotLocater.allocate(vehicle);

        Ticket ticket = new Ticket(System.currentTimeMillis(), vehicle, parkingSpot, ticketCounter.getAndIncrement());
        ticketMap.put(ticket.getTicketId(), ticket);
        openTickets.add(ticket);
        return ticket;
    }

    public void closeTicket(Ticket ticket) {
        ParkingSpot parkingSpot = ticket.getParkingSpot();

        ticketMap.remove(ticket.getTicketId());
        parkingLot.addParkingSpotToFloor(parkingSpot);
        openTickets.removeIf(tkt -> tkt.getTicketId() == ticket.getTicketId());

    }
}
