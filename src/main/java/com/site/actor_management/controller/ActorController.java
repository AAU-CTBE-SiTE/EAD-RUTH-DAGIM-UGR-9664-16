package com.site.actor_management.controller;

import com.site.actor_management.dto.ActorRequest;
import com.site.actor_management.dto.ActorResponse;
import com.site.actor_management.service.ActorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {

    private final ActorService service;

    public ActorController(ActorService service) {
        this.service = service;
    }

    @GetMapping("/actor")
    public List<ActorResponse> getActors() {
        return service.findAll();
    }

    @GetMapping("/actor/{id}")
    public ActorResponse getActorById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/actor")
    @ResponseStatus(HttpStatus.CREATED)
    public ActorResponse createActor(@Valid @RequestBody ActorRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public ActorResponse updateActor(@PathVariable Long id, @Valid @RequestBody ActorRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActor(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/error-test")
    public String errorTest() {
        throw new RuntimeException("Test error");
    }
}