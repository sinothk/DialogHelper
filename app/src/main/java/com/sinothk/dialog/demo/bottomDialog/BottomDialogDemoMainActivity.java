package com.sinothk.dialog.demo.bottomDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jiangyy.easydialog.SingleChoiceDialog;
import com.sinothk.dialog.bottomDialog.normalDialog.BottomSelectorDialog;
import com.sinothk.dialog.demo.R;
import com.sinothk.dialog.demo.bottomDialog.dateSelected.DateSelectedDemoActivity;
import com.sinothk.dialog.demo.bottomDialog.shareDialog.BottomShareDialogDemoActivity;

import java.util.ArrayList;

public class BottomDialogDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_dialog_demo_main);
    }

    public void simpleSelectedDialog(View view) {

        ArrayList<String> data = new ArrayList<>();
        data.add("男");
        data.add("女");

        BottomSelectorDialog.createBuilder(this, getSupportFragmentManager())
                .setTitle("选择性别")
                .setCancelButtonTitle("取消")
//                .setOtherButtonTitles("部门1", "部门2", "部门3", "部门4")
                .setOtherButtonTitles(data)
                .setCancelableOnTouchOutside(true)
                .setListener(new BottomSelectorDialog.SelectorDialogListener() {
                    @Override
                    public void onDismiss(BottomSelectorDialog selectorDialog, boolean b) {

                    }

                    @Override
                    public void onOtherButtonClick(BottomSelectorDialog selectorDialog, int index) {
                        Toast.makeText(BottomDialogDemoMainActivity.this, "index = " + index, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }

    public void dateSelectedDialog(View view) {
        startActivity(new Intent(this, DateSelectedDemoActivity.class));
    }


    public void shareDialog(View view) {
        startActivity(new Intent(this, BottomShareDialogDemoActivity.class));
    }

    public void bottomDialog(View view) {
        new SingleChoiceDialog.Builder(this).setTitle("选择政治面貌")
                .addList(new String[]{"群众", "党员"})

                .setOnItemClickListener(new SingleChoiceDialog.OnItemClickListener() {
                    @Override
                    public void onItemClick(String title, int position) {
                        Toast.makeText(BottomDialogDemoMainActivity.this, "title = " + title + ", " + position, Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}
