package com.site.actor_management.exception;

public class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException(Long id) {
        super("Actor not found with id " + id);
    }
}