package com.webapi.restapi.resources;

import com.webapi.restapi.dao.FormularDAO;
import com.webapi.restapi.dao.FormularFieldDAO;
import com.webapi.restapi.models.Formular;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.webapi.restapi.models.FormularField;
import java.util.List;
import java.util.ArrayList;

@RequestScoped
@Path("formulars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FormularResource {

    @Inject
    FormularDAO formularDAO;

    @Inject
    FormularFieldDAO formularFieldDAO;
    
    @GET
    public Response getAll() {
        return Response.ok(formularDAO.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getFormular(@PathParam("id") Long id) {
        Formular formular = formularDAO.findById(id);

        return Response.ok(formular).build();
    }

    @GET
    @Path("/findByName/{name}")
    public Response getFormularByName(@PathParam("name") String name) {
        Formular formular = formularDAO.findByName(name);
        if(formular == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found").build();
		}

        return Response.ok(formular).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Formular formular) {
        Formular updateFormular = formularDAO.findById(id);
        for (int i=0; i<formular.getFields().size();i++) {
		  FormularField field  = (FormularField)formular.getFields().get(i);
		  if(field.getId() != null)
		  {
		  	  formularFieldDAO.create(field);
		  }
		  else
		  {
		  	  formularFieldDAO.update(field);
		  }
		}
        updateFormular.setName(formular.getName());
        formularDAO.update(updateFormular);

        return Response.ok().build();
    }

    @POST
    public Response create(Formular formular) {
    	Formular existingFormular = formularDAO.findByName(formular.getName());
        if(existingFormular == null)
        {
        	/* List<FormularField> fields = new ArrayList<FormularField>();
			for (int i=0; i<formular.getFields().size();i++) {
			  FormularField field  = (FormularField)formular.getFields().get(i);
			  FormularField newField = formularFieldDAO.create(field);
			  fields.add(newField);
			}
			formular.setFields(fields); */
        	formularDAO.create(formular);
        	return Response.ok().build();
        }
        else
		{
			return Response.status(Response.Status.CONFLICT).entity("Formular already exists").build();
		}
        
        
    }
}