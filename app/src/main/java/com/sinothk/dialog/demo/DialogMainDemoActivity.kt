package com.sinothk.dialog.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sinothk.dialog.QDialogView
import kotlinx.android.synthetic.main.activity_dialog_main_demo.*

class DialogMainDemoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_main_demo)

        loadingDialog.setOnClickListener(this)
        okOrCancelDialog.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            loadingDialog -> {
                QDialogView.loading(this).show(false)
            }

            okOrCancelDialog -> {
                QDialogView.center(this).show("标题", "内容内容内容内容内容内容内容内容内容内容内容内容内容内容", "提交", false) {
                    Toast.makeText(this, "提交操作 ...", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
