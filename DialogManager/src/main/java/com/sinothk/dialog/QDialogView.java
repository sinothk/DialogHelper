package com.sinothk.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

import com.sinothk.dialog.loading.LoadingDialog;
import com.sinothk.dialog.view.CenterDialog;
import com.sinothk.dialog.tipDialog.TipDialog;
import com.sinothk.dialog.topRightMenu.PopupOverFlow;

/**
 * @ author LiangYT
 * @ create 2018/10/10 9:07
 * @ Describe
 */
public class QDialogView {

    // 加载对话框
    @SuppressLint("StaticFieldLeak")
    private static LoadingDialog loadingDialog;

    public static LoadingDialog loading() {
        if (loadingDialog == null) {
            synchronized (QDialogView.class) {
                loadingDialog = new LoadingDialog();
            }
        }
        return loadingDialog;
    }

    // 确认对话框
    private static CenterDialog centerDialog;

    public static CenterDialog center(Activity mActivity) {
        if (centerDialog == null) {
            synchronized (QDialogView.class) {
                centerDialog = new CenterDialog(mActivity);
            }
        }
        return centerDialog;
    }


    // ===============================================================================================
    public static TipDialog getTipDialog(Activity activity) {
        return new TipDialog(activity);
    }

    public static PopupOverFlow getTopDialog(Activity activity) {
        return new PopupOverFlow(activity);
    }

    public static PopupOverFlow getTopDialog(Activity activity, int width) {
        return new PopupOverFlow(activity, width);
    }


}
