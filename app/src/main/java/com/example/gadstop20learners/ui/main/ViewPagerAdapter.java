package com.example.gadstop20learners.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gadstop20learners.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_1_text, R.string.tab_2_text};
    private final Context mContext;
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(Context context, FragmentManager fm, int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return PlaceholderFragment.newInstance(position + 1);

//        Fragment fragment = null;
//        if (position == 0)
//        {
//            fragment = new FragmentA();
//        }
//        else if (position == 1)
//        {
//            fragment = new FragmentB();
//        }
//        else if (position == 2)
//        {
//            fragment = new FragmentC();
//        }
//        return fragment;
        return mFragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment){
        mFragmentList.add(fragment);
    }
}