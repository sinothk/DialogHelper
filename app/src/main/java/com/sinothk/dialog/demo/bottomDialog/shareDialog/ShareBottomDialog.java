package com.sinothk.dialog.demo.bottomDialog.shareDialog;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sinothk.dialog.bottomDialog.shareDialog.BaseBottomDialog;
import com.sinothk.dialog.demo.R;

/**
 * Created by shaohui on 16/10/11.
 */

public class ShareBottomDialog extends BaseBottomDialog {

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_layout;
    }

    @Override
    public void bindView(View v) {
        // do any thing you want

        RelativeLayout mRlWechat = v.findViewById(R.id.mRlWechat);
        mRlWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "微信", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }
}
