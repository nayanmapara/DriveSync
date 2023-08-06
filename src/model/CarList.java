package model;

public class CarList {
    private Car[] cars;

    public CarList() {
        cars = new Car[0];
    }

    public CarList(Car[] cars) {
        this.cars = cars;
    }
}
