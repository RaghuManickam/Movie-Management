package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer ScreenNumber;
    @ManyToOne
    @Where(clause = "isDeleted = 'false'")
    @JsonBackReference
    private Multiplex multiplex;
    @ManyToOne
    @Where(clause = "isDeleted = 'false'")
    @JsonBackReference
    private Movie movie;
    private boolean isDeleted;

    public Screen() {
    }

    public Screen(Integer id, Integer screenNumber, Multiplex multiplex, Movie movie, boolean isDeleted) {
        this.id = id;
        ScreenNumber = screenNumber;
        this.multiplex = multiplex;
        this.movie = movie;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Screen{" +
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
