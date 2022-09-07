package com.lesson.video;

import com.lesson.temp.Genre;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public abstract class Show {
    public String name;
    public LocalDate releaseDate;
    public ArrayList<Genre> genre;
    public LocalTime duration;

    abstract long getDuration();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return name.equals(show.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder g = new StringBuilder();
        genre.forEach(x -> g.append(String.format("'%s';", x.getName())));

        return "Show{" + "name='" + name
                + "',  genre=" + g
                + ",  duration=" + duration
                + ",  releaseDate=" + releaseDate
                + '}';
    }
}
