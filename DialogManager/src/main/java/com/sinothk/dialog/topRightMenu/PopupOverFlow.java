package com.sinothk.dialog.topRightMenu;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.sinothk.dialog.R;

import java.util.ArrayList;

/**
 * Created by 梁玉涛 on 2017/12/24.
 */

public class PopupOverFlow extends PopupWindow {
    private Activity mActivity;
    private ListView listView;

    /**
     * 构造
     *
     * @param activity
     */
    public PopupOverFlow(Activity activity) {
        mActivity = activity;

        // 设置SelectPicPopupWindow的View
        View contentView = View.inflate(activity, R.layout.top_diaolog_menu_list_view, null);
        setContentView(contentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        contentView.measure(0, 0);
        setWidth(contentView.getMeasuredWidth());
        setWidth(contentView.getMeasuredWidth());
        // 设置SelectPicPopupWindow弹出窗体的高
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        setFocusable(true);
        setOutsideTouchable(true);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        BitmapDrawable dw = new BitmapDrawable();
        setBackgroundDrawable(dw);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        setAnimationStyle(R.style.AnimTools);

        listView = (ListView) contentView.findViewById(R.id.listView);
    }

    /**
     * 构造
     *
     * @param context
     * @param width
     */
    public PopupOverFlow(Activity context, int width) {
        mActivity = context;

        // 设置SelectPicPopupWindow的View
        View contentView = View.inflate(context, R.layout.top_diaolog_menu_list_view, null);
        setContentView(contentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        contentView.measure(0, 0);
//        setWidth(contentView.getMeasuredWidth());
        setWidth(width);

        // 设置SelectPicPopupWindow弹出窗体的高
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        // 设置SelectPicPopupWindow弹出窗体可点击
        setFocusable(true);
        setOutsideTouchable(true);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作

        BitmapDrawable dw = new BitmapDrawable();
        setBackgroundDrawable(dw);

        // 设置SelectPicPopupWindow弹出窗体动画效果
        setAnimationStyle(R.style.AnimTools);

        listView = (ListView) contentView.findViewById(R.id.listView);
    }

    public void addListData(ArrayList<PopMenuItem> menuItems, final AdapterView.OnItemClickListener itemClickListener) {

        PopMenuAdapter popMenuAdapter = new PopMenuAdapter(mActivity, menuItems);


        listView.setAdapter(popMenuAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dismiss();
                itemClickListener.onItemClick(parent, view, position, id);
            }
        });
    }

    /**
     * 显示popupWindow
     *
     * @param parent anchor
     * @return true: show  ,  false: hide
     */
    public void showOrHideOverflow(View parent) {
        boolean showing = isShowing();
        if (!showing) {
            backgroundAlpha(0.5f);
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, 0, 2);
        } else {
            this.dismiss();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        backgroundAlpha(1);
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0

        mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mActivity.getWindow().setAttributes(lp);
    }

    /**
     * 显示
     */
    public void show(View view, ArrayList<PopMenuItem> menuItems, AdapterView.OnItemClickListener itemClickListener) {
        addListData(menuItems, itemClickListener);
        showOrHideOverflow(view);
    }

    public void show(View view, ArrayList<PopMenuItem> menuItems, AdapterView.OnItemClickListener itemClickListener, int lineColor, int lineSize) {
        if (lineColor > 0) {
            listView.setDivider(new ColorDrawable(mActivity.getResources().getColor(lineColor)));
            if (lineSize > 0) {
                listView.setDividerHeight(lineSize);
            } else {
                listView.setDividerHeight(0);
            }
        }

        addListData(menuItems, itemClickListener);
        showOrHideOverflow(view);
    }
}
