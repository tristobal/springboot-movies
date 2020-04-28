package com.ido.movies.integration;

import com.ido.movies.MoviesApplication;
import com.ido.movies.domain.Movie;
import com.ido.movies.domain.ParentResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest(
        classes = MoviesApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ContextConfiguration
public class MoviesContent {

    @LocalServerPort
    protected int port;

    private TestRestTemplate restTemplate;

    private String movieName;

    protected int quantityMovies;

    public MoviesContent() {
        this.restTemplate = new TestRestTemplate();
    }

    public void setNameOfTheMovie(String title) {
        this.movieName = title;
    }

    public void execute(String resource) {
        ResponseEntity<List> entity = restTemplate.getForEntity(getUrl(resource, movieName), List.class);
        quantityMovies = entity.getBody().size();
    }

    private String getUrl(String resource, String title) {
        return new StringBuilder("http://localhost:")
                .append(port)
                .append("/")
                .append(resource)
                .append("?title=")
                .append(title)
                .toString();
    }
}
