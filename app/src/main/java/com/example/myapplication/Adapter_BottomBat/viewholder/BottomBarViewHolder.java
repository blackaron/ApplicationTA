package com.example.myapplication.Adapter_BottomBat.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class BottomBarViewHolder extends RecyclerView.ViewHolder {
    public RelativeLayout bottom_item_parent;
    public  RelativeLayout bottom_parent;
    public ImageView botton_icon;
    public CardView bottom_notification;

    public BottomBarViewHolder(@NonNull View itemView) {
        super(itemView);
        bottom_item_parent  = itemView.findViewById(R.id.bottom_item_parent);
        bottom_parent       = itemView.findViewById(R.id.bottom_parent);
        botton_icon         = itemView.findViewById(R.id.bottom_icon);
        bottom_notification = itemView.findViewById(R.id.bottom_notification);
    }
}
