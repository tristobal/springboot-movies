package com.ido.movies.domain.builder;

import com.ido.movies.domain.Movie;
import com.ido.movies.domain.ParentResponse;

import java.util.List;

public final class ParentResponseBuilder {
    private List<Movie> search;
    private Integer totalResults;

    private ParentResponseBuilder() {
    }

    public static ParentResponseBuilder aParentResponse() {
        return new ParentResponseBuilder();
    }

    public ParentResponseBuilder withSearch(List<Movie> search) {
        this.search = search;
        return this;
    }

    public ParentResponseBuilder withTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    public ParentResponse build() {
        ParentResponse parentResponse = new ParentResponse();
        parentResponse.setSearch(search);
        parentResponse.setTotalResults(totalResults);
        return parentResponse;
    }
}
