package com.example.gadstop20learners.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadstop20learners.R;
import com.example.gadstop20learners.databinding.FragmentIqLeadersBinding;
import com.example.gadstop20learners.model.SkillIQLeaders;
import com.example.gadstop20learners.viewmodel.SkillIQLeadersViewModel;

import java.util.List;
import java.util.Objects;

public class SkillIQLeadersFragment extends Fragment {
    FragmentIqLeadersBinding mBinding;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentIqLeadersBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();

        recyclerView = mBinding.iqRecyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        SkillIQLeadersViewModel viewModel = new ViewModelProvider(getActivity()).get(SkillIQLeadersViewModel.class);
        viewModel.getIQLeaders().observe(getActivity(), new Observer<List<SkillIQLeaders>>() {
            @Override
            public void onChanged(List<SkillIQLeaders> skillIQLeaders) {
                recyclerView.setAdapter(new SkillIQAdapter(skillIQLeaders));
            }
        });
        return view;
    }
}