package com.site.actor_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    protected Actor() {}

    public Actor(String name, String movieName) {
        this.name = name;
        this.movieName = movieName;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMovieName() { return movieName; }

    public void setName(String name) { this.name = name; }
    public void setMovieName(String movieName) { this.movieName = movieName; }
}