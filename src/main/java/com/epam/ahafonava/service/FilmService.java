package com.epam.ahafonava.service;

import java.util.List;

import com.epam.ahafonava.entity.Film;

public interface FilmService {

    Film getFilm(Long id);

    List<Film> getFilms();

    List<Film> getFilms(Film searchValues);

    void delete(Long id);

    void update(Film film);

    void save(Film film);

}
