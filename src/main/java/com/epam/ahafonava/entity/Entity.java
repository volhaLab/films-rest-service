package com.epam.ahafonava.entity;

import java.io.Serializable;

public class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public Entity() {
    }

    public Entity(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}
