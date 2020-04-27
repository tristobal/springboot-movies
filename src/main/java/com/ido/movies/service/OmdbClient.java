package com.ido.movies.service;

import com.ido.movies.domain.Movie;
import com.ido.movies.domain.ParentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OmdbClient {

    @Value("${omdb.key}")
    private String key;

    @Value("${omdb.url}")
    private String url;

    private RestTemplate restTemplate;

    public OmdbClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getMovies(String title) {
        return restTemplate.getForEntity(url, ParentResponse.class, key, title)
                .getBody()
                .getSearch();
    }
}
