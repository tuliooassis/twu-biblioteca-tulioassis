package com.twu.biblioteca.model;

import java.util.Objects;

public class Movie extends Item {
    private String title;
    private String director;
    private int year;
    private double rate;

    public Movie(int id, String title, String director, int year, double rate) {
        super(id);

        this.title = title;
        this.director = director;
        this.year = year;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "(" + this.getId() + ") Title:\t" + this.title +
                "\tDirector:\t" + this.director +
                "\tYear:\t" + this.year +
                "\tRate:\t" + this.rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return year == movie.year &&
                Double.compare(movie.rate, rate) == 0 &&
                Objects.equals(title, movie.title) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, director, year, rate);
    }
}
