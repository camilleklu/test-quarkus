package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.Event;
import org.acme.service.EventService;

import java.util.List;

@Path("/api/events")
public class EventResource {

    @Inject
    EventService eventService;

    //public record EventSummary(Long id, String name) {}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> listEvent(){
        return eventService.listEvent();
    }

    // Ok ici à la place de name on avait "Évenement " + id car en gros on ne pouvait pas récup le name car c'est pas dans l'url donc
    // là j'ai testé un truc où on peu faire ça juste pour tester : http://localhost:8080/api/events/3?name=Test, en passant du coup le name en @QueryParam
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEvent(@PathParam("id") Long id){
        return eventService.getEvent(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEvent(Event event){
        Event createdEvent = eventService.createEvent(event);
        return Response.status(Response.Status.CREATED).entity(createdEvent).build();
    }

}


