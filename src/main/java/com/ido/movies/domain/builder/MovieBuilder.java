package com.ido.movies.domain.builder;

import com.ido.movies.domain.Movie;
import com.ido.movies.domain.Type;

public final class MovieBuilder {
    private String title;
    private String year;
    private String imdbID;
    private Type type;
    private String poster;

    private MovieBuilder() {
    }

    public static MovieBuilder aMovie() {
        return new MovieBuilder();
    }

    public MovieBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder withYear(String year) {
        this.year = year;
        return this;
    }

    public MovieBuilder withImdbID(String imdbID) {
        this.imdbID = imdbID;
        return this;
    }

    public MovieBuilder withType(Type type) {
        this.type = type;
        return this;
    }

    public MovieBuilder withPoster(String poster) {
        this.poster = poster;
        return this;
    }

    public Movie build() {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setImdbID(imdbID);
        movie.setType(type);
        movie.setPoster(poster);
        return movie;
    }
}
