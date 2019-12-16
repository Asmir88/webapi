package com.webapi.restapi.resources;

import com.webapi.restapi.dao.FormularDAO;
import com.webapi.restapi.dao.FormularFieldDAO;
import com.webapi.restapi.dao.RadioButtonFieldDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.webapi.restapi.models.RadioButtonField;

@RequestScoped
@Path("radioButtonFields")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RadioButtonFieldResource {

    @Inject
    FormularDAO formularDAO;

    @Inject
    FormularFieldDAO formularFieldDAO;
    
    @Inject
    RadioButtonFieldDAO radioButtonFieldDAO;
    
    @GET
    public Response getAll() {
        return Response.ok(radioButtonFieldDAO.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getRadioButtonField(@PathParam("id") Long id) {
    	RadioButtonField radioButtonField = radioButtonFieldDAO.findById(id);

        return Response.ok(radioButtonField).build();
    }
}