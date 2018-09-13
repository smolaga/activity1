package com.bfar.people.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.bfar.people.resource.MessageResponse;
import com.bfar.people.resource.PeopleRequest;

@Component
@Path("/people")
public class PeopleResource {

    List<PeopleResponse> people = new ArrayList<PeopleResponse>();
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(PeopleRequest peopleRequest){
    	MessageResponse messageResponse = new MessageResponse();
        if (StringUtils.isEmpty(peopleRequest.getFirstname()) || StringUtils.isEmpty(peopleRequest.getLastname()) || StringUtils.isEmpty(peopleRequest.getBirthDate())) {
        	messageResponse.setMessage("all fields required");
            return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(messageResponse).build();
        }else {
        	PeopleResponse pr = new PeopleResponse();
        	SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        	pr.setFirstname(peopleRequest.getFirstname());
        	pr.setLastname(peopleRequest.getLastname());
        	pr.setBdate(format.format(peopleRequest.getBirthDate()));
        	people.add(pr);
        	return Response.status(HttpServletResponse.SC_CREATED).entity(HttpServletResponse.SC_CREATED).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPeople(PeopleRequest request){
        return Response.ok().entity(people).build();
    }
}
