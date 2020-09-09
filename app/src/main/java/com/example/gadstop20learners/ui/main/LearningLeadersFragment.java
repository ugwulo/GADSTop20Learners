package com.example.gadstop20learners.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadstop20learners.R;
import com.example.gadstop20learners.databinding.FragmentLearningLeadersBinding;
import com.example.gadstop20learners.model.LearningLeaders;
import com.example.gadstop20learners.viewmodel.LearningLeadersViewModel;

import java.util.List;
import java.util.Objects;


public class LearningLeadersFragment extends Fragment {
    FragmentLearningLeadersBinding mLeadersBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mLeadersBinding = FragmentLearningLeadersBinding.inflate(getLayoutInflater());
        View view = mLeadersBinding.getRoot();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        LearningLeadersViewModel viewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(LearningLeadersViewModel.class);
        viewModel.getLearnerHours().observe(getActivity(), new Observer<List<LearningLeaders>>() {
            @Override
            public void onChanged(List<LearningLeaders> hoursList) {
                recyclerView.setAdapter(new LearningLeadersAdapter(hoursList));
            }
        });
        return view;
    }

}