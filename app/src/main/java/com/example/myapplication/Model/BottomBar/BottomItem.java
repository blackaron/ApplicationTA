package com.example.myapplication.Model.BottomBar;

public class BottomItem {
    private int itemId, itemIconId, itemFillIconId;
    private boolean isHasNotification = false;

    public BottomItem(int itemId, int itemFillIconId, int itemIconId,
                      boolean isHasNotification){
        this.itemId = itemId;
        this.itemFillIconId = itemFillIconId;
        this.itemIconId = itemIconId;
        this.isHasNotification = isHasNotification;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemIconId() {
        return itemIconId;
    }

    public void setItemIconId(int itemIconId) {
        this.itemIconId = itemIconId;
    }

    public int getItemFillIconId() {
        return itemFillIconId;
    }

    public void setItemFillIconId(int itemFillIconId) {
        this.itemFillIconId = itemFillIconId;
    }

    public boolean isHasNotification() {
        return isHasNotification;
    }

    public void setHasNotification(boolean hasNotification) {
        isHasNotification = hasNotification;
    }
}
