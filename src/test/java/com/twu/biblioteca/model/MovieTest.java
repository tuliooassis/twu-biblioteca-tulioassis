package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    Movie movie;

    @Before
    public void setup() {
        this.movie = new Movie(1, "Title 1", "Director 1", 2020, 10.0);
    }

    @Test
    public void movieStringShouldBeCorrect() {
        String movieStringExpected = "(1) Title:\tTitle 1\tDirector:\tDirector 1\tYear:\t2020\tRate:\t10.0";

        String movieStringAtual = this.movie.toString();

        assertEquals(movieStringExpected, movieStringAtual);
    }

}
