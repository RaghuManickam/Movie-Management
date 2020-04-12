package model;

import play.data.validation.Constraints;

import java.util.List;

public class MultiplexModel {
    List<ScreenModel> screens;
    private Integer id;
    @Constraints.Required(message = "Multiplex name not provided")
    private String name;
    @Constraints.Required(message = "Address not provided")
    private String address;
    @Constraints.Required(message = "Number of Screens not provided")
    private Integer numberOfScreens;
    private boolean isDeleted;
    public MultiplexModel(List<ScreenModel> screens, Integer id, @Constraints.Required(message = "Multiplex name not provided") String name, @Constraints.Required(message = "Address not provided") String address, @Constraints.Required(message = "Number of Screens not provided") Integer numberOfScreens, boolean isDeleted) {
        this.screens = screens;
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfScreens = numberOfScreens;
        this.isDeleted = isDeleted;
    }
    public MultiplexModel() {
    }

    @Override
    public String toString() {
        return "MultiplexModel{" +
                "screens=" + screens +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberOfScreens=" + numberOfScreens +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public List<ScreenModel> getScreens() {
        return screens;
    }

    public void setScreens(List<ScreenModel> screens) {
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
