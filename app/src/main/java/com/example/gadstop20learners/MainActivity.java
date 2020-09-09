package com.example.gadstop20learners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadstop20learners.databinding.ActivityMainBinding;
import com.example.gadstop20learners.ui.main.SkillIQLeadersFragment;
import com.example.gadstop20learners.ui.main.LearningLeadersFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gadstop20learners.ui.main.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mMainBinding;
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    SkillIQLeadersFragment mSkillIQLeadersFragment = new SkillIQLeadersFragment();
    LearningLeadersFragment mLearningLeadersFragment = new LearningLeadersFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mMainBinding.getRoot());
//        setAppBarHeight();
//        setSupportActionBar(mMainBinding.toolbar);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(mLearningLeadersFragment);
        viewPagerAdapter.addFragment(mSkillIQLeadersFragment);

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

    private void setAppBarHeight() {
        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        appBarLayout.setLayoutParams(new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight()));

    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    private int dpToPx(int dp) {
        float density = getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }
}