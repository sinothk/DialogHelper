package com.sinothk.dialog.demo.bottomDialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sinothk.dialog.demo.R;
import com.sinothk.dialog.demo.bottomDialog.dateSelected.DateSelectedDemoActivity;

public class BottomDialogDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_dialog_demo_main);
    }

    public void simpleSelectedDialog(View view) {

    }

    public void dateSelectedDialog(View view) {
        startActivity(new Intent(this, DateSelectedDemoActivity.class));
    }
}
