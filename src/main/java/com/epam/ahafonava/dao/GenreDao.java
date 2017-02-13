package com.epam.ahafonava.dao;

import java.util.List;

import com.epam.ahafonava.entity.Film;
import com.epam.ahafonava.entity.Genre;

public interface GenreDao extends GenericDao<Long, Genre> {

    List<Genre> findAll();

    void addGenreToFilm(Film film, Genre genre);

    void deleteGenresOfFilm(Long filmId);
}
