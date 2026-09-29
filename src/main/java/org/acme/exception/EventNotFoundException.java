package org.acme.exception;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(Long id){
        super("L'événement avec l'ID " + id + " est introuvable.");
    }
}
