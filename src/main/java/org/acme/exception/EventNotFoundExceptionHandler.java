package org.acme.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class EventNotFoundExceptionHandler implements ExceptionMapper<EventNotFoundException> {

    @Override
    public Response toResponse(EventNotFoundException exception){
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .build();
    }
}
