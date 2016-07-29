package com.loopsquad.activity;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.loopsquad.pageradapter.TutorialPagerAdapter;

public class SliderActivity extends AppCompatActivity {

    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        pager = (ViewPager) findViewById(R.id.slider_view_pager);
        TutorialPagerAdapter pagerAdapter = new TutorialPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

    }
}
