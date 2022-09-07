package com.lesson.video;

import com.lesson.temp.Genre;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Series extends Show {

    ArrayList<Episode> episodes;

    public Series(String name, ArrayList<Genre> genre, LocalDate releaseDate, ArrayList<Episode> episodes) {

        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.episodes = episodes;

    }

    @Override
    public long getDuration() {
        LocalDateTime time=LocalDateTime.of(0,0,0,0,0,0);
        for (Episode e : episodes) {
            time.plusSeconds(e.getDuration());
        }
        return time.getSecond();
    }
}