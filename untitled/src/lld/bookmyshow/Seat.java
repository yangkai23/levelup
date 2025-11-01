package lld.bookmyshow;

/**
 * @author Anirudh
 * @since 31/10/25
 */
public class Seat {
    int id;
    SeatCategory seatCategory;
    int price;

    public Seat(int id, SeatCategory seatCategory, int price) {
        this.id = id;
        this.seatCategory = seatCategory;
        this.price = price;
    }
}
