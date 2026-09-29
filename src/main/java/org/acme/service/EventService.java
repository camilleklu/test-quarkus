package org.acme.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;

import org.acme.dto.EventDetailDto;
import org.acme.dto.EventSummaryDto;
import org.acme.exception.EventNotFoundException;
import org.acme.mapper.EventMapper;
import org.acme.model.Event;
import org.acme.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Singleton
public class EventService {

    @Inject
    EventRepository eventRepository;

    @Inject
    EventMapper eventMapper;

    public List<EventSummaryDto> listEvent() {
        List<Event> events = eventRepository.listAll();
        return eventMapper.eventsToEventSummaryDtos(events);
    }


    public EventDetailDto getEvent(Long id){

        Optional<Event> eventOpt = eventRepository.findByIdOptional(id);
        Event event = eventOpt.orElseThrow(() -> new EventNotFoundException(id));
        return eventMapper.eventToEventDetailDto(event);
    }

    @Transactional
    public Event createEvent(Event event){
        eventRepository.persist(event);
        return event;
    }
}
