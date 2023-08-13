package controller;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.layout.HBox;

import java.util.function.Consumer;

public class StarRatingControl extends HBox {
    // SVG path for the star shape
    private static final String STAR_PATH = "M15 2 L19.5 10.5 L28.5 10.5 L21 17.5 L24 26 L15 21 L6 26 L9 17.5 L1.5 10.5 L10.5 10.5 Z";
    // variables for the colors of the stars
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final Color SELECTED_COLOR = Color.GOLD;

    // array of SVGPath objects to store the stars
    private SVGPath[] stars;
    // index of the selected star
    private int selectedIndex = -1;
    // callback function to update the rating
    private Consumer<Integer> ratingUpdateCallback;

    // constructors
    public StarRatingControl() {
        this(10, 0);
    }

    public StarRatingControl(int numStars, int defaultRating) {
        stars = new SVGPath[numStars];

        for (int i = 0; i < numStars; i++) {
            // Create a new SVGPath object for each star
            SVGPath star = new SVGPath();
            // Set the content of the SVGPath object to the star path
            star.setContent(STAR_PATH);
            star.setFill(i < defaultRating ? SELECTED_COLOR : DEFAULT_COLOR); // Set color based on default rating

            star.setOnMouseClicked(this::handleStarClick);

            stars[i] = star;
            getChildren().add(star);
        }

        setSpacing(5);
        setPadding(new Insets(10));
    }

    // Set the callback function to update the rating
    public void setRatingUpdateCallback(Consumer<Integer> callback) {
        this.ratingUpdateCallback = callback;
    }

    // Handle the click event on the star
    private void handleStarClick(MouseEvent event) {
        SVGPath clickedStar = (SVGPath) event.getSource();
        int starIndex = indexOfStar(clickedStar);

        if (starIndex >= 0) {
            selectedIndex = starIndex;
            updateStarColors();

            if (ratingUpdateCallback != null) {
                ratingUpdateCallback.accept(selectedIndex + 1);
            }
        }
    }

    // Get the index of the star
    private int indexOfStar(SVGPath star) {
        for (int i = 0; i < stars.length; i++) {
            if (stars[i] == star) {
                return i;
            }
        }
        return -1;
    }

    // Update the colors of the stars
    private void updateStarColors() {
        for (int i = 0; i < stars.length; i++) {
            if (i <= selectedIndex) {
                stars[i].setFill(SELECTED_COLOR);
            } else {
                stars[i].setFill(DEFAULT_COLOR);
            }
        }
    }

    // Get the rating
    public int getRating() {
        return selectedIndex + 1;
    }
}
