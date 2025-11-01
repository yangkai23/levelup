package lld.bookmyshow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 31/10/25
 */
public class Show {
    int id;
    int capacity;
    Movie movie;
    Screen screen;
    int startTime;
    List<Integer> bookedSeatIds;

    public Show(int id, int capacity, Movie movie, Screen screen, int startTime) {
        this.id = id;
        this.capacity = capacity;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.bookedSeatIds = new ArrayList<>();
    }
}
