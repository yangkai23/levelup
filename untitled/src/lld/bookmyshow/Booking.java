package lld.bookmyshow;

import java.util.List;

/**
 * @author Anirudh
 * @since 31/10/25
 */
public class Booking {
    Show show;
    List<Seat> seats;
    Payment payment;

    public Booking(Show show, List<Seat> seats, Payment payment) {
        this.show = show;
        this.seats = seats;
        this.payment = payment;
    }
}
