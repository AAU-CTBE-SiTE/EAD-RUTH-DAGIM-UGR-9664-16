package com.site.actor_management.dto;

import com.site.actor_management.model.Actor;

public record ActorResponse(Long id, String name, String movieName) {

    public static ActorResponse from(Actor actor) {
        return new ActorResponse(actor.getId(), actor.getName(), actor.getMovieName());
    }
}