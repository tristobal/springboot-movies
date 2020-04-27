package com.ido.movies.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class Movie {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    private String imdbID;

    @JsonProperty("Type")
    private Type type;

    @JsonProperty("Poster")
    private String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Movie movie = (Movie) o;

        if (!Objects.equals(title, movie.title)) {
            return false;
        }
        if (!Objects.equals(year, movie.year)) {
            return false;
        }
        if (!Objects.equals(imdbID, movie.imdbID)) {
            return false;
        }
        if (!Objects.equals(type, movie.type)) {
            return false;
        }
        return Objects.equals(poster, movie.poster);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (imdbID != null ? imdbID.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "Movie" + "[", "]")
                .add("title='" + title + "'")
                .add("year=" + year)
                .add("imdbID='" + imdbID + "'")
                .add("type='" + type + "'")
                .add("poster='" + poster + "'")
                .toString();
    }
}
