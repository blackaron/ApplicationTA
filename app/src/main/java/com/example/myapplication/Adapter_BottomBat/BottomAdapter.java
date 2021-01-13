package com.example.myapplication.Adapter_BottomBat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter_BottomBat.viewholder.BottomBarViewHolder;
import com.example.myapplication.Model.BottomBar.BottomItem;
import com.example.myapplication.R;

import java.util.ArrayList;

public class BottomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BottomItem> bottomItems;
    private int itemWidth;
    private int selected;
    private BottomItemClickInterface bottomItemClickInterface;

    public BottomAdapter(int selected, ArrayList<BottomItem> bottomItems, int itemWidth, BottomItemClickInterface bottomItemClickInterface){
        this.bottomItems = bottomItems;
        this.itemWidth =  itemWidth;
        this.selected = selected;
        this.bottomItemClickInterface = bottomItemClickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_bar_item,
                parent, false);
        return new BottomBarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        resizeItemWidth(((BottomBarViewHolder) holder).bottom_parent);
        setIcon(((BottomBarViewHolder)holder).botton_icon, bottomItems.get(position).getItemIconId());
        selectedStyle(
                ((BottomBarViewHolder) holder).botton_icon,
                bottomItems.get(position).getItemId(),
                bottomItems.get(position).getItemIconId(),
                bottomItems.get(position).getItemFillIconId()
        );
        visibilityChange(((BottomBarViewHolder) holder).bottom_notification, bottomItems.get(position).isHasNotification());

        setOnClickItem(((BottomBarViewHolder) holder).bottom_item_parent,
                ((BottomBarViewHolder) holder).botton_icon, position,
                bottomItems.get(position).getItemId(),
                bottomItems.get(position).getItemIconId(),
                bottomItems.get(position).getItemFillIconId()
                );
    }

    private void setIcon(ImageView imageView, int iconId){
        imageView.setImageResource(iconId);
    }

    private void visibilityChange (CardView cardView, boolean isVissible){
        if (isVissible){
            cardView.setVisibility(View.VISIBLE);
        } else {
            cardView.setVisibility(View.GONE);
        }
    }

    private void selectedStyle(ImageView imageView, int itemId, int itemFillIcon, int itemDefIcon){
        if (itemId == selected){
            imageView.setImageResource(itemFillIcon);
        }else {
            imageView.setImageResource(itemDefIcon);
        }
    }

    @Override
    public int getItemCount() {
        return bottomItems.size();
    }

    private void resizeItemWidth(RelativeLayout parent){
        parent.getLayoutParams().width = itemWidth;
    }

    private void setOnClickItem(RelativeLayout parent, final ImageView imageView, final int position, final int itemId, final int itemDefIcon, final int itemFillIcon){
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomItemClickInterface.itemSelect(itemId);
                selected = itemId;
                bottomItems.get(position).setHasNotification(false);
                notifyDataSetChanged();
            }
        });
    }

    public interface BottomItemClickInterface {
        void itemSelect(int itemId);
    }
}
