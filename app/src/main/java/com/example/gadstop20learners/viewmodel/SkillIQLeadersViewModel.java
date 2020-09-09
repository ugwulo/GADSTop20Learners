package com.example.gadstop20learners.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadstop20learners.model.SkillIQLeaders;
import com.example.gadstop20learners.services.APIService;
import com.example.gadstop20learners.services.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQLeadersViewModel extends ViewModel {

    private final String TAG = SkillIQLeadersViewModel.class.getSimpleName();

    MutableLiveData<List<SkillIQLeaders>> skillIQ;
    public LiveData<List<SkillIQLeaders>> getIQLeaders(){
        if (skillIQ == null){
            skillIQ = new MutableLiveData<>();
            getResponse();
        }
        return skillIQ;
    }

    private void getResponse() {
        APIService service = ServiceBuilder.buildGadsService(APIService.class);
        Call<List<SkillIQLeaders>> call = service.getSkillIQLeaders();
        call.enqueue(new Callback<List<SkillIQLeaders>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeaders>> call, Response<List<SkillIQLeaders>> response) {
                Log.d(TAG, "onResponse: Response Code " + response.message());
                skillIQ.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SkillIQLeaders>> call, Throwable t) {
                Log.d(TAG, "onFailure: Response Code " + t.getMessage());
                skillIQ.setValue(null);
            }
        });
    }
}
