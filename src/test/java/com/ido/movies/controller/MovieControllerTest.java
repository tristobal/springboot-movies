package com.ido.movies.controller;

import com.ido.movies.domain.Movie;
import com.ido.movies.domain.Type;
import com.ido.movies.domain.builder.MovieBuilder;
import com.ido.movies.fixture.DomainFixture;
import com.ido.movies.service.OmdbClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {

    @Mock
    private OmdbClient client;

    private MovieController controller;

    @BeforeEach
    void setUp() {
        controller = new MovieController(client);
    }

    @Test
    void shouldReturnAListOfMovies() {
        List<Movie> expectedMovies = DomainFixture.getMovies();
        when(client.getMovies(anyString())).thenReturn(expectedMovies);

        List<Movie> actualMovies = controller.getMovies("any_title");

        assertThat(expectedMovies, is(actualMovies));
    }


}