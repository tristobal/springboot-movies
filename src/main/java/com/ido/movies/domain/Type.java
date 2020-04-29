package com.ido.movies.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    GAME("game"),
    MOVIE("movie"),
    SERIES("series"),
    EPISODE("episode");

    private String name;

    Type(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
