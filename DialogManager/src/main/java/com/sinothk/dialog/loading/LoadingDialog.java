package com.sinothk.dialog.loading;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;


/**
 * Created by ming on 2016/8/18.
 *加载对话框和
 *
 */
public class LoadingDialog {

    private static LoadDialog loadingDialog;

    public static void show(Context context){
        try{
            if(loadingDialog!=null){
                loadingDialog=null;
            }
            loadingDialog = new LoadDialog(context);

            loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    hidden();
                }
            });
            loadingDialog.show();


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void show(Context context,String msg){
        try {
            if(loadingDialog!=null){
                loadingDialog=null;
            }
            loadingDialog = new LoadDialog(context);
            loadingDialog.SetText(msg);


            loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    hidden();
                }
            });

            loadingDialog.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void hidden(){
        try {


            Log.d("LmiotDialog", "销毁");
            if(loadingDialog!=null){
                loadingDialog.dismiss();
                loadingDialog.setTextViewNull();
                loadingDialog=null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }




}
