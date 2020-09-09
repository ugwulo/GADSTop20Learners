package com.example.gadstop20learners.services;

import com.example.gadstop20learners.model.LearningLeaders;
import com.example.gadstop20learners.model.SkillIQLeaders;
import com.example.gadstop20learners.model.UserDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    String gadsFormEndpoint = "1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";
//    String test = "https://docs.google.com/forms/d/e/1FAIpQLSdI3KvN6QNnQRP8uwr5_WO2CMDECrGw3xR_y41FbVm_avgMtQ/viewform?usp=sf_link";
    String skillIQLeadersEndpoint = "/api/skilliq";
    String learningLeadersEndpoint = "/api/hours";

    /**
     * end points for {@value learningLeadersEndpoint} Learning Leaders
     */
    @GET(learningLeadersEndpoint)
    Call<List<LearningLeaders>> getLearningLeaders();

    /**
     * end point for {@value  skillIQLeadersEndpoint} skill IQ Leaders
     */
    @GET(skillIQLeadersEndpoint)
    Call<List<SkillIQLeaders>> getSkillIQLeaders();


    @Headers("Content-Type:application/json")
    @POST(gadsFormEndpoint)
    @FormUrlEncoded
    Call<Void> postProject(@Field("entry.1824927963") String email,
                                  @Field("entry.1877115667") String firstName,
                                  @Field("entry.2006916086") String lastName,
                                  @Field("entry.284483984") String projectLink
    );


//    Email Address = entry.1824927963
//Name = entry.1877115667
//Last Name = entry.2006916086
//Link to project = entry.284483984
}
