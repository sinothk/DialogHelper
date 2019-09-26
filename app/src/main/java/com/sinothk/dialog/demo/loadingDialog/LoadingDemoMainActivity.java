package com.sinothk.dialog.demo.loadingDialog;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sinothk.dialog.DialogView;
import com.sinothk.dialog.demo.R;

public class LoadingDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog_demo_activity_main);
    }

    public void unWordTip(View view) {

        DialogView.loading(LoadingDemoMainActivity.this).show(false);//无文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogView.loading(LoadingDemoMainActivity.this).dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
    }

    public void wordTip(View view) {
        DialogView.loading(LoadingDemoMainActivity.this).show(false, "正在登录");//有文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogView.loading(LoadingDemoMainActivity.this).dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
    }

    public void unWordTipAndCancel(View view) {
        DialogView.loading(LoadingDemoMainActivity.this).show(true);//无文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogView.loading(LoadingDemoMainActivity.this).dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
    }

    public void wordTipAndCancel(View view) {
        DialogView.loading(LoadingDemoMainActivity.this).show(true, "正在登录");//有文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogView.loading(LoadingDemoMainActivity.this).dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
    }
}
