package com.app.platon.looms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.platon.looms.Adapters.CartAdapter;
import com.app.platon.looms.Model.Item;
import com.app.platon.looms.Model.ItemLab;
import com.app.platon.looms.R;

import java.util.List;

public class CartFragment extends Fragment {
    RecyclerView mRecyclerView;
    TextView mTotal;
    TextView mDiscount;
    TextView mPayable;
    private List<Item> data;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cart_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        data = ItemLab.getData();

        mRecyclerView = getView().findViewById(R.id.card_recycler);
        CartAdapter adapter = new CartAdapter(getContext(), data);
        mRecyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);

        mTotal= getView().findViewById(R.id.total_cost);
        mTotal.setText(Integer.toString(adapter.getInt()));

        mDiscount= getView().findViewById(R.id.discount);
        mDiscount.setText("-"  + Integer.toString((Integer.parseInt(mTotal.getText().toString())*25)/100));

        mPayable = getView().findViewById(R.id.payable);
        mPayable.setText(Integer.toString(Integer.parseInt(mTotal.getText().toString()) + Integer.parseInt(mDiscount.getText().toString())));
    }
}
