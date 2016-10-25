package main.java.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A class representing a general User
 */
public class User {
    private StringProperty _firstName = new SimpleStringProperty();
    private StringProperty _lastName = new SimpleStringProperty();
    private StringProperty _username = new SimpleStringProperty();
    private StringProperty _password = new SimpleStringProperty();
    private Type _type = Type.USER;
    private Profile userProfile;
    private boolean hasProfile;

    /**
     * User constructor
     * @param firstName user's first name
     * @param lastName user's last name
     * @param username user's username
     * @param password user's password
     * @param type user's profile type
     */
    public User(String firstName, String lastName, String username, String password, String type) {
        _firstName.set(firstName);
        _lastName.set(lastName);
        _username.set(username);
        _password.set(password);
        type = type.toLowerCase();
        switch(type.charAt(0)){
            case 'u':
                _type = Type.USER;
                break;
            case 'm':
                _type = Type.MANAGER;
                break;
            case 'w':
                _type = Type.WORKER;
                break;
            case 'a':
                _type = Type.ADMIN;
                break;
        }
    }

    /**
     * A getter that returns the user's username
     *
     * @return the user's username
     */
    public String getUserName() { return _username.get(); }

    /**
     * A setter that sets the user's username
     *
     */
    public void setUserName(String uName) { _username.set(uName); }

    /**
     * A getter that returns the user's password
     *
     * @return the user's password
     */
    public String getPassword() {return _password.get(); }

    /**
     * A setter that sets the user's password
     *
     */
    public void setPassword(String pass) { _password.set(pass); }

    /**
     * A getter that returns the user's first name
     *
     * @return the user's first name
     */
    public String getFirstName() {return _firstName.get(); }

    /**
     * A setter that sets the user's first name
     *
     */
    public void setFirstName(String first) { _firstName.set(first); }

    /**
     * A getter that returns the user's last name
     *
     * @return the user's last name
     */
    public String getLastName() {return _lastName.get(); }

    /**
     * A setter that sets the user's last name
     *
     */
    public void setLastName(String last) { _lastName.set(last); }


    /**
     * A getter that returns the user's profile type (User, Worker, Admin, etc.)
     *
     * @return the user's profile type
     */
    public Type getType() {return _type;}


    /**
     * A setter that sets the user's profile type (User, Worker, Admin, etc.)
     *
     */
    public void setType(Type userType) { _type = userType; }

    /**
     * Associates a new Profile with a user
     *
     * @param profile the user's profile
     */
    public void addProfile(Profile profile) {
        userProfile = profile;
        hasProfile = true;
    }

    /**
     * A getter that returns the user's Profile object
     *
     * @return a Profile object associated with this user
     */
    public Profile getProfile() {return userProfile;}

    /**
     * Generates a string containing a user's name, last name, username,
     * password, and profile type
     * @return a string representation of a user with the above characteristics
     */
    public String toString() {
        if(userProfile == null) {
            return "Name: " + _firstName.get() + " " + _lastName.get() + "\n" +
                    "Username: " + _username.get() + "\n" + "Password: " + _password.get() +
                    "\n" + "Type: " + _type + "\n";
        } else {
            return "Name: " + _firstName.get() + " " + _lastName.get() + "\n" +
                    "Username: " + _username.get() + "\n" + "Password: " + _password.get() +
                    "\n" + "Type: " + _type + "\n" + userProfile.toString() + "\n";
        }

    }

    /**
     * Checks if a user has a Profile, used for allowing a user to edit/add a
     * profile
     *
     * @return whether or not a user has a profile associated with it
     */
    public boolean hasProfile() {
        return hasProfile;
    }
    public enum Type {
        USER, WORKER, MANAGER, ADMIN
    }
}