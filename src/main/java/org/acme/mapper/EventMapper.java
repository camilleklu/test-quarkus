package org.acme.mapper;

import org.acme.dto.*;
import org.acme.model.Event;
import org.acme.model.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface EventMapper {

    public abstract EventSummaryDto eventToEventSummaryDto(Event event);

    public abstract List<EventSummaryDto> eventsToEventSummaryDtos(List<Event> events);

    public abstract EventDetailDto eventToEventDetailDto(Event event);

    // retourner quelque chose sous la forme d'un dto session
    public abstract  SessionDto toSessionDto(Session session);

    public abstract CreateEventRequest ToCreateEventRequest(Event event);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "event", ignore = true)
    public abstract Session toSession(CreateSessionRequest request);

    public abstract Event toEvent(CreateEventRequest request);
}
