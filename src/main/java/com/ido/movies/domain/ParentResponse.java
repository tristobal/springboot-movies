package com.ido.movies.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class ParentResponse {

    @JsonProperty("Search")
    private List<Movie> search;
    private Integer totalResults;

    public List<Movie> getSearch() {
        return search;
    }

    public void setSearch(List<Movie> search) {
        this.search = search;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ParentResponse that = (ParentResponse) o;

        if (!Objects.equals(search, that.search)) {
            return false;
        }
        return Objects.equals(totalResults, that.totalResults);
    }

    @Override
    public int hashCode() {
        int result = search != null ? search.hashCode() : 0;
        result = 31 * result + (totalResults != null ? totalResults.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "ParentResponse" + "[", "]")
                .add("search=" + search)
                .add("totalResults=" + totalResults)
                .toString();
    }
}
