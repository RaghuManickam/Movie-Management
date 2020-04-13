package entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
public class Multiplex {
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "multiplex")
    @Where(clause = "isDeleted = 'false'")
    @JsonManagedReference
    List<Screen> screens;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private Integer numberOfScreens;
    private boolean isDeleted;
    public Multiplex(List<Screen> screens, Integer id, String name, String address, Integer numberOfScreens, boolean isDeleted) {
        this.screens = screens;
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfScreens = numberOfScreens;
        this.isDeleted = isDeleted;
    }
    public Multiplex() {
    }

    public Multiplex(Integer id) {
        this.id = id;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfScreens() {
        return numberOfScreens;
    }

    public void setNumberOfScreens(Integer numberOfScreens) {
        this.numberOfScreens = numberOfScreens;
    }
}
