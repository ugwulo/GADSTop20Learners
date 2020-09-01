package com.example.gadstop20learners.services;

import com.example.gadstop20learners.model.LearningHours;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HoursService {
    @GET("api/hours")
    Call<List<LearningHours>> getHours();
}
