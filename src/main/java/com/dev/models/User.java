package com.dev.models;

import com.dev.services.KeyGenerator;

import java.util.Set;

public class User{
    private long userId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String email;
    private String userPassword;
    private Role role = new Role();
    private Set<Privilege> privileges;

    public User() {
        setUserId(0);
    }

    public User(String firstName, String lastName, long phoneNumber, String email, String userPassword, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userPassword = userPassword;
        this.userId = KeyGenerator.generateKey();
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        if (userId == 0)
            this.userId = KeyGenerator.generateKey();
        else this.userId = userId;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", role=" + role +
                ", privileges=" + privileges +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Privilege> getPrivileges() {

        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

}