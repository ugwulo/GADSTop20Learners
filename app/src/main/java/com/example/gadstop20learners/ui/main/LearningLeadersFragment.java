package com.example.gadstop20learners.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.example.gadstop20learners.model.LearningHours;
import com.example.gadstop20learners.viewmodel.HoursViewModel;

import java.util.List;


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

        HoursViewModel viewModel = new ViewModelProvider(getActivity()).get(HoursViewModel.class);
        viewModel.getLearnerHours().observe(getActivity(), new Observer<List<LearningHours>>() {
            @Override
            public void onChanged(List<LearningHours> hoursList) {
                recyclerView.setAdapter(new LearningLeadersAdapter(hoursList));
            }
        });
        return view;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
//
//        HoursViewModel viewModel = new ViewModelProvider(getActivity()).get(HoursViewModel.class);
//        viewModel.getLearnerHours().observe(getActivity(), new Observer<List<LearningHours>>() {
//            @Override
//            public void onChanged(List<LearningHours> hoursList) {
//                recyclerView.setAdapter(new LearningLeadersAdapter(hoursList));
//            }
//        });
//    }
}