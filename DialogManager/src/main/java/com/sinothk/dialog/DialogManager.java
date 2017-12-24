package com.sinothk.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

import com.sinothk.dialog.topRightMenu.PopMenuItem;
import com.sinothk.dialog.topRightMenu.PopupOverFlow;

import java.util.ArrayList;

/**
 * Created by 梁玉涛 on 2017/11/23/023.
 * 描述：来自https://github.com/limxing/Android-PromptDialog
 */

public final class DialogManager extends PromptDialog {

    public DialogManager(Activity context) {
        super(context);
    }

    public DialogManager(Builder builder, Activity context) {
        super(builder, context);
    }

    public static class PopMenuView {

        private static PopMenuView popMenuView;

        private static PopupOverFlow popupOverFlow;

        public static PopMenuView createPopMenu(Activity activity) {
            if (popupOverFlow == null) {
                popupOverFlow = new PopupOverFlow(activity);
            }

            if (popMenuView == null) {
                popMenuView = new PopMenuView();
            }

            return popMenuView;
        }

        public static PopMenuView createPopMenu(Activity activity, int width) {
            if (popupOverFlow == null) {
                popupOverFlow = new PopupOverFlow(activity, width);
            }

            if (popMenuView == null) {
                popMenuView = new PopMenuView();
            }

            return popMenuView;
        }

        public PopMenuView addMenuItemData(ArrayList<PopMenuItem> menuItems, AdapterView.OnItemClickListener itemClickListener) {

            popupOverFlow.addListData(menuItems, itemClickListener);

            return popMenuView;
        }

        public void show(View v) {
            popupOverFlow.showOrHideOverflow(v);
        }
    }

}
