package lld.bookmyshow;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Anirudh
 * @since 31/10/25
 */
public class BookMyShow {
    private final TheatreController theatreController;
    private final MovieController movieController;

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
        bookMyShow.createBooking(City.BANGALORE, "Bahubali");
        bookMyShow.createBooking(City.HYDERABAD, "OG");
    }

    private void createBooking(City city, String movieName) {
        Movie selectedMovie = movieController.getMoviesByCity(city).stream()
                .filter(movie -> movie.name.equals(movieName))
                .findFirst()
                .orElse(null);

        if (Objects.isNull(selectedMovie)) {
            System.err.println("Selected Movie is not available at the moment , please check after sometime!!");
            return;
        }

        Show show = theatreController.getTheatresByMovieAndCity(selectedMovie, city)
                .entrySet()
                .iterator()
                .next()
                .getValue()
                .stream()
                .findFirst()
                .orElse(null);


        if (Objects.isNull(show)) {
            System.err.println("Show is not available at the moment , please check after sometime!!");
            return;
        }

        int seatNum = 25;

        List<Integer> bookedSeatIds = show.bookedSeatIds;
        if (!bookedSeatIds.contains(seatNum)) {
            bookedSeatIds.add(seatNum);

            List<Seat> myBookedSeats = new ArrayList<>();

            for (Seat seat : show.screen.seats) {
                if (seat.id == seatNum)
                    myBookedSeats.add(seat);
            }
            Booking booking = new Booking(show, myBookedSeats, new Payment());

        } else {
            System.out.println("seat already booked, try again");
            return;
        }
        System.out.println("BOOKING SUCCESSFUL");


    }

    public BookMyShow() {

        this.theatreController = new TheatreController();
        this.movieController = new MovieController();


    }

    private void initialize() {
        createMovies();
        createTheatre();
    }

    private void createTheatre() {
        Movie bahubali = movieController.getMovieByName("Bahubali");
        Movie og = movieController.getMovieByName("OG");
        List<Screen> inoxScreens = createScreen();
        Show inoxMorningShow = createShow(1, inoxScreens.getFirst(), bahubali, 8);
        Show inoxSecondShow = createShow(2, inoxScreens.getFirst(), og, 22);
        List<Show> inoxShows = List.of(inoxMorningShow, inoxSecondShow);
        Theatre inoxTheatre = new Theatre(1, new Address("JP nagar", City.BANGALORE), inoxScreens, inoxShows);


        List<Screen> pvrScreens = createScreen();
        Show pvrMorningShow = createShow(3, pvrScreens.getFirst(), og, 9);
        Show pvrSecondShow = createShow(4, pvrScreens.getFirst(), bahubali, 21);
        List<Show> pvrShows = List.of(pvrMorningShow, pvrSecondShow);
        Theatre pvrTheatre = new Theatre(2, new Address("KPHB", City.HYDERABAD), pvrScreens, pvrShows);

        theatreController.addTheatre(pvrTheatre, City.HYDERABAD);
        theatreController.addTheatre(inoxTheatre, City.BANGALORE);

    }

    private Show createShow(int showId, Screen screen, Movie movie, int startTime) {
        return new Show(showId, 250, movie, screen, startTime);
    }

    private List<Screen> createScreen() {
        List<Seat> seats = createSeats();
        return List.of(new Screen(1, seats));
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            seats.add(new Seat(i, SeatCategory.SILVER, 110));
        }
        for (int i = 101; i <= 200; i++) {
            seats.add(new Seat(i, SeatCategory.GOLD, 150));
        }
        for (int i = 201; i <= 250; i++) {
            seats.add(new Seat(i, SeatCategory.PLATINUM, 220));
        }
        return seats;
    }

    private void createMovies() {
        Movie m1 = new Movie(1, "Bahubali", 150);
        Movie m2 = new Movie(2, "Dude", 134);
        Movie m3 = new Movie(3, "OG", 145);

        movieController.addMovie(m1, City.BANGALORE);
        movieController.addMovie(m2, City.HYDERABAD);
        movieController.addMovie(m3, City.HYDERABAD);
    }
}
