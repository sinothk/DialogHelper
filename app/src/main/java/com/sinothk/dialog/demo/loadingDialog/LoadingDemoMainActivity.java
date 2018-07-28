package com.sinothk.dialog.demo.loadingDialog;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.sinothk.dialog.demo.R;
import com.sinothk.dialog.loading.LoadingDialog;
import com.sinothk.dialog.topRightMenu.PopMenuItem;
import com.sinothk.dialog.topRightMenu.TopRightMenu;

import java.util.ArrayList;

public class LoadingDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trm_activity_main);

        findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoadingDialog.show(LoadingDemoMainActivity.this,"正在登录");//有文字提示

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LoadingDialog.hidden(); //隐藏对话框
                            }
                        });
                    }
                }, 500);
            }
        });
    }
}
