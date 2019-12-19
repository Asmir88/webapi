package com.webapi.restapi.resources;

import com.webapi.restapi.dao.FormularVersionDAO;
import com.webapi.restapi.dao.FormularFieldVersionDAO;
import com.webapi.restapi.dao.RadioButtonFieldVersionDAO;
import com.webapi.restapi.models.FormularVersion;
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
import com.webapi.restapi.models.FormularFieldVersion;
import com.webapi.restapi.models.RadioButtonFieldVersion;

@RequestScoped
@Path("formularVersions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FormularVersionResource {

    @Inject
    FormularVersionDAO formularVersionDAO;

    @Inject
    FormularFieldVersionDAO formularFieldVersionDAO;
    
    @Inject
    RadioButtonFieldVersionDAO radioButtonFieldVersionDAO;
    
    @GET
    public Response getAll() {
        return Response.ok(formularVersionDAO.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getFormular(@PathParam("id") Long id) {
        FormularVersion formularVersion = formularVersionDAO.findById(id);

        return Response.ok(formularVersion).build();
    }

    @GET
    @Path("/findByName/{name}")
    public Response getFormularByName(@PathParam("name") String name) {
        FormularVersion formularVersion = formularVersionDAO.findByName(name);
        return Response.ok(formularVersion).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, FormularVersion formularVersion) {
        FormularVersion updateFormularVersion = formularVersionDAO.findById(id);
        for (int i=0; i<formularVersion.getFields().size();i++) {
		  FormularFieldVersion field  = (FormularFieldVersion)formularVersion.getFields().get(i);
		  if(field.getId() != null)
		  {
			  for (int j=0; j<field.getRadioButtonFields().size();j++) {
				  RadioButtonFieldVersion radioLabel  = (RadioButtonFieldVersion)field.getRadioButtonFields().get(j);
				  if(radioLabel.getId() != null)
				  {
					  radioButtonFieldVersionDAO.update(radioLabel);
				  }
				  else
				  {
					  radioButtonFieldVersionDAO.create(radioLabel);
				  }
				}
		  	  formularFieldVersionDAO.update(field);
		  }
		  else
		  {
		  	  formularFieldVersionDAO.create(field);
		  }
		}
        updateFormularVersion.setName(formularVersion.getName());
        updateFormularVersion.setFields(formularVersion.getFields());
        formularVersionDAO.update(updateFormularVersion);

        return Response.ok(updateFormularVersion).build();
    }

    @POST
    public Response create(FormularVersion formularVersion) {
    	FormularVersion existingFormularVersion = formularVersionDAO.findByName(formularVersion.getName());
        if(existingFormularVersion == null)
        {
        	formularVersionDAO.create(formularVersion);
        	return Response.ok(formularVersion).build();
        }
        else
		{
			return Response.status(Response.Status.CONFLICT).entity("Formular version already exists").build();
		}
        
        
    }
}