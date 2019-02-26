package com.app.platon.looms.Model;

import com.app.platon.looms.R;

import java.util.Arrays;
import java.util.List;

public class ItemLab {

    static List<Item> data;

    public static List<Item> getData() {

        data =  Arrays.asList(

                new Item(1, "Mysore Silk", "$12.00 USD", R.drawable.saree),

                new Item(2, "Party Wear", "$50.00 USD", R.drawable.saree),

                new Item(3, "Kancheepuram", "$265.00 USD", R.drawable.saree),

                new Item(4, "Anywhere", "$18.00 USD", R.drawable.saree),

                new Item(5, "Nylon", "$36.00 USD", R.drawable.saree),

                new Item(6, "Clearance Zone", "$145.00 USD", R.drawable.saree));
        return data;

    }
}