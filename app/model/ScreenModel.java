package model;

import entity.Movie;
import entity.Multiplex;

public class ScreenModel {

    private Integer id;
    private Integer ScreenNumber;
    private Multiplex multiplex;
    private Movie movie;
    private boolean isDeleted;

    public ScreenModel() {
    }

    public ScreenModel(Integer id, Integer screenNumber, Multiplex multiplex, Movie movie, boolean isDeleted) {
        this.id = id;
        ScreenNumber = screenNumber;
        this.multiplex = multiplex;
        this.movie = movie;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "ScreenModel{" +
                "id=" + id +
                ", ScreenNumber=" + ScreenNumber +
                ", multiplex=" + multiplex +
                ", movie=" + movie +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScreenNumber() {
        return ScreenNumber;
    }

    public void setScreenNumber(Integer screenNumber) {
        ScreenNumber = screenNumber;
    }

    public Multiplex getMultiplex() {
        return multiplex;
    }

    public void setMultiplex(Multiplex multiplex) {
        this.multiplex = multiplex;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
