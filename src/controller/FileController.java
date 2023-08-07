package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Car;
import model.Rating;

public class FileController {
    private static final String CSV_FILE_PATH = "../assets/car-list.csv";
    private static final String RANDOM_ACCESS_FILE_PATH = "../assets/car-list.dat";

    public static List<Car> readCarsFromCSV() {
        List<Car> cars = new ArrayList<Car>();
        try {
            File file = new File(CSV_FILE_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] carData = line.split(",");
                Car car = new Car(carData[0], carData[1], carData[2], new Rating(carData[3]),
                        Double.parseDouble(carData[4]), carData[5], carData[6], Double.parseDouble(carData[7]),
                        carData[8]);
                cars.add(car);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    // display single car
    public static void displayCar(Car car) {
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Rating: " + car.getRating().getRating());
        System.out.println("Price: " + car.getPrice());
        System.out.println("Fuel Type: " + car.getFuelType());
        System.out.println("Transmission: " + car.getTransmission());
        System.out.println("Mileage: " + car.getMileage());
        System.out.println("Description: " + car.getDescription());
    }

    // display all cars
    public static void displayCars(List<Car> cars) {
        for (Car car : cars) {
            displayCar(car);
            System.out.println();
        }
    }

}
