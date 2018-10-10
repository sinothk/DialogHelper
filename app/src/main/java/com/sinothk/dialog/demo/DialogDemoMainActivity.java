package com.sinothk.dialog.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sinothk.dialog.demo.loadingDialog.LoadingDemoMainActivity;

public class DialogDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo_main);
    }

    public void onLoading(View view) {
        startActivity(new Intent(this, LoadingDemoMainActivity.class));
    }
}
