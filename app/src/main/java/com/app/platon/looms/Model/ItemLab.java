package com.app.platon.looms.Model;

import com.app.platon.looms.R;

import java.util.Arrays;
import java.util.List;

public class ItemLab {

    static List<Item> data;

    public static List<Item> getData() {

        data =  Arrays.asList(

                new Item(1, "Mysore Silk", "12", R.drawable.model1),
                new Item(2, "Party Wear", "50", R.drawable.model2),
                new Item(3, "Kancheepuram", "265", R.drawable.model3),
                new Item(4, "Anywhere", "18", R.drawable.model4),
                new Item(5, "Banaras", "123", R.drawable.model5),
                new Item(6,"Hulikal", "536", R.drawable.model6));
        return data;

    }
}