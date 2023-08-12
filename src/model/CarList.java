package model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> cars;

    // no arg constructor
    public CarList() {
        cars = new ArrayList<>();
    }

    // constructor with all the fields
    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    // getters and setters
    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

}
