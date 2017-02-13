package com.epam.ahafonava.dao;

import java.util.List;

import com.epam.ahafonava.entity.Film;

public interface FilmDao extends GenericDao<Long, Film> {

    List<Film> findAll();

    List<Film> find(Film searchValues);
}
