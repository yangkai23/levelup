package lld.bookmyshow;

import java.util.List;

/**
 * @author Anirudh
 * @since 31/10/25
 */
public class Theatre {
    int id;
    Address address;
    List<Screen> screens;
    List<Show> shows;

    public Theatre(int id, Address address, List<Screen> screens, List<Show> shows) {
        this.id = id;
        this.address = address;
        this.screens = screens;
        this.shows = shows;
    }
}
