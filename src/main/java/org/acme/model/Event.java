package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Event {
    @Id @GeneratedValue
    public Long id;
    public String name;

    @OneToMany(mappedBy = "event")
    public List<Session> sessions;

    public Event() {}
}
