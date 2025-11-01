package lld.bookmyshow;

import java.util.*;

/**
 * @author Anirudh
 * @since 31/10/25
 */
public class MovieController {
    Map<City, List<Movie>> moviesPerCity;
    List<Movie> allMovies;

    MovieController() {
        moviesPerCity = new HashMap<>();
        allMovies = new LinkedList<>();
    }

    public void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> moviesInCity = moviesPerCity.getOrDefault(city, new ArrayList<>());
        moviesInCity.add(movie);
        moviesPerCity.put(city, moviesInCity);

    }

    public Movie getMovieByName(String movieName) {

        return allMovies.stream()
                .filter(movie -> movie.name.equals(movieName))
                .findFirst()
                .orElse(null);
    }

    public List<Movie> getMoviesByCity(City city) {
        return moviesPerCity.get(city);
    }

}
