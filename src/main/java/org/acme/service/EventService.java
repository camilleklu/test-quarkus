package org.acme.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import org.acme.dto.*;
import org.acme.exception.EventNotFoundException;
import org.acme.mapper.EventMapper;
import org.acme.model.Event;
import org.acme.model.Session;
import org.acme.repository.EventRepository;
import org.acme.repository.SessionRepository;

import java.util.List;
import java.util.Optional;

@Singleton
public class EventService {

    @Inject
    EventRepository eventRepository;

    @Inject
    SessionRepository sessionRepository;

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
    public Event createEvent(CreateEventRequest request){
        Event eventEntity = eventMapper.toEvent(request);
        eventRepository.persist(eventEntity);
        return eventEntity;
    }

    @Transactional
    public SessionDto createSession(Long eventId, CreateSessionRequest request){
        Optional<Event> eventOpt = eventRepository.findByIdOptional(eventId);
        Event event = eventOpt.orElseThrow(() -> new EventNotFoundException(eventId));
        Session sessionEntity = eventMapper.toSession(request);
        sessionEntity.event = event;
        sessionRepository.persist(sessionEntity);
        return eventMapper.toSessionDto(sessionEntity);
    }
}
