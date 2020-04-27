package com.ido.movies.controller;

import com.ido.movies.domain.Movie;
import com.ido.movies.service.OmdbClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private OmdbClient client;

    public MovieController(OmdbClient client) {
        this.client = client;
    }

    @GetMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovies(@RequestParam String title) {
        return client.getMovies(title);
    }
}
