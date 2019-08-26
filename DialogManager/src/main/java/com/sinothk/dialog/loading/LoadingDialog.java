package com.sinothk.dialog.loading;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;


/**
 * Created by ming on 2016/8/18.
 * 加载对话框和
 */
public class LoadingDialog {

    private LoadDialog loadingDialog;

    public LoadingDialog() {
    }

    /**
     * 销毁对话框
     */
    public void dismiss() {
        try {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
                loadingDialog.setTextViewNull();
                loadingDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void show(Context mContext, boolean canCancel) {
        try {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
                loadingDialog = null;
            }
            loadingDialog = new LoadDialog(mContext);
            loadingDialog.setCanceledOnTouchOutside(canCancel);
            loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    dismiss();
                }
            });

            loadingDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(Context mContext, boolean canCancel, String msg) {
        try {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
                loadingDialog = null;
            }
            loadingDialog = new LoadDialog(mContext);
            // 设置文字属性
            if (!TextUtils.isEmpty(msg)) {
                loadingDialog.setText(msg);
            }

            loadingDialog.setCanceledOnTouchOutside(canCancel);
            loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    dismiss();
                }
            });

            loadingDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
