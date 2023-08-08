package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Car;

import java.util.List;

public class CarDetailsController {
    // Index of the current car being displayed
    private int currentIndex = 0;

    // FXML fields
    @FXML
    private ImageView carImageView;

    @FXML
    private Text carNameText;

    @FXML
    private SplitPane splitPane;

    @FXML
    private TextArea featuresTextArea;

    @FXML
    private TextArea specificationsTextArea;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ScrollPane descriptionScrollPane;

    @FXML
    private HBox ratingStarsHBox;

    @FXML
    private HBox paginationHBox;

    @FXML
    private Button previousButton;

    @FXML
    private Text pageNumberText;

    @FXML
    private Button nextButton;

    private List<Car> cars;

    public void initialize() {
        // Load and set the car image using the controller
        Image carImage = new Image(getClass().getResourceAsStream("/assets/images/car.jpg"));
        carImageView.setImage(carImage);

        // Set up cars from CSV file
        cars = FileController.readCarsFromCSV();

        if (!cars.isEmpty()) {
            // Display the first car's details
            displayCarDetails(cars.get(0));
        }
    }

    private void displayCarDetails(Car car) {
        carNameText.setText(car.getMake() + " " + car.getModel());
        featuresTextArea.setText("Fuel Type: " + car.getFuelType() +
                "\nTransmission: " + car.getTransmission() +
                "\nMileage: " + car.getMileage() +
                "\nCar Type: " + car.getYear()); // Update with the correct fields

        // Show rating stars
        StarRatingControl starRatingControl = new StarRatingControl(10, car.getRating().getRating());
        starRatingControl.setRatingUpdateCallback(newRating -> {
            FileController.updateRatingInCSV(car.getId(), newRating);
            car.getRating().setRating(newRating); // Update the rating in the Car object
            displayCarDetails(car); // Update the displayed details
        });
        ratingStarsHBox.getChildren().clear();
        ratingStarsHBox.getChildren().add(starRatingControl);

        // Set image using the url
        String imageUrl = car.getImage();
        Image carImages = new Image(imageUrl);
        carImageView.setImage(carImages);

        // Set specifications and description
        specificationsTextArea.setText("Rating: " + car.getRating().getRating() +
                "\nPrice: " + car.getPrice());
        descriptionTextArea.setText(car.getDescription());

        // Update page number
        pageNumberText.setText((currentIndex + 1) + " / " + cars.size());
    }

    @FXML
    private void handlePreviousButtonAction() {
        if (!cars.isEmpty()) {
            currentIndex = (currentIndex - 1 + cars.size()) % cars.size();
            displayCarDetails(cars.get(currentIndex));
        }
    }

    @FXML
    private void handleNextButtonAction() {
        if (!cars.isEmpty()) {
            currentIndex = (currentIndex + 1) % cars.size();
            displayCarDetails(cars.get(currentIndex));
        }
    }
}
