//package com.sinothk.dialog.topRightMenu;
//
//import android.app.Activity;
//import android.view.View;
//import android.widget.AdapterView;
//
//import java.util.ArrayList;
//
///**
// * Created by 梁玉涛 on 2017/12/24.
// */
//
//public class DialogManager {
//
//    public static class PopMenuView {
//
//        private static PopMenuView popMenuView;
//
//        private static PopupOverFlow popupOverFlow;
//
//        public static PopMenuView createPopMenu(Activity activity) {
//            if (popupOverFlow == null) {
//                popupOverFlow = new PopupOverFlow(activity);
//            }
//
//            if (popMenuView == null) {
//                popMenuView = new PopMenuView();
//            }
//
//            return popMenuView;
//        }
//
//        public static PopMenuView createPopMenu(Activity activity, int width) {
//            if (popupOverFlow == null) {
//                popupOverFlow = new PopupOverFlow(activity, width);
//            }
//
//            if (popMenuView == null) {
//                popMenuView = new PopMenuView();
//            }
//
//            return popMenuView;
//        }
//
//        public PopMenuView addMenuItemData(ArrayList<PopMenuItem> menuItems, AdapterView.OnItemClickListener itemClickListener) {
//
//            popupOverFlow.addListData(menuItems, itemClickListener);
//
//            return popMenuView;
//        }
//
//        public void show(View v) {
//            popupOverFlow.showOrHideOverflow(v);
//        }
//    }
//}
