package com.sinothk.dialog.loading;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.sinothk.dialog.R;

/**
 * 进度条对话框
 * Created by Administrator on 2017/5/23 0023.
 */


class LoadDialog extends Dialog {


    private TextView mTextView;

    LoadDialog(@NonNull Context context) {
        super(context, R.style.LoadDialogStyle);
        setContentView(R.layout.loading_dialog);
        mTextView = (TextView) findViewById(R.id.id_text);
        mTextView.setVisibility(View.GONE);
    }

    /**
     * 设置为空，方式内存泄漏
     */
    public void setTextViewNull() {
        mTextView = null;
    }

    /**
     * 设置文字
     *
     * @param msg
     */
    public void setText(String msg) {
        mTextView.setVisibility(View.VISIBLE);
        mTextView.setText(msg);
    }

    public void ShowText() {
        mTextView.setVisibility(View.VISIBLE);
    }

    private void Rotate(ImageView img) {
        RotateAnimation rotateAnimation = new RotateAnimation(0f, -360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setInterpolator(new LinearInterpolator());//不停顿
        rotateAnimation.setRepeatCount(-1);           //重复次数
        img.startAnimation(rotateAnimation); //开启动画
    }


}
