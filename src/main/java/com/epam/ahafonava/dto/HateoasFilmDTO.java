package com.epam.ahafonava.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

import com.epam.ahafonava.entity.Film;
import com.epam.ahafonava.rest.serializer.LinksSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonPropertyOrder({ "id", "name", "genres", "director", "date", "_links" })
@JsonTypeName("film")
public class HateoasFilmDTO extends BaseFilmDTO {

    private Long id;

    private List<Link> links;

    public HateoasFilmDTO() {
        super();
    }

    public HateoasFilmDTO(final Film film) {
        this.setId(film.getId());
        this.setName(film.getName());
        this.setGenres(film.getGenres());
        this.setDirector(film.getDirector());
        this.setDate(film.getDate().toString());
        this.links = new ArrayList<Link>();
    }

    @JsonProperty("_links")
    @JsonSerialize(using = LinksSerializer.class)
    public List<Link> getLinks() {
        return links;
    }

    public void addLink(final Link link) {
        if (this.links == null) {
            this.links = new ArrayList<Link>();
        }
        this.links.add(link);
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}
