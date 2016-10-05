package org.codice.data.management;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@javax.ws.rs.Path("/")
public interface DataManager {

    @PUT
    @Path("/insert")
    void insert(@QueryParam("key") String key, @QueryParam("value") String value);

    @POST
    @Path("/update")
    void update(@QueryParam("key") String key, @QueryParam("value") String value);

    @DELETE
    @Path("/delete")
    void delete(@QueryParam("key") String key);
}
