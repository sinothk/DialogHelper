package com.sinothk.dialog.demo;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DialogMainDemoActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View v) {

    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_dialog_main_demo)
//
//        loadingDialog.setOnClickListener(this)
//        okOrCancelDialog.setOnClickListener(this)
//    }
//
//    override fun onClick(v: View?) {
//        when (v) {
//            loadingDialog -> {
//                QDialogView.loading(this).show(false)
//            }
//
//            okOrCancelDialog -> {
//                QDialogView.center(this).show("标题", "内容内容内容内容内容内容内容内容内容内容内容内容内容内容", "提交", false) {
//                    Toast.makeText(this, "提交操作 ...", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
}
