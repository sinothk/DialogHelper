package com.sinothk.dialog.tipDialog;

import android.app.Activity;

/**
 * @ author LiangYT
 * @ create 2018/10/10 10:08
 * @ Describe
 */
public class TipDialog {
    private PromptDialog promptDialog;

    public TipDialog(Activity mActivity) {
        if (promptDialog != null) {
            promptDialog = null;
        }
        promptDialog = new PromptDialog(mActivity);
        //设置自定义属性
        promptDialog.getDefaultBuilder()
                .touchAble(true)
                .round(3)
                .loadingDuration(3000);
    }

    public void showWarn(String msg) {
        promptDialog.showWarn(msg);
    }

    public void showSuccess(String msg) {
        promptDialog.showSuccess(msg);
    }

    public void showError(String msg) {
        promptDialog.showError(msg);
    }

    public void showInfo(String msg) {
        promptDialog.showInfo(msg);
    }

    public void showCustom(int iconResId, String msg) {
        promptDialog.showCustom(iconResId, msg);
    }
}
