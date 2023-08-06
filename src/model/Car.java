package model;

// car class for the car object
public class Car {
    private String make;
    private String model;
    private String year;
    private Rating rating;
    private double price;
    private String fuelType;
    private String transmission;
    private double mileage;
    private String description;

    // no arg constructor
    public Car() {
    }

    // constructor with all the fields
    public Car(String make, String model, String year, Rating rating, double price, String fuelType,
            String transmission, double mileage, String description) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rating = rating;
        this.price = price;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.mileage = mileage;
        this.description = description;
    }

    // getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;

    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;

    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;

    }

    public String getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;

    }

    public String getTransmission() {
        return this.transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;

    }

    public double getMileage() {
        return this.mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;

    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;

    }

}
