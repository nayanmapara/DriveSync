package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Car;
import model.Rating;

public class FileController {
    private static final String CSV_FILE_PATH = "src/assets/car-list.csv";
    private static final String RANDOM_ACCESS_FILE_PATH = "src/assets/car-list.dat";

    public static List<Car> readCarsFromCSV() {
        List<Car> cars = new ArrayList<Car>();
        try {
            File file = new File(CSV_FILE_PATH);
            Scanner scanner = new Scanner(file);
            // skip first line
            scanner.nextLine();
            // read each line of the file and create a car object
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] carData = line.split(",");
                if (carData.length != 11) {
                    Car car = new Car(Integer.parseInt(carData[0]), carData[1], carData[2], carData[3],
                        new Rating(Integer.parseInt(carData[4])),
                        Double.parseDouble(carData[5]), carData[6], carData[7], Double.parseDouble(carData[8]),
                        carData[9]);
                    
                    cars.add(car);
                } else {
                    Car car = new Car(Integer.parseInt(carData[0]), carData[1], carData[2], carData[3],
                        new Rating(Integer.parseInt(carData[4])),
                        Double.parseDouble(carData[5]), carData[6], carData[7], Double.parseDouble(carData[8]),
                        carData[9], carData[10]);
                    
                    cars.add(car);}
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
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
            System.out.println(car.getModel());
            System.out.println();
        }
    }

    // random access file
    public static void writeCarsToRandomAccessFile(List<Car> cars) {
        try {
            File file = new File(RANDOM_ACCESS_FILE_PATH);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            for (Car car : cars) {
                randomAccessFile.writeUTF(car.getMake());
                randomAccessFile.writeUTF(car.getModel());
                randomAccessFile.writeUTF(car.getYear());
                randomAccessFile.write(car.getRating().getRating());
                randomAccessFile.writeDouble(car.getPrice());
                randomAccessFile.writeUTF(car.getFuelType());
                randomAccessFile.writeUTF(car.getTransmission());
                randomAccessFile.writeDouble(car.getMileage());
                randomAccessFile.writeUTF(car.getDescription());
                randomAccessFile.writeUTF(car.getImage());
            }
            randomAccessFile.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Update the rating in the CSV file using getRating() from StarRatingControl
    public static void updateRatingInCSV(int carId, int newRating) {
        List<Car> cars = readCarsFromCSV();

        for (Car car : cars) {
            if (car.getId() == carId) {
                car.getRating().setRating(newRating); // Update the rating in the Car object
                break;
            }
        }

        try {
            FileWriter writer = new FileWriter(CSV_FILE_PATH);
            writer.write("ID,Make,Model,Year,Rating,Price,FuelType,Transmission,Mileage,Description,Image\n");
            for (Car car : cars) {
                writer.write(car.getId() + "," + car.getMake() + "," + car.getModel() + "," + car.getYear() + "," +
                        car.getRating().getRating() + "," + car.getPrice() + "," + car.getFuelType() + "," +
                        car.getTransmission() + "," + car.getMileage() + "," + car.getDescription() + "," +
                        car.getImage() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage()); // Print the exception
        }
    }
}
