package com.sinothk.dialog;

import android.annotation.SuppressLint;
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
public class DialogView {

//    private static Context context;
//
//    public static void init(Context mContext) {
//        context = mContext;
//    }

    private static void contextNullError() {
        throw new NullPointerException("mContext == null或参数为null, 请在调用前初始化：init(context), 请在调用前初始化：init(context)");
    }

    // Dialog
    @SuppressLint("StaticFieldLeak")
    private static LoadingDialog loadingDialog;

    public static LoadingDialog loading() {
        if (loadingDialog == null) {
            synchronized (DialogView.class) {
                loadingDialog = new LoadingDialog();
            }
        }
        return loadingDialog;
    }

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
