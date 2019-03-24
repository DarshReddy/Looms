package com.app.platon.looms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.platon.looms.Adapters.CartAdapter;
import com.app.platon.looms.Adapters.WishListAdapter;
import com.app.platon.looms.Model.Item;
import com.app.platon.looms.Model.ItemLab;

import java.util.List;

public class WishListActivity extends AppCompatActivity {
    private List<Item> data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        data = ItemLab.getData();
        RecyclerView mRecycler = findViewById(R.id.wish_recycler);
        mRecycler.setAdapter(new WishListAdapter(WishListActivity.this, data));
        mRecycler.setLayoutManager(new LinearLayoutManager(WishListActivity.this));

        TextView text = findViewById(R.id.text_empty);
        Button button = findViewById(R.id.button_empty);
        text.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
        if(WishListAdapter.Count > 0) {
            text.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WishListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
