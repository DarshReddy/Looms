package com.app.platon.looms;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.app.platon.looms.Model.Item;
import com.app.platon.looms.Model.ItemLab;

import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class ItemGrid extends AppCompatActivity {

    private List<Item> data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list);

        data= ItemLab.getData();

        RecyclerView recyclerView = findViewById(R.id.list_items);
        recyclerView.setAdapter(new ListAdapter(data));
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        RecyclerView.ItemDecoration itemDecor = new
                DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.addItemDecoration(itemDecor);
        recyclerView.setItemAnimator(new SlideInUpAnimator());
    }
}
