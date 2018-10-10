package com.sinothk.dialog.demo.bottomDialog.shareDialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sinothk.dialog.bottomDialog.shareDialog.BottomDialog;
import com.sinothk.dialog.demo.R;

public class BottomShareDialogDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_share_demo_activity_main);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareDialog();
            }
        });

        findViewById(R.id.show_edit_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editDialog();
            }
        });

    }

    private void editDialog() {
        EditTextDialog dialog = new EditTextDialog();
        dialog.show(getSupportFragmentManager());
    }

    private void shareDialog() {
//        BottomDialog.create(getSupportFragmentManager())
////                .setViewListener(new BottomDialog.ViewListener() {
////                    @Override
////                    public void bindView(View v) {
//final EditText editText = (EditText) view.findViewById(R.id.edit_text);
//        editText.post(new Runnable() {
//            @Override
//            public void run() {
//                InputMethodManager inputMethodManager =
//                        (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
//            }
//        });
//        editText.setText("Hello world");
////                    }
////                })
////                .setLayoutRes(R.layout.dialog_layout)
////                .setDimAmount(0.9f)
////                .setTag("BottomDialog")
////                .show();
       new ShareBottomDialog().show(getSupportFragmentManager());
    }

    private void initView(final View view) {

    }
}
