package com.app.platon.looms;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarouselAdapter extends PagerAdapter {


    private Context mContext;

    private ArrayList<String> mImageArrayList = new ArrayList<>();



    public CarouselAdapter(Context c, ArrayList<String> imageArrayList) {

        mContext = c;

        mImageArrayList = imageArrayList;

    }



    @Override

    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();



        View view = inflater.inflate(R.layout.carousal_item, container, false);



        ImageView mImageView = (ImageView) view.findViewById(R.id.carousel_item_image_view);

        Picasso.with(mContext).load(mImageArrayList.get(position)).into(mImageView);

        container.addView(view);



        return view;

    }



    @Override
    public int getCount() {

        return mImageArrayList.size();

    }



    @Override

    public boolean isViewFromObject(View view, Object object) {

        return view == object;

    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);

    }
}
