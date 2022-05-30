package com.niit.favouriteservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class UserFavourite {
    @Id
    private int userId;
    private String firstName;
    private String email;
    private String profilePic;
    private int age;
    private List<String> favouriteMovies;
    private List<String> preferredCategories;

    public UserFavourite(int userId, String firstName, String email, String profilePic, int age, List<String> favouriteMovies, List<String> preferredCategories) {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.profilePic = profilePic;
        this.age = age;
        this.favouriteMovies = favouriteMovies;
        this.preferredCategories = preferredCategories;
    }

    public UserFavourite() {
    }

    public UserFavourite(String firstName, String email, String profilePic, int age, List<String> favouriteMovies, List<String> preferredCategories) {
        this.firstName = firstName;
        this.email = email;
        this.profilePic = profilePic;
        this.age = age;
        this.favouriteMovies = favouriteMovies;
        this.preferredCategories = preferredCategories;
    }

    @Override
    public String toString() {
        return "UserFavourite{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", age=" + age +
                ", favouriteMovies=" + favouriteMovies +
                ", preferredCategories=" + preferredCategories +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getFavouriteMovies() {
        return favouriteMovies;
    }

    public void setFavouriteMovies(List<String> favouriteMovies) {
        this.favouriteMovies = favouriteMovies;
    }

    public List<String> getPreferredCategories() {
        return preferredCategories;
    }

    public void setPreferredCategories(List<String> preferredCategories) {
        this.preferredCategories = preferredCategories;
    }
}
