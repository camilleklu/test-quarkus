package org.acme.mapper;

import org.acme.dto.EventDetailDto;
import org.acme.dto.EventSummaryDto;
import org.acme.dto.SessionDto;
import org.acme.model.Event;
import org.acme.model.Session;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface EventMapper {

    public abstract EventSummaryDto eventToEventSummaryDto(Event event);

    public abstract List<EventSummaryDto> eventsToEventSummaryDtos(List<Event> events);

    public abstract EventDetailDto eventToEventDetailDto(Event event);

    public abstract  SessionDto sessionToSessionDto(Session session);

}
