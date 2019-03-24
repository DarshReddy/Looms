package com.app.platon.looms.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.platon.looms.Model.Item;
import com.app.platon.looms.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ViewPagerAdapter extends android.support.v4.view.PagerAdapter {


    private Context mContext;

    private List<Item> mItemsList;

    public ViewPagerAdapter(Context c, List<Item> data) {

        mContext = c;
        mItemsList = data;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

        View view = inflater.inflate(R.layout.viewpager_item, container, false);
        ImageView mImageView = view.findViewById(R.id.carousel_item_image_view);
        if(position<mItemsList.size()) {
            Glide.with(mContext).load(mItemsList.get(position).getImage()).into(mImageView);
        }
        else{
            Glide.with(mContext).load(mItemsList.get(position%mItemsList.size()).getImage()).into(mImageView);
        }
        container.addView(view);

        return view;

    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
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