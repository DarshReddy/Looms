package com.app.platon.looms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.platon.looms.Adapters.CartAdapter;
import com.app.platon.looms.Adapters.WishListAdapter;
import com.app.platon.looms.fragment.ItemFullScreenFragment;

public class ItemFullScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_fullscreen_activity);
        final android.support.v4.app.Fragment fragment = ItemFullScreenFragment.CreateFor(getIntent().getStringExtra("name"), getIntent().getStringExtra("price"), getIntent().getIntExtra("position", 0));
        showFragment(fragment);

        final Button addtobag = findViewById(R.id.add_to_bag);
        final Button wishlist = findViewById(R.id.wish_item);
        addtobag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartAdapter.setPosition(getIntent().getIntExtra("position", 0));
                Toast.makeText(ItemFullScreen.this, "Added to bag", Toast.LENGTH_SHORT).show();
                addtobag.setVisibility(View.INVISIBLE);
            }
        });
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WishListAdapter.setPosition(getIntent().getIntExtra("position", 0));
                Toast.makeText(ItemFullScreen.this, "Added to WishList", Toast.LENGTH_SHORT).show();
                wishlist.setVisibility(View.INVISIBLE);
            }
        });

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.item_grid_container, fragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_cart) {
            Intent intent = new Intent(ItemFullScreen.this, CartActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}