package com.app.platon.looms.fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.app.platon.looms.Adapters.ListAdapter;
import com.app.platon.looms.Model.Item;
import com.app.platon.looms.Model.ItemLab;
import com.app.platon.looms.R;

import java.util.List;

public class ItemGridFragment extends Fragment {

    private List<Item> data;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        data = ItemLab.getData();
        final RecyclerView recyclerView = view.findViewById(R.id.list_items);
        recyclerView.setAdapter(new ListAdapter(getContext(), data));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState) {

    }

}
