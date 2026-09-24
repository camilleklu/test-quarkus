package org.acme.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;

import org.acme.model.Event;
import org.acme.repository.EventRepository;

import java.util.List;

@Singleton
public class EventService {

    @Inject
    EventRepository eventRepository;

    public List<Event> listEvent() {
        return eventRepository.listAll();
    }


    public Event getEvent(@PathParam("id") Long id){
        return eventRepository.findById(id);
    }

    @Transactional
    public Event createEvent(Event event){
        eventRepository.persist(event);
        return event;
    }
}
