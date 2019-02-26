package com.app.platon.looms;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemFullScreen extends AppCompatActivity {

    ArrayList<String> mImageArrayList = new ArrayList<>();
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_fullscreen);



        // Add Image to the array List

        // I've used url for the images. You can also use local drawable images for this

        mImageArrayList.clear();

        mImageArrayList.add("http://st.hzcdn.com/simgs/b08108a5022b9acd_3-9392/modern-paintings.jpg");

        mImageArrayList.add("http://st.hzcdn.com/simgs/07c1035905baa695_3-9470/contemporary-paintings.jpg");

        mImageArrayList.add("http://st.hzcdn.com/simgs/a421547904c017b3_3-5125/paintings.jpg");

        mImageArrayList.add("http://st.hzcdn.com/simgs/6d51a18a033973c7_3-4524/contemporary-paintings.jpg");

        mImageArrayList.add("http://st.hzcdn.com/simgs/f6216ebf053eb36c_3-0546/contemporary-paintings.jpg");

        mImageArrayList.add("http://st.hzcdn.com/simgs/7e9141f50616bf9d_3-6050/contemporary-paintings.jpg");





        // Add View Pager

        ViewPager mViewPager = (ViewPager) findViewById(R.id.activity_main_carousel_view_pager);

        CarouselAdapter mPagerAdapter = new CarouselAdapter(this, mImageArrayList);

        mViewPager.setAdapter(mPagerAdapter);



        // Add Tablayout

        mTabLayout = (TabLayout) findViewById(R.id.activity_main_tab_layout);

        mTabLayout.setupWithViewPager(mViewPager);

        setupCustomTabs();

    }



    // For all the items in the image array list, we add a custom tab view

    private void setupCustomTabs() {

        for (int i = 0; i < mImageArrayList.size(); i++) {

            setUpTab(i);

        }

    }



    // Here, we add custom tab view for each list item

    private void setUpTab(int i) {

        View v = LayoutInflater.from(this).inflate(R.layout.carousal_tab, null);

        ImageView tabImage = (ImageView) v.findViewById(R.id.carousel_tab_image_view);

        Picasso.with(ItemFullScreen.this).load(mImageArrayList.get(i)).resize(200, 200).centerCrop().into(tabImage);

        mTabLayout.getTabAt(i).setCustomView(v);

    }
}
