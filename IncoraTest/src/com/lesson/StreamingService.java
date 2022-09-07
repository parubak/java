package com.lesson;

import com.lesson.temp.Genre;
import com.lesson.video.Show;
import java.util.*;

public class StreamingService {
    String name;
    LinkedHashSet<Show> shows;
    Map<String, Integer> viewsByShowNames;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamingService service = (StreamingService) o;
        return name.equals(service.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shows);
    }

    public StreamingService(String name, LinkedHashSet<Show> shows) {
        this.name = name;
        this.shows = shows;
        viewsByShowNames = new TreeMap<>();
        shows.forEach(s -> viewsByShowNames.put(s.name, 0));
    }

    void addShow(Show show) {
        shows.add(show);
    }

    List<Show> getMostViewedShowsOfYear(int year) {
        int limit=10;
        List<Show> listShows = shows.stream().filter(x -> x.releaseDate.getYear() == year).toList();
        return getShows(limit, listShows);
    }

    List<Show> getMostViewedShowsOfGenre(Genre genre) {
        int limit=10;
        List<Show> showsGenre = shows.stream().filter(x -> x.genre.contains(genre)).toList();
        return getShows(limit, showsGenre);
    }

    private List<Show> getShows(int limit, List<Show> listShows) {
        if (listShows.size()<1){
            return null;
        } else if (listShows.size() <= limit) return listShows;

        List<Show> sample = new ArrayList<>();

        viewsByShowNames.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        }).forEach(x -> {
            listShows.stream().filter(y -> y.name.equals(x.getKey())).limit(limit).forEach(sample::add);
        });

        return sample.stream().limit(limit).toList();
    }
}
