package com.sinothk.dialog.topRightMenu;

/**
 * Created by 梁玉涛 on 2017/12/24.
 */

public class PopMenuItem {
    private String itemId;
    private int itemIcon;
    private String itemName;

    public PopMenuItem(String itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public PopMenuItem(int itemIcon, String itemName) {
        this.itemIcon = itemIcon;
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(int itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
