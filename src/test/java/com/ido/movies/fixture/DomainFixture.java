package com.ido.movies.fixture;

import com.ido.movies.domain.Movie;
import com.ido.movies.domain.ParentResponse;
import com.ido.movies.domain.Type;
import com.ido.movies.domain.builder.MovieBuilder;
import com.ido.movies.domain.builder.ParentResponseBuilder;

import java.util.Collections;
import java.util.List;

public class DomainFixture {

    public static List<Movie> getMovies() {
        return Collections.singletonList(MovieBuilder.aMovie()
                .withImdbID("tt9335498")
                .withTitle("Demon Slayer: Kimetsu No Yaiba")
                .withType(Type.series)
                .withPoster("https://m.media-amazon.com/images/M/MV5BZjZjNzI5MDctY2Y4YS00NmM4LTljMmItZTFkOTExNGI3ODRhXkEyXkFqcGdeQXVyNjc3MjQzNTI@._V1_SX300.jpg")
                .build());
    }

    public static ParentResponse getParentResponse() {
        return ParentResponseBuilder.aParentResponse()
                .withSearch(getMovies())
                .withTotalResults(1)
                .build();
    }
}
