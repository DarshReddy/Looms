package com.app.platon.looms.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.platon.looms.CartActivity;
import com.app.platon.looms.MainActivity;
import com.app.platon.looms.Model.Item;
import com.app.platon.looms.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context mContext;
    private List<Item> data;

    public ListAdapter(Context context,List<Item> data) {
        this.mContext = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        Glide.with(mContext).load(data.get(i).getImage()).into(viewHolder.image);
        viewHolder.text.setText(data.get(i).getName());
        viewHolder.price.setText(data.get(i).getPrice());

        viewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Added!", Toast.LENGTH_SHORT).show();
                CartAdapter.setPosition(viewHolder.getAdapterPosition());
            }
        });

        viewHolder.wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Added to wish list!", Toast.LENGTH_SHORT).show();
                WishListAdapter.setPosition(viewHolder.getAdapterPosition());
            }
        });

        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)mContext).fullscreen(viewHolder.text.getText().toString(), viewHolder.price.getText().toString(), viewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView text;
        private Button add;
        private TextView price;
        private ImageButton wish;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.list_item_image);
            text = itemView.findViewById(R.id.list_item_name);
            price = itemView.findViewById(R.id.itemPrice);
            add = itemView.findViewById(R.id.add_to_bag);
            wish = itemView.findViewById(R.id.wish_item);
        }
    }
}
