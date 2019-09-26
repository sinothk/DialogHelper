package com.sinothk.dialog.view;

import android.app.Activity;
import android.view.View;

import com.jiangyy.easydialog.CommonDialog;

public class CenterDialog {

    private Activity mActivity;

    public CenterDialog(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void show(String title, String content, String okStr, String cancelStr, boolean canCancel, View.OnClickListener listener) {
        new CommonDialog.Builder(mActivity)
                .setTitle(title)
                .setCanceledOnTouchOutside(canCancel)
                .setMessage(content)
                .setPositiveButton(okStr, listener)
                .setNegativeButton(cancelStr, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    public void show(String title, String content, String okStr, boolean canCancel, View.OnClickListener listener) {
        show(title, content, okStr, "取消", canCancel, listener);
    }
}
