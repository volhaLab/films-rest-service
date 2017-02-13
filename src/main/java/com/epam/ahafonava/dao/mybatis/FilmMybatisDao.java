package com.epam.ahafonava.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.epam.ahafonava.dao.FilmDao;
import com.epam.ahafonava.entity.Film;

public class FilmMybatisDao extends SqlSessionDaoSupport implements FilmDao {

    @Override
    public void create(final Film film) {
        getSqlSession().insert("Film.create", film);
    }

    @Override
    public Film read(final Long id) {
        System.out.println(getSqlSession().selectList("Film.read", id));
        return getSqlSession().selectOne("Film.read", id);
    }

    @Override
    public void update(final Film film) {
        getSqlSession().update("Film.update", film);
    }

    @Override
    public void delete(final Long id) {
        getSqlSession().delete("Film.delete", id);
    }

    @Override
    public List<Film> findAll() {
        return getSqlSession().selectList("Film.findAll");
    }

    @Override
    public List<Film> find(final Film searchValues) {
        return getSqlSession().selectList("Film.find", searchValues);
    }

}
