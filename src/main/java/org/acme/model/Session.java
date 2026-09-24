package org.acme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Session {
    @Id @GeneratedValue
    public Long id;
    public String title ;
    public Instant startAt;
    public Instant endAt;

    @ManyToOne
    @JsonIgnore
    public Event event;



    public Session() {}
}
