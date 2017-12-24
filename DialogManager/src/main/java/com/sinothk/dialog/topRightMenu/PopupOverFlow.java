package com.sinothk.dialog.topRightMenu;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.sinothk.dialog.R;

import java.util.ArrayList;

/**
 * Created by 梁玉涛 on 2017/12/24.
 */

public class PopupOverFlow extends PopupWindow implements PopupWindow.OnDismissListener {
    Activity mContext;
    public PopMenuAdapter popMenuAdapter;
    ListView listView;

    public PopupOverFlow(Activity context) {
        mContext = context;

        // 设置SelectPicPopupWindow的View
        View contentView = View.inflate(context, R.layout.pop_menu_list, null);
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

    public PopupOverFlow(Activity context, int width) {
        mContext = context;

        // 设置SelectPicPopupWindow的View
        View contentView = View.inflate(context, R.layout.pop_menu_list, null);
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
        popMenuAdapter = new PopMenuAdapter(mContext, menuItems);
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
    public boolean showOrHideOverflow(View parent) {
        boolean showing = isShowing();
        if (!showing) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, 0, 2);
        } else {
            this.dismiss();
        }
        return !showing;
    }


//    private MenuListener l;

    @Override
    public void onDismiss() {
//        if (l != null)
//            l.onDismiss();
    }

    //关闭时回复窗口透明度
//    @Override
//    public void onDismiss() {
//        WindowManager.LayoutParams params = mContext.getWindow().getAttributes();
//        params.alpha = 1f;
//        mContext.getWindow().setAttributes(params);
//
//        if (l != null)
//            l.onDismiss();
//    }

//    public interface MenuListener {
//
//        void onDismiss();
//
//        void onAddStdPostil(View v);
//
//        void onLabelClick(View v);
//
//        void onMandatoryClick(View v);
//
//        void onShareClick(View v);
//    }

    //关闭时回复窗口透明度
//    @Override
//    public void onDismiss() {
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.alpha = 1f;
//        getWindow().setAttributes(params);
//    }
}
