package com.ido.movies.service;

import com.ido.movies.domain.Movie;
import com.ido.movies.domain.ParentResponse;
import com.ido.movies.fixture.DomainFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OmdbClientTest {

    @Mock
    private RestTemplate restTemplate;

    private OmdbClient client;

    @BeforeEach
    void setUp() {
        client = new OmdbClient(restTemplate);
        ReflectionTestUtils.setField(client, "key", "key");
        ReflectionTestUtils.setField(client, "url", "url");
    }

    @Test
    void shouldReturnAListOfMovies() {
        ResponseEntity<ParentResponse> responseEntity = new ResponseEntity<>(DomainFixture.getParentResponse(), HttpStatus.OK);
        
        when(restTemplate.getForEntity(anyString(), eq(ParentResponse.class), ArgumentMatchers.<String>any()))
                .thenReturn(responseEntity);

        List<Movie> actualResponse = client.getMovies("any_title");

        assertThat(responseEntity.getBody().getSearch(), is(actualResponse));
    }
}