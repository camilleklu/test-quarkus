package org.acme.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;

import org.acme.dto.EventDetailDto;
import org.acme.dto.EventSummaryDto;
import org.acme.mapper.EventMapper;
import org.acme.model.Event;
import org.acme.repository.EventRepository;

import java.util.List;

@Singleton
public class EventService {

    @Inject
    EventRepository eventRepository;

    @Inject
    EventMapper eventMapper;

    public List<EventSummaryDto> listEvent() {

        List<Event> events = eventRepository.listAll();
        return eventMapper.eventToEventSummaryDto(events);
    }


    public EventDetailDto getEvent(@PathParam("id") Long id){

        Event event =  eventRepository.findById(id);
        return eventMapper.eventToEventDetailDto(event);
    }

    @Transactional
    public Event createEvent(Event event){
        eventRepository.persist(event);
        return event;
    }
}
