package controller;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.layout.HBox;

public class StarRatingControl extends HBox {
    private static final String STAR_PATH = "M15 2 L19.5 10.5 L28.5 10.5 L21 17.5 L24 26 L15 21 L6 26 L9 17.5 L1.5 10.5 L10.5 10.5 Z";
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final Color SELECTED_COLOR = Color.GOLD;

    private SVGPath[] stars;
    private int selectedIndex = -1;

    public StarRatingControl(int numStars) {
        stars = new SVGPath[numStars];
        
        for (int i = 0; i < numStars; i++) {
            SVGPath star = new SVGPath();
            star.setContent(STAR_PATH);
            star.setFill(DEFAULT_COLOR);
            
            star.setOnMouseClicked(this::handleStarClick);
            
            stars[i] = star;
            getChildren().add(star);
        }

        setSpacing(5);
        setPadding(new Insets(10));
    }

    private void handleStarClick(MouseEvent event) {
        SVGPath clickedStar = (SVGPath) event.getSource();
        int starIndex = indexOfStar(clickedStar);
        
        if (starIndex >= 0) {
            selectedIndex = starIndex;
            updateStarColors();
        }
    }

    private int indexOfStar(SVGPath star) {
        for (int i = 0; i < stars.length; i++) {
            if (stars[i] == star) {
                return i;
            }
        }
        return -1;
    }

    private void updateStarColors() {
        for (int i = 0; i < stars.length; i++) {
            if (i <= selectedIndex) {
                stars[i].setFill(SELECTED_COLOR);
            } else {
                stars[i].setFill(DEFAULT_COLOR);
            }
        }
    }
}
