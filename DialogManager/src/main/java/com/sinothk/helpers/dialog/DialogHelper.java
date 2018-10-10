package com.sinothk.helpers.dialog;

import android.content.Context;

import com.sinothk.dialog.loading.LoadingDialog;

/**
 * @ author LiangYT
 * @ create 2018/10/10 9:07
 * @ Describe
 */
public class DialogHelper {
    public static LoadingDialog getLoading(Context mContext) {
        return new LoadingDialog(mContext);
    }
}
