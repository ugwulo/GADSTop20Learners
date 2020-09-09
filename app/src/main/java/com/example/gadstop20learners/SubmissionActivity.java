package com.example.gadstop20learners;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gadstop20learners.databinding.ActivitySubmissionBinding;
import com.example.gadstop20learners.databinding.SubmitDialogBinding;
import com.example.gadstop20learners.model.UserDetails;
import com.example.gadstop20learners.services.APIService;
import com.example.gadstop20learners.services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * class for project submission using Google form endpoint
 */
public class SubmissionActivity extends AppCompatActivity {
    ActivitySubmissionBinding mSubmissionBinding;
    private final String TAG = SubmissionActivity.class.getSimpleName();
    private String firstName, lastName, email, projectLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSubmissionBinding = ActivitySubmissionBinding.inflate(getLayoutInflater());
        setContentView(mSubmissionBinding.getRoot());

//        verifyInput();
        mSubmissionBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }


    private void showDialog() {
        final Dialog dialog = new Dialog(SubmissionActivity.this);
        SubmitDialogBinding dialogBinding = SubmitDialogBinding.inflate(getLayoutInflater());
        dialog.setContentView(dialogBinding.getRoot());

        dialogBinding.cancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialogBinding.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                submitProject();
            }
        });

        dialog.show();

    }

    private void verifyInput() {
        if (TextUtils.isEmpty(firstName)){
            mSubmissionBinding.txtFirstName.setError("Enter a valid input");
            return;
        }

        if (TextUtils.isEmpty(lastName)){
            mSubmissionBinding.txtLastName.setError("Enter a valid input");
            return;
        }

        if (TextUtils.isEmpty(email)){
            mSubmissionBinding.txtEmail.setError("Enter a valid input");
            return;
        }

        if (TextUtils.isEmpty(projectLink)){
            mSubmissionBinding.txtGithubLink.setError("Enter a valid input");
            return;
        }
    }

    private void submitProject() {
        mSubmissionBinding.progressBar.setVisibility(View.VISIBLE);

        firstName = mSubmissionBinding.txtFirstName.getText().toString();
        lastName = mSubmissionBinding.txtLastName.getText().toString();
        email = mSubmissionBinding.txtEmail.getText().toString();
        projectLink = mSubmissionBinding.txtGithubLink.getText().toString();

//        UserDetails userDetails = new UserDetails(firstName, lastName, email, projectLink);

        APIService service = ServiceBuilder.buildFormService(APIService.class);
        Call<Void> call = service.postProject(firstName, lastName, email, projectLink);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                mSubmissionBinding.progressBar.setVisibility(View.INVISIBLE);
//                Toast.makeText(SubmissionActivity.this, response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: " + response.code() + " " + response.message());
                Dialog successDialog = new Dialog(SubmissionActivity.this);
                successDialog.setContentView(R.layout.success_dialog);
                successDialog.show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                mSubmissionBinding.progressBar.setVisibility(View.INVISIBLE);
                Log.d(TAG, "onFailure: " + t.getMessage());

                  Dialog failureDialog = new Dialog(SubmissionActivity.this);
                  failureDialog.setContentView(R.layout.failure_dialog);
                  failureDialog.show();
            }
        });

    }
}