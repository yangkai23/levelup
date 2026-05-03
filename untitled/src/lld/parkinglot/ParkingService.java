package lld.parkinglot;

/**
 * @author Anirudh
 * @since 03/05/26
 */
public class ParkingService {

    private final TicketManager ticketManager;
    private final PaymentService paymentService;


    public ParkingService(TicketManager ticketManager, PaymentService paymentService) {
        this.ticketManager = ticketManager;
        this.paymentService = paymentService;
    }

    public Ticket checkIn(Vehicle vehicle) {

        return ticketManager.createTicket(vehicle);
    }

    public Ticket checkOut(Ticket ticket) {

        ticketManager.closeTicket(ticket);
        return ticket;

    }

    public Ticket getCharges(Ticket ticket) {
        double parkingPrice = paymentService.calculateParkingPrice(ticket);
        ticket.setCharges(parkingPrice);
        return ticket;
    }
}
