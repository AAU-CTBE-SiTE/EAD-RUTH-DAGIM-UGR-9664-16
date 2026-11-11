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
    public List<Actor> getActorDetails() {
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
        return "Actor created successfully";
    }

    @PutMapping("/update/{id}")
    public String updateActor(@PathVariable int id, @RequestBody Actor updated) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actor.setName(updated.getName());
                actor.setMovieName(updated.getMovieName());
                return "Actor updated successfully";
            }
        }
        return "Actor not found";
    }

    @PatchMapping("/patch/{id}")
    public String patchActor(@PathVariable int id, @RequestBody Actor updated) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {

                if (updated.getName() != null) {
                    actor.setName(updated.getName());
                }

                if (updated.getMovieName() != null) {
                    actor.setMovieName(updated.getMovieName());
                }

                return "Actor partially updated successfully";
            }
        }
        return "Actor not found";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteActor(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actors.remove(actor);
                return "Actor deleted successfully";
            }
        }
        return "Actor not found";
    }
}
