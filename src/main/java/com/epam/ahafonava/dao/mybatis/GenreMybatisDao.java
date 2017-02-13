package com.epam.ahafonava.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.epam.ahafonava.dao.GenreDao;
import com.epam.ahafonava.entity.Film;
import com.epam.ahafonava.entity.Genre;

public class GenreMybatisDao extends SqlSessionDaoSupport implements GenreDao {

    @Override
    public void create(final Genre genre) {
        getSqlSession().insert("Genre.create", genre);
    }

    @Override
    public Genre read(final Long id) {
        return getSqlSession().selectOne("Genre.read", id);
    }

    @Override
    public void update(final Genre genre) {
        getSqlSession().update("Genre.update", genre);
    }

    @Override
    public void delete(final Long id) {
        getSqlSession().delete("Genre.delete", id);
    }

    @Override
    public List<Genre> findAll() {
        return getSqlSession().selectList("Genre.findAll");
    }

    @Override
    public void addGenreToFilm(final Film film, final Genre genre) {
        final Map<String, Long> map = new HashMap<String, Long>();
        map.put("filmId", film.getId());
        map.put("genreId", genre.getId());
        getSqlSession().insert("Genre.addGenreToFilm", map);
    }

    @Override
    public void deleteGenresOfFilm(final Long filmId) {
        getSqlSession().delete("Genre.deleteGenreOfFilm", filmId);
    }

}
