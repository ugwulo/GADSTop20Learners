package com.example.gadstop20learners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gadstop20learners.databinding.ActivityMainBinding;
import com.example.gadstop20learners.ui.main.SkillIqLeadersFragment;
import com.example.gadstop20learners.ui.main.LearningLeadersFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gadstop20learners.ui.main.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mMainBinding;
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    SkillIqLeadersFragment mSkillIqLeadersFragment = new SkillIqLeadersFragment();
    LearningLeadersFragment mLearningLeadersFragment = new LearningLeadersFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mMainBinding.getRoot());
//        setSupportActionBar(mMainBinding.toolbar);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(mSkillIqLeadersFragment);
        viewPagerAdapter.addFragment(mLearningLeadersFragment);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        mMainBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SubmissionActivity.class));
            }
        });
    }
}