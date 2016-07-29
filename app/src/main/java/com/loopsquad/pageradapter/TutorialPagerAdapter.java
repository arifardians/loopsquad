package com.loopsquad.pageradapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.loopsquad.activity.R;
import com.loopsquad.fragment.TutorialFragment;

/**
 * Created by Ardians-PC on 7/13/2016.
 */
public class TutorialPagerAdapter extends FragmentStatePagerAdapter {

    private static final int IMAGES[] = {R.drawable.image_2, R.drawable.image_3, R.drawable.image_4,
                                        R.drawable.image_5, R.drawable.image_6};

    public TutorialPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TutorialFragment fragment = new TutorialFragment();

        Bundle args = new Bundle();
        args.putInt("image_id", IMAGES[position]);
        boolean isLast = false;
        if (position == IMAGES.length -1){
            isLast = true;
        }
        args.putBoolean("is_last", isLast);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return IMAGES.length;
    }
}
