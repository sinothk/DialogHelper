package com.sinothk.dialog.loading;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;


/**
 * Created by ming on 2016/8/18.
 * 加载对话框和
 */
public class LoadingDialog {

    private Context context;

    private LoadDialog loadingDialog;

    public LoadingDialog(Context mContext) {
        context = mContext;
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

//    /**
//     * 无文字提示
//     */
//    public void show() {
//        try {
//            if (loadingDialog != null) {
//                loadingDialog = null;
//            }
//            loadingDialog = new LoadDialog(context);
//            loadingDialog.setCanceledOnTouchOutside(false);
//            loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface dialogInterface) {
//                    dismiss();
//                }
//            });
//            loadingDialog.show();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 有文字提示
//     *
//     * @param msg
//     */
//    public void show(String msg) {
//        try {
//            if (loadingDialog != null) {
//                loadingDialog = null;
//            }
//            loadingDialog = new LoadDialog(context);
//            // 设置文字属性
//            if (!TextUtils.isEmpty(msg)) {
//                loadingDialog.setText(msg);
//            }
//
//            loadingDialog.setCanceledOnTouchOutside(false);
//
//            loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface dialogInterface) {
//                    dismiss();
//                }
//            });
//
//            loadingDialog.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void show(boolean canCancel) {
        try {
            if (loadingDialog != null) {
                loadingDialog = null;
            }
            loadingDialog = new LoadDialog(context);
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

    public void show(boolean canCancel, String msg) {
        try {
            if (loadingDialog != null) {
                loadingDialog = null;
            }
            loadingDialog = new LoadDialog(context);
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
