package com.sinothk.dialog;

/**
 * Created by 梁玉涛 on 2017/11/23/023.
 * 描述：
 */

public class DialogButton extends PromptButton {
    public DialogButton(String text, DialogButtonListener listener) {
        super(text, listener);
    }

    public DialogButton(String text, DialogButtonListener listener, boolean delayClick) {
        super(text, listener, delayClick);
    }

    public DialogButton(String text, int textColor, DialogButtonListener listener) {
        super(text, textColor, listener);
    }
}
