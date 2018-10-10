package com.sinothk.helpers.dialog;

import android.app.Activity;
import android.content.Context;

import com.sinothk.dialog.loading.LoadingDialog;
import com.sinothk.dialog.tipDialog.DialogManager;
import com.sinothk.dialog.tipDialog.PromptDialog;
import com.sinothk.dialog.tipDialog.TipDialog;
import com.sinothk.dialog.topRightMenu.PopupOverFlow;

/**
 * @ author LiangYT
 * @ create 2018/10/10 9:07
 * @ Describe
 */
public class DialogHelper {
    public static LoadingDialog getLoading(Context mContext) {
        return new LoadingDialog(mContext);
    }

    public static TipDialog getTipDialog(Activity activity) {
        return new TipDialog(activity);
    }

    public static PopupOverFlow getTopDialog(Activity activity) {
        return new PopupOverFlow(activity);
    }

    public static PopupOverFlow getTopDialog(Activity activity, int width) {
        return new PopupOverFlow(activity, width );
    }
}
