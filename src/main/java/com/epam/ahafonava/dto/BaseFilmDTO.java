package com.epam.ahafonava.dto;

import java.util.List;

import javax.ws.rs.FormParam;

import com.epam.ahafonava.entity.Genre;

public class BaseFilmDTO {

    @FormParam("name")
    private String name;

    @FormParam("genres")
    private List<Genre> genres;

    @FormParam("date")
    private String date;

    @FormParam("director")
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

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(final String director) {
        this.director = director;
    }
}
