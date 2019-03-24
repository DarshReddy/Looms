package com.app.platon.looms.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.platon.looms.ItemFullScreen;
import com.app.platon.looms.Model.Item;
import com.app.platon.looms.Model.ItemLab;
import com.app.platon.looms.R;
import com.app.platon.looms.Adapters.ViewPagerAdapter;

import java.util.List;

public class ItemFullScreenFragment extends Fragment {

    private String EXTRA_PRICE = "price";
    private String EXTRA_NAME = "name";
    private static int mPosition;
    private List<Item> data;
    private ViewPager mViewPager;

    public static ItemFullScreenFragment CreateFor(String name,String price,int position) {
        ItemFullScreenFragment fragment = new ItemFullScreenFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("price", price);
        mPosition = position;
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_full, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final String itemName = getArguments().getString(EXTRA_NAME);
        final String price = getArguments().getString(EXTRA_PRICE);
        data = ItemLab.getData();

        mViewPager = getView().findViewById(R.id.viewpager);
        ViewPagerAdapter mPagerAdapter = new ViewPagerAdapter(getContext(), data);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(mPosition);

        final ImageButton leftNav =  getView().findViewById(R.id.left_nav);
        ImageButton rightNav =  getView().findViewById(R.id.right_nav);
        TextView name = getView().findViewById(R.id.item_name_full);
        TextView itemPrice = getView().findViewById(R.id.item_price);
        name.setText(itemName);
        itemPrice.setText(price);

        leftNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = mViewPager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    mViewPager.setCurrentItem(tab);
                } else if (tab == 0) {
                    leftNav.setVisibility(View.INVISIBLE);
                }
            }
        });

        rightNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = mViewPager.getCurrentItem();
                tab++;
                leftNav.setVisibility(View.VISIBLE);
                mViewPager.setCurrentItem(tab);
            }
        });
    }

}