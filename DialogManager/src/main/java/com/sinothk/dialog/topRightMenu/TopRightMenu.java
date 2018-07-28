package com.sinothk.dialog.topRightMenu;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * <pre>
 *  创建:  LiangYT 2018/7/28/028 on 17:42
 *  项目: DialogHelper
 *  描述:
 *  更新:
 * <pre>
 */
public class TopRightMenu {

    private static TopRightMenu popMenuView;

    private static PopupOverFlow popupOverFlow;

    public static TopRightMenu createPopMenu(Activity activity) {
        if (popupOverFlow == null) {
            popupOverFlow = new PopupOverFlow(activity);
        }

        if (popMenuView == null) {
            popMenuView = new TopRightMenu();
        }

        return popMenuView;
    }

    public static TopRightMenu createPopMenu(Activity activity, int width) {
        if (popupOverFlow == null) {
            popupOverFlow = new PopupOverFlow(activity, width);
        }

        if (popMenuView == null) {
            popMenuView = new TopRightMenu();
        }

        return popMenuView;
    }

    public TopRightMenu addMenuItemData(ArrayList<PopMenuItem> menuItems, AdapterView.OnItemClickListener itemClickListener) {

        popupOverFlow.addListData(menuItems, itemClickListener);

        return popMenuView;
    }

    public void show(View v) {
        popupOverFlow.showOrHideOverflow(v);
    }
}
