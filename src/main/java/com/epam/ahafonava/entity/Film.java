package com.epam.ahafonava.entity;

import java.time.LocalDate;
import java.util.List;

public class Film extends Entity {

    private static final long serialVersionUID = 1L;

    private String name;

    private List<Genre> genres;

    private LocalDate date;

    private String director;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(final List<Genre> genres) {
        this.genres = genres;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(final String director) {
        this.director = director;
    }

}
