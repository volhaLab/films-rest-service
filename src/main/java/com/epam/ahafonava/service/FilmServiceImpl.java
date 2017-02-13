package com.epam.ahafonava.service;

import java.util.List;

import com.epam.ahafonava.dao.FilmDao;
import com.epam.ahafonava.dao.GenreDao;
import com.epam.ahafonava.entity.Film;
import com.epam.ahafonava.entity.Genre;

public class FilmServiceImpl implements FilmService {

    private FilmDao filmdao;

    private GenreDao genredao;

    @Override
    public Film getFilm(final Long id) {
        return filmdao.read(id);
    }

    @Override
    public List<Film> getFilms() {
        return filmdao.findAll();
    }

    @Override
    public List<Film> getFilms(final Film searchValues) {
        return filmdao.find(searchValues);
    }

    @Override
    public void delete(final Long id) {
        genredao.deleteGenresOfFilm(id);
        filmdao.delete(id);
    }

    @Override
    public void update(final Film film) {
        filmdao.update(film);
        addGenres(film);
    }

    @Override
    public void save(final Film film) {
        filmdao.create(film);
        addGenres(film);
    }

    private void addGenres(final Film film) {
        genredao.deleteGenresOfFilm(film.getId());
        for (final Genre genre : film.getGenres()) {
            genredao.addGenreToFilm(film, genre);
        }
    }

    public void setFilmdao(final FilmDao filmdao) {
        this.filmdao = filmdao;
    }

    public void setGenredao(final GenreDao genredao) {
        this.genredao = genredao;
    }
}
