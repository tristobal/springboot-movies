package com.ido.movies.integration;

import io.cucumber.java8.En;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MoviesStep extends MoviesContent implements En {

    public MoviesStep() {
        Given("^The name of the movie '(.+)'$", this::setNameOfTheMovie);

        When("^The user consume the service hitting the '(.+)' endpoint$", this::execute);

        Then("^the services responded with a list of (\\d+) movies$", (Integer size) ->
            assertThat(size, is(this.quantityMovies))
        );
    }
}
