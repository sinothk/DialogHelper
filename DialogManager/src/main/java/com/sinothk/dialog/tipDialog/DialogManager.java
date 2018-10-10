package com.sinothk.dialog.tipDialog;

import android.app.Activity;

/**
 * Created by 梁玉涛 on 2017/11/23/023.
 * 描述：来自https://github.com/limxing/Android-PromptDialog
 */
@Deprecated
public final class DialogManager extends PromptDialog {

    public DialogManager(Activity context) {
        super(context);
    }

    public DialogManager(Builder builder, Activity context) {
        super(builder, context);
    }
}
