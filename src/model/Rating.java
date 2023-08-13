package model;

public class Rating {
    // rating field
    private int rating;

    // no arg constructor
    public Rating() {
    }

    // constructor with all the fields
    public Rating(int rating) {
        this.rating = rating;
    }

    // getters and setters
    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;

    }
}
