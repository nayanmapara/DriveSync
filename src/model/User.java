package model;

public class User {
    // user fields
    private String username;
    private String password;

    // no arg constructor
    public User() {
    }

    // constructor with all the fields
    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

    // getters and setters
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {

        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public void setPassword(String password) {
        this.password = password;

    }

}
