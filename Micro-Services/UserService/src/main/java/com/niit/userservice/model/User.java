package com.niit.userservice.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="user", uniqueConstraints = {@UniqueConstraint(name = "email_unique",columnNames = {"email"})})
public class User {
    @Id
    @GeneratedValue
    int userId;

    String firstName;
    String lastName;
    String email;
    String contactNo;
    String password;
    @Column(columnDefinition="LONGTEXT")
    String profilePic;
    int age;
    String[] preferedCategories;

    public User() {

    }

    public User(int userId, String firstName, String lastName, String email, String contactNo, String password, String profilePic, int age, String[] preferedCategories) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
        this.password = password;
        this.profilePic = profilePic;
        this.age = age;
        this.preferedCategories = preferedCategories;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String[] getPreferedCategories() {
        return preferedCategories;
    }

    public void setPreferedCategories(String[] preferedCategories) {
        this.preferedCategories = preferedCategories;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", password='" + password + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", age=" + age +
                ", preferedCategories=" + Arrays.toString(preferedCategories) +
                '}';
    }


}
