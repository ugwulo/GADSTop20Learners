package com.example.gadstop20learners.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadstop20learners.model.LearningLeaders;
import com.example.gadstop20learners.services.APIService;
import com.example.gadstop20learners.services.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersViewModel extends ViewModel {
    public final String TAG = getClass().getSimpleName();

    MutableLiveData<List<LearningLeaders>> learnerHours;

    public LiveData<List<LearningLeaders>> getLearnerHours(){
        if (learnerHours == null){
            learnerHours = new MutableLiveData<>();
            getResponse();
        }
        return learnerHours;
    }

    private void getResponse() {
        APIService service = ServiceBuilder.buildGadsService(APIService.class);
        Call<List<LearningLeaders>> call = service.getLearningLeaders();
        call.enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                Log.d(TAG, "onResponse: " + response.message());
                learnerHours.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                learnerHours.setValue(null);
            }
        });
    }
}
