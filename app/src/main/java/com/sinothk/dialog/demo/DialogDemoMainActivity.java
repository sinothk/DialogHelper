package com.sinothk.dialog.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sinothk.dialog.demo.bottomDialog.BottomDialogDemoMainActivity;
import com.sinothk.dialog.demo.centerDialog.CenterDialogDemoMainActivity;
import com.sinothk.dialog.demo.loadingDialog.LoadingDemoMainActivity;
import com.sinothk.dialog.demo.tipDialog.TipDialogDemoMainActivity;
import com.sinothk.dialog.demo.topRightMenu.TopDialogDemoMainActivity;

public class DialogDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo_main);
    }

    public void onLoading(View view) {
        startActivity(new Intent(this, LoadingDemoMainActivity.class));
    }

    public void tipDialog(View view) {
        startActivity(new Intent(this, TipDialogDemoMainActivity.class));
    }

    public void centerDialog(View view) {
        startActivity(new Intent(this, CenterDialogDemoMainActivity.class));
    }

    public void topDialog(View view) {
        startActivity(new Intent(this, TopDialogDemoMainActivity.class));
    }

    public void bottomDialog(View view) {
        startActivity(new Intent(this, BottomDialogDemoMainActivity.class));
    }
}
