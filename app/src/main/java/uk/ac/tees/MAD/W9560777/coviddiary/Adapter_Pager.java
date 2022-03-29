package uk.ac.tees.MAD.W9560777.coviddiary;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Adapter_Pager extends FragmentPagerAdapter {

    int count_tab;

    public Adapter_Pager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        count_tab = behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FragmentHome();

            case 1:
                return new FragmentHealth();

            case 2:
                return new FragmentSports();

            case 3:
                return new FragmentScience();

            case 4:
                return new FragmentEntertainment();

            case 5:
                return new FragmentTechnology();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return count_tab;
    }
}
