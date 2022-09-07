package com.lesson;

import com.lesson.temp.Genre;
import com.lesson.video.Show;
import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

public class Subscription {

    StreamingService streamingService;

    public Subscription(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return streamingService.name.equals(that.streamingService.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streamingService);
    }

    void watch(String showName) {
        Optional<Show> oShow = streamingService.shows.stream()
                .filter(x -> x.name.equals(showName)).findFirst();
        if (oShow.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    showName + " - no show",
                    "Message",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Map<String, Integer> nameWatch = streamingService.viewsByShowNames;
        nameWatch.put(showName, nameWatch.get(showName) + 1);
        System.out.printf("Watching: %s  Watch - %d%n", oShow.get(), nameWatch.get(showName));
    }

    public Show getRecommendationTrending() {
        List<Show> shows = streamingService.getMostViewedShowsOfYear(LocalDate.now().getYear());
        if (shows == null) return null;
        return shows.get((int) (shows.size() * Math.random()));
    }

    public Show getRecommendationByGenre(Genre genre) {
        List<Show> shows = streamingService.getMostViewedShowsOfGenre(genre);
        if (shows == null) return null;
        return shows.get((int) (shows.size() * Math.random()));
    }
}
