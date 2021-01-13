package com.example.myapplication;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter_BottomBat.BottomAdapter;
import com.example.myapplication.Model.BottomBar.BottomItem;

import java.util.ArrayList;

public class BottomBar {
    private final int ITEM_LIMIT = 5;
    private Context context;
    private RecyclerView recyclerView;
    private ArrayList<BottomItem> bottomItems;
    private BottomAdapter.BottomItemClickInterface bottomItemClickInterface;

    public BottomBar(View view, Context context, BottomAdapter.BottomItemClickInterface bottomItemClickInterface){
        this.context = context;
        this.bottomItemClickInterface = bottomItemClickInterface;
        setType(view);
    }

    private void setType(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
        bottomItems = new ArrayList<>();
    }

    public void addBottomItem(BottomItem item){
        if (bottomItems.size() != ITEM_LIMIT){
            bottomItems.add(item);
        }
    }

    public void setAdapter(int selected){
        BottomAdapter bottomAdapter = new BottomAdapter(selected, bottomItems, calculateItemWidth(), bottomItemClickInterface);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(bottomAdapter);
    }

    private int calculateItemWidth(){
        int mCount = bottomItems.size() + 1;
        int mWidth = context.getResources().getDisplayMetrics().widthPixels;
        return mWidth / mCount;
    }

    public void apply(int selected){
        setAdapter(selected);
    }
}
