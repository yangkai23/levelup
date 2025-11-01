package lld.bookmyshow;

import java.util.List;

/**
 * @author Anirudh
 * @since 31/10/25
 */
public class Screen {
    int id;
    List<Seat> seats;

    public Screen(int id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
    }
}
