package com.app.platon.looms.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.platon.looms.Adapters.CategoryItemAdapter;
import com.app.platon.looms.Model.Item;
import com.app.platon.looms.Model.ItemLab;
import com.app.platon.looms.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

public class DashBoardFragment extends android.support.v4.app.Fragment {

    CarouselView carouselView;

    ImageView mImage1;
    ImageView mImage2;

    int[] sampleImages = {R.drawable.saree, R.drawable.saree, R.drawable.saree, R.drawable.saree, R.drawable.saree};

    public static DashBoardFragment createFor() {

        return new DashBoardFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        carouselView = getView().findViewById(R.id.carouselView);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(sampleImages.length);

        mImage1 = getView().findViewById(R.id.img1);
        mImage2 = getView().findViewById(R.id.img2);
        mImage1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment =new ItemGridFragment();
                showFragment(fragment);
            }
        });
        mImage2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment =new ItemGridFragment();
                showFragment(fragment);
            }
        });

        List<Item> data = ItemLab.getData();

        RecyclerView mRecycler = getView().findViewById(R.id.categories_list);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRecycler.setAdapter(new CategoryItemAdapter(getContext(), data));
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    private void showFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
