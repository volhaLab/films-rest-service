package com.epam.ahafonava.entity;

public class Genre extends Entity {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre [id=" + getId() + ", name=" + name + "]";
    }



}
