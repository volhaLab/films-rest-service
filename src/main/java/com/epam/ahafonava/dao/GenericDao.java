package com.epam.ahafonava.dao;

public interface GenericDao<ID, T> extends Dao {

    void create(T obj);

    T read(ID id);

    void update(T obj);

    void delete(ID id);

}
