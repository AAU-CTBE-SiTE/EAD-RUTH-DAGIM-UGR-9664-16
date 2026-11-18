package com.site.actor_management.service;

import com.site.actor_management.dto.ActorRequest;
import com.site.actor_management.dto.ActorResponse;
import com.site.actor_management.exception.ActorNotFoundException;
import com.site.actor_management.model.Actor;
import com.site.actor_management.repository.ActorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActorService {

    private final ActorRepository repository;

    public ActorService(ActorRepository repository) {
        this.repository = repository;
    }

    public ActorResponse create(ActorRequest request) {
        Actor saved = repository.save(new Actor(request.name(), request.movieName()));
        return ActorResponse.from(saved);
    }

    @Transactional(readOnly = true)
    public List<ActorResponse> findAll() {
        return repository.findAll().stream().map(ActorResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public ActorResponse findById(Long id) {
        return ActorResponse.from(getOrThrow(id));
    }

    public ActorResponse update(Long id, ActorRequest request) {
        Actor actor = getOrThrow(id);
        actor.setName(request.name());
        actor.setMovieName(request.movieName());
        return ActorResponse.from(actor);
    }

    public void delete(Long id) {
        repository.delete(getOrThrow(id));
    }

    private Actor getOrThrow(Long id) {
        return repository.findById(id).orElseThrow(() -> new ActorNotFoundException(id));
    }
}