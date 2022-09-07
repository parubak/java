package com.lesson.video;

import com.lesson.temp.Genre;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Movie extends Show {

    public Movie(String name, ArrayList<Genre> genre, LocalTime duration, LocalDate releaseDate) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate=releaseDate;
    }

    @Override
    public long getDuration() {
        return duration.getSecond();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        if (hashCode()!=o.hashCode())return false;

        return name.equals(show.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
