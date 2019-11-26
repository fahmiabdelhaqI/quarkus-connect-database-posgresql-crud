package org.acme.model;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * TodoResource
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
    @GET
    @Path("/coba")
    public List<Todo> getall() { 
        return Todo.listAll();


    }

    @GET
    @Path("/coba/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo title(@PathParam String title) {
        return Todo.findByName(title);
    }

    @POST
    @Transactional
    public Response add(Todo item) {
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @DELETE
    @Transactional 
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id) {
        Todo entity = Todo.findById(id);
        entity.delete();
        return Response.status(204).build();

    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(Todo item, @PathParam("id") Long id) {
        Todo entity = Todo.findById(id);
        entity.completed = item.completed;
        entity.order=item.order;
        entity.title=item.title;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }
    
}