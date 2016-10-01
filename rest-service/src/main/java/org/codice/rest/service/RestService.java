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
    @Path("/insert/{entry}")
    void insert(@PathParam("entry") String entry);

    @PUT
    @Path("/update/{entry}")
    void update(@PathParam("entry") String entry);

    @POST
    @Path("/delete/{entry}")
    void delete(@PathParam("entry") String key);
}

