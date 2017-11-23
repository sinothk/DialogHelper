package com.sinothk.dialog;

import android.app.Activity;

/**
 * Created by 梁玉涛 on 2017/11/23/023.
 * 描述：来自https://github.com/limxing/Android-PromptDialog
 */

public final class DialogHelper extends PromptDialog {
    public DialogHelper(Activity context) {
        super(context);
    }

    public DialogHelper(Builder builder, Activity context) {
        super(builder, context);
    }
}
