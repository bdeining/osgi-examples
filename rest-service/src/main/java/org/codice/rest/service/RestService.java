package org.codice.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_XML)
public interface RestService {

    @GET
    @Path("/{name}") //Maps for the `hello/John` in the URL
    String test(@PathParam("name") String name);

    @GET
    @Path("/")
    void insert(@PathParam("id") String id);

    @PUT
    @Path("/")
    void update(@PathParam("id") String id, String value);

    @POST
    @Path("/")
    void delete(String id);
}

