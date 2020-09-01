package com.example.gadstop20learners.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadstop20learners.model.LearningHours;
import com.example.gadstop20learners.services.HoursService;
import com.example.gadstop20learners.services.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HoursViewModel extends ViewModel {
    public final String TAG = getClass().getSimpleName();
    Context mContext;
    MutableLiveData<List<LearningHours>> learnerHours;

    public LiveData<List<LearningHours>> getLearnerHours(){
        if (learnerHours == null){
            learnerHours = new MutableLiveData<>();
            getResponse();
        }
        return learnerHours;
    }

    private void getResponse() {
        HoursService service = ServiceBuilder.builderService(HoursService.class);
        Call<List<LearningHours>> call = service.getHours();
        call.enqueue(new Callback<List<LearningHours>>() {
            @Override
            public void onResponse(Call<List<LearningHours>> call, Response<List<LearningHours>> response) {
                Log.d(TAG, "onResponse: Getting API response");
                learnerHours.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LearningHours>> call, Throwable t) {
                Log.d(TAG, "onFailure: Failed to get Response");
                learnerHours.setValue(null);
            }
        });
    }
}
