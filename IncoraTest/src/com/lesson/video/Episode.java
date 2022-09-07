package com.lesson.video;

import com.lesson.temp.Genre;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Episode extends Show {
    public Episode(String name, ArrayList<Genre> genre, LocalTime duration, LocalDate releaseDate) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    @Override
    public long getDuration() {
        return duration.getSecond();
    }
}
