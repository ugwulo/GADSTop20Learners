package com.example.gadstop20learners.model;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

/**
 * POJO class for {@link LearningLeaders} for parsing JSON response using
 * {@link retrofit2.converter.gson.GsonConverterFactory} or {@link com.squareup.moshi.Moshi}
 */
public class LearningLeaders {

    @SerializedName("name")
//    @Json(name = "name")
    public String name;

    @SerializedName("hours")
//    @Json(name = "hours")
    public int hours;

    @SerializedName("country")
//    @Json(name = "country")
    public String country;

    @SerializedName("badgeUrl")
//    @Json(name = "badgeUrl")
    public String badgeUrl;

    public LearningLeaders(String name, int hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

}
