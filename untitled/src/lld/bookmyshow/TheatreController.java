package lld.bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Anirudh
 * @since 31/10/25
 */
public class TheatreController {
    Map<City, List<Theatre>> theatresPerCity;
    List<Theatre> allTheatres;

    public TheatreController() {
        this.theatresPerCity = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        List<Theatre> list = theatresPerCity.getOrDefault(city, new ArrayList<>());
        list.add(theatre);
        theatresPerCity.put(city, list);
        allTheatres.add(theatre);
    }

    public List<Theatre> getTheatresByCity(City city) {
        return theatresPerCity.get(city);
    }

    public Map<Theatre, List<Show>> getTheatresByMovieAndCity(Movie movie, City city) {
        return theatresPerCity.get(city)
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        theatre -> theatre.shows.stream()
                                .filter(show -> show.movie.id == movie.id).toList()


                ));
    }


}
