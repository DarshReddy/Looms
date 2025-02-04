package com.app.platon.looms.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.platon.looms.Model.Item;
import com.app.platon.looms.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context mContext;
    private List<Item> mList;
    private static int Count=0;
    private static int[] position = new int[100];
    private static int totalCost=0;

    public CartAdapter(Context context, List<Item> data) {
        this.mContext = context;
        this.mList = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.cart_card, viewGroup, false);
        return new CartAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext).load(mList.get(position[i]).getImage()).into(viewHolder.mImage);
        viewHolder.mTextView.setText(mList.get(position[i]).getName());
        viewHolder.mPrice.setText(mList.get(position[i]).getPrice());
    }

    @Override
    public int getItemCount() {
        return Count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private TextView mTextView;
        private TextView mPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.wish_image);
            mTextView = itemView.findViewById(R.id.wish_name);
            mPrice = itemView.findViewById(R.id.wish_price);
        }
    }

    public static void setPosition(int i) {
        position[Count] = i;
        Count++;
    }

    public int getInt() {
        totalCost=0;
        for(int i=0;i<Count;i++){
            totalCost+= Integer.parseInt(mList.get(position[i]).getPrice());
        }
        return totalCost;
    }
}
