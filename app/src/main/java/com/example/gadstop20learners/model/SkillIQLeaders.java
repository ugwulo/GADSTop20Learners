package com.example.gadstop20learners.model;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

/**
 * POJO class for {@link SkillIQLeaders} for parsing JSON response using
 * {@link retrofit2.converter.gson.GsonConverterFactory} or {@link com.squareup.moshi.Moshi}
 */
public class SkillIQLeaders {

    @Json(name = "name")
    @SerializedName("name")
    public String name;

    @Json(name = "skillIq")
    @SerializedName("skilliq")
    public int skillIq;

    @Json(name = "country")
    @SerializedName("country")
    public String country;

    @Json(name = "badgeUrl")
    @SerializedName("badgeUrl")
    public String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillIq() {
        return skillIq;
    }

    public void setSkillIq(int skillIq) {
        this.skillIq = skillIq;
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
