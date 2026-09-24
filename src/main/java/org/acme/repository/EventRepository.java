package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Event;

@ApplicationScoped
public class EventRepository implements PanacheRepository<Event> {

    // 1. Trouver un événement par son nom exact
    public Event findByName(String name) {
        return find("name", name).firstResult();
    }

}
