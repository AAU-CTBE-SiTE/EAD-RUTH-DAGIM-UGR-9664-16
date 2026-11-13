package com.site.actor_management.controller;

import com.site.actor_management.model.Actor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {

    List<Actor> actors = new ArrayList<>();

    public ActorController() {
        actors.add(new Actor(1, "John Doe", "The Great Adventure"));
        actors.add(new Actor(2, "Jane Smith", "Mystery Island"));
    }

    @GetMapping("/actor")
    public List<Actor> getActors() {
        return actors;
    }

    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return actor;
            }
        }
        return null;
    }

    @PostMapping("/actor")
    public String createActor(@RequestBody Actor actor) {
        actors.add(actor);
        return "Actor created";
    }

    @PutMapping("/update/{id}")
    public String updateActor(@PathVariable int id, @RequestBody Actor newActor) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actor.setName(newActor.getName());
                actor.setMovieName(newActor.getMovieName());
                return "Actor updated";
            }
        }
        return "Actor not found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteActor(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actors.remove(actor);
                return "Actor deleted";
            }
        }
        return "Actor not found";
    }

    @GetMapping("/error-test")
    public String errorTest() {
        throw new RuntimeException("Test error");
    }
}