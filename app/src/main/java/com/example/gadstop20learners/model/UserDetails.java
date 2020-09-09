package com.example.gadstop20learners.model;

import com.google.gson.annotations.SerializedName;

/**
 * POJO class for {@link UserDetails} for getting learner details during project submission
 */
public class UserDetails {
    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("email")
    private String email;

    @SerializedName("projectLink")
    private String projectLink;

    public UserDetails(String firstName, String lastName, String email, String projectLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.projectLink = projectLink;
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

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
}
