package com.sinothk.dialog.demo.loadingDialog;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sinothk.dialog.demo.R;
import com.sinothk.dialog.loading.LoadingDialog;
import com.sinothk.helpers.dialog.DialogHelper;

public class LoadingDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog_demo_activity_main);
    }

    public void unWordTip(View view) {

        DialogHelper.getLoading(LoadingDemoMainActivity.this).show();//无文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogHelper.getLoading(LoadingDemoMainActivity.this).dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
    }

    public void wordTip(View view) {
        DialogHelper.getLoading(LoadingDemoMainActivity.this).show("正在登录");//有文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogHelper.getLoading(LoadingDemoMainActivity.this).dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
    }

    public void unWordTipAndCancel(View view) {
        DialogHelper.getLoading(LoadingDemoMainActivity.this).showWhitCancel();//无文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogHelper.getLoading(LoadingDemoMainActivity.this).dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
    }

    public void wordTipAndCancel(View view) {
        DialogHelper.getLoading(LoadingDemoMainActivity.this).showWhitCancel("正在登录");//有文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogHelper.getLoading(LoadingDemoMainActivity.this).dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
    }
}
