package com.epam.ahafonava.rest.serializer;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Link;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LinksSerializer extends JsonSerializer<List<Link>> {

    @Override
    public void serialize(final List<Link> links, final JsonGenerator jgen, final SerializerProvider provider)
        throws IOException, JsonProcessingException {
        jgen.writeStartArray();
        for (final Link link : links) {
            jgen.writeStartObject();
            jgen.writeStringField("rel", link.getRel());
            jgen.writeStringField("href", link.getUri().toString());
            jgen.writeStringField("type", link.getType());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
    }

}
