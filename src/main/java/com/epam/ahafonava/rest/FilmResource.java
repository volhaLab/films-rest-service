package com.epam.ahafonava.rest;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.epam.ahafonava.dto.BaseFilmDTO;
import com.epam.ahafonava.dto.HateoasFilmDTO;
import com.epam.ahafonava.entity.Film;
import com.epam.ahafonava.service.FilmService;

@Path("/films")
public class FilmResource {

    private static final String LINK_SELF = "self";

    private static final String LINK_DELETE = "delete";

    private static final String LINK_UPDATE = "update";

    @Inject
    private FilmService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Context final UriInfo uriInfo, final BaseFilmDTO film) {
        return save(uriInfo, film);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createFromForm(@Context final UriInfo uriInfo, @BeanParam final BaseFilmDTO film) {
        return save(uriInfo, film);
    }
    
    private Response save(final UriInfo uriInfo, final BaseFilmDTO film) {
        final Film newFilm = createFilm(film);
        service.save(newFilm);
        final URI uri = uriInfo.getBaseUriBuilder()
                .path(FilmResource.class)
                .path(String.valueOf(newFilm.getId()))
                .build();
        return Response.created(uri).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") final Long id) {
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context final UriInfo uriInfo) {
        final List<Film> films = service.getFilms();
        final List<HateoasFilmDTO> wrappedFilms = new ArrayList<>();
        for (final Film film : films) {
            HateoasFilmDTO wrappedFilm = new HateoasFilmDTO(film);
            wrappedFilm.addLink(buildLink(uriInfo, wrappedFilm, LINK_SELF));
            wrappedFilm.addLink(buildLink(uriInfo, wrappedFilm, LINK_DELETE));
            wrappedFilm.addLink(buildLink(uriInfo, wrappedFilm, LINK_UPDATE));
            wrappedFilms.add(wrappedFilm);
        }
        return Response.ok(wrappedFilms).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@Context final UriInfo uriInfo, @PathParam("id") final Long id) {
        final Film film = service.getFilm(id);
        if (film == null) {
            return Response.status(Status.NOT_FOUND).build();
        } else {
            final HateoasFilmDTO wrappedFilm = new HateoasFilmDTO(film);
            wrappedFilm.addLink(buildLink(uriInfo, wrappedFilm, LINK_SELF));
            wrappedFilm.addLink(buildLink(uriInfo, wrappedFilm, LINK_DELETE));
            wrappedFilm.addLink(buildLink(uriInfo, wrappedFilm, LINK_UPDATE));
            return Response.ok(wrappedFilm).build();
        }
    }

    private Link buildLink(final UriInfo uriInfo, final HateoasFilmDTO film, final String rel) {
        final URI uri = uriInfo.getBaseUriBuilder()
                .path(FilmResource.class)
                .path(String.valueOf(film.getId()))
                .build();
        final Link link = Link.fromUri(uri)
                .rel(rel)
                .type(MediaType.APPLICATION_JSON)
                .build();
        return link;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Context final UriInfo uriInfo, final BaseFilmDTO film, @PathParam("id") final Long id) {
        final Film newFilm = createFilm(film);
        newFilm.setId(id);
        service.update(newFilm);
        final Film updatedFilm = service.getFilm(id);
        if (updatedFilm == null) {
            return Response.status(Status.NOT_FOUND).build();
        } else {
            final HateoasFilmDTO wrappedFilm = new HateoasFilmDTO(newFilm);
            wrappedFilm.addLink(buildLink(uriInfo, wrappedFilm, LINK_SELF));
            wrappedFilm.addLink(buildLink(uriInfo, wrappedFilm, LINK_DELETE));
            wrappedFilm.addLink(buildLink(uriInfo, wrappedFilm, LINK_UPDATE));
            return Response.ok(wrappedFilm).build();
        }
    }

    private Film createFilm(final BaseFilmDTO film) {
        final Film newFilm = new Film();
        newFilm.setName(film.getName());
        newFilm.setGenres(film.getGenres());
        newFilm.setDirector(film.getDirector());
        newFilm.setDate(LocalDate.parse(film.getDate()));
        return newFilm;
    }
}
