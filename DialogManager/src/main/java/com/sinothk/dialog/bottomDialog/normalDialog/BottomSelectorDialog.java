/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 baoyongzhang <baoyz94@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sinothk.dialog.bottomDialog.normalDialog;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sinothk.dialog.R;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Elson on 2017/5/16.
 */
@SuppressWarnings("ResourceType")
public class BottomSelectorDialog extends Fragment implements View.OnClickListener {
    private static final String ARG_TITLE_BUTTON_TITLE = "ARG_TITLE_BUTTON_TITLE";
    private static final String ARG_CANCEL_BUTTON_TITLE = "cancel_button_title";
    private static final String ARG_OTHER_BUTTON_TITLES = "other_button_titles";
    private static final String ARG_CANCELABLE_ONTOUCHOUTSIDE = "cancelable_ontouchoutside";
    private static final int CANCEL_BUTTON_ID = 100;
    private static final int BG_VIEW_ID = 10;
    private static final int TRANSLATE_DURATION = 200;
    private static final int ALPHA_DURATION = 300;

    private static final String EXTRA_DISMISSED = "extra_dismissed";

    private boolean mDismissed = true;
    private SelectorDialogListener mListener;
    private View mView;
    private LinearLayout mPanel;
    private ViewGroup mGroup;
    private View mBg;
    private Attributes mAttrs;
    private boolean isCancel = true;

    public void show(final FragmentManager manager, final String tag) {
        if (!mDismissed || manager.isDestroyed()) {
            return;
        }
        mDismissed = false;
        new Handler().post(new Runnable() {
            public void run() {
                FragmentTransaction ft = manager.beginTransaction();
                ft.add(BottomSelectorDialog.this, tag);
                ft.addToBackStack(null);
                ft.commitAllowingStateLoss();
            }
        });
    }

    public void dismiss() {
        if (mDismissed) {
            return;
        }
        mDismissed = true;
        new Handler().post(new Runnable() {
            public void run() {
                getFragmentManager().popBackStack();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.remove(BottomSelectorDialog.this);
                ft.commitAllowingStateLoss();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(EXTRA_DISMISSED, mDismissed);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivity().setTheme(R.style.SelectorDialogsStyleiOS7);
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mDismissed = savedInstanceState.getBoolean(EXTRA_DISMISSED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            View focusView = getActivity().getCurrentFocus();
            if (focusView != null) {
                imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
            }
        }

        mAttrs = readAttribute();

        mView = createView();
        mGroup = (ViewGroup) getActivity().getWindow().getDecorView();

        createItems();

        mGroup.addView(mView);
        mBg.startAnimation(createAlphaInAnimation());
        mPanel.startAnimation(createTranslationInAnimation());

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        mPanel.startAnimation(createTranslationOutAnimation());
        mBg.startAnimation(createAlphaOutAnimation());
        mView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mGroup.removeView(mView);
            }
        }, ALPHA_DURATION);
        if (mListener != null) {
            mListener.onDismiss(this, isCancel);
        }
        super.onDestroyView();
    }

    private Animation createTranslationInAnimation() {
        int type = TranslateAnimation.RELATIVE_TO_SELF;
        TranslateAnimation an = new TranslateAnimation(type, 0, type, 0, type, 1, type, 0);
        an.setDuration(TRANSLATE_DURATION);
        return an;
    }

    private Animation createAlphaInAnimation() {
        AlphaAnimation an = new AlphaAnimation(0, 1);
        an.setDuration(ALPHA_DURATION);
        return an;
    }

    private Animation createTranslationOutAnimation() {
        int type = TranslateAnimation.RELATIVE_TO_SELF;
        TranslateAnimation an = new TranslateAnimation(type, 0, type, 0, type, 0, type, 1);
        an.setDuration(TRANSLATE_DURATION);
        an.setFillAfter(true);
        return an;
    }

    private Animation createAlphaOutAnimation() {
        AlphaAnimation an = new AlphaAnimation(1, 0);
        an.setDuration(ALPHA_DURATION);
        an.setFillAfter(true);
        return an;
    }

    private View createView() {
        FrameLayout parent = new FrameLayout(getActivity());
        parent.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        mBg = new View(getActivity());
        mBg.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        mBg.setBackgroundColor(Color.argb(136, 0, 0, 0));
        mBg.setId(BottomSelectorDialog.BG_VIEW_ID);
        mBg.setOnClickListener(this);

        mPanel = new LinearLayout(getActivity());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.BOTTOM;
        mPanel.setLayoutParams(params);
        mPanel.setOrientation(LinearLayout.VERTICAL);

        parent.setPadding(0, 0, 0, getNavBarHeight(getActivity()));

        parent.addView(mBg);

        parent.addView(mPanel);
        return parent;
    }

    public int getNavBarHeight(Context context) {
        int navigationBarHeight = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Resources rs = context.getResources();
            int id = rs.getIdentifier("navigation_bar_height", "dimen", "android");
            if (id > 0 && checkDeviceHasNavigationBar(context)) {
                navigationBarHeight = rs.getDimensionPixelSize(id);
            }
        }
        return navigationBarHeight;
    }

    private boolean checkDeviceHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasNavigationBar;

    }

    private void createItems() {

        // ==================================取消按钮====================================================
        boolean titleIsEmpty = TextUtils.isEmpty(getTitle());

        if (!titleIsEmpty) {
            TextView titleTv = new TextView(getActivity());
            titleTv.setGravity(Gravity.CENTER);
//            titleTv.getPaint().setFakeBoldText(true);
            titleTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, mAttrs.SelectorDialogTextSize);
            titleTv.setBackgroundDrawable(mAttrs.otherButtonTopBackground);
            titleTv.setText(getTitle());
            titleTv.setTextColor(mAttrs.cancelButtonTextColor);
            LinearLayout.LayoutParams params1 = createButtonLayoutParams();
            params1.topMargin = mAttrs.cancelButtonMarginTop;
            mPanel.addView(titleTv, params1);
        }

        // ==================================内容按钮====================================================
        String[] titles = getOtherButtonTitles();
        if (titles != null) {
            for (int i = 0; i < titles.length; i++) {

                TextView bt = new TextView(getActivity());
                bt.setGravity(Gravity.CENTER);

                bt.setId(CANCEL_BUTTON_ID + i + 1);

                bt.setOnClickListener(this);
                bt.setBackgroundDrawable(getOtherButtonBg(titles, i, titleIsEmpty));
                bt.setText(titles[i]);
                bt.setTextColor(mAttrs.otherButtonTextColor);
                bt.setTextSize(TypedValue.COMPLEX_UNIT_PX, mAttrs.SelectorDialogTextSize);
                if (i > 0) {
                    LinearLayout.LayoutParams params = createButtonLayoutParams();
                    params.topMargin = mAttrs.otherButtonSpacing;
                    mPanel.addView(bt, params);
                } else {
                    mPanel.addView(bt);
                }
            }
        }

        // ==================================取消按钮====================================================
        TextView bt = new TextView(getActivity());
        bt.setGravity(Gravity.CENTER);
        bt.getPaint().setFakeBoldText(true);
        bt.setTextSize(TypedValue.COMPLEX_UNIT_PX, mAttrs.SelectorDialogTextSize);
        bt.setId(BottomSelectorDialog.CANCEL_BUTTON_ID);
        bt.setBackgroundDrawable(mAttrs.cancelButtonBackground);
        bt.setText(getCancelButtonTitle());
        bt.setTextColor(mAttrs.cancelButtonTextColor);
        bt.setOnClickListener(this);

        LinearLayout.LayoutParams params = createButtonLayoutParams();
        params.topMargin = mAttrs.cancelButtonMarginTop;
        mPanel.addView(bt, params);

        mPanel.setBackgroundDrawable(mAttrs.background);
        mPanel.setPadding(mAttrs.padding, mAttrs.padding, mAttrs.padding, mAttrs.padding);
    }

    public LinearLayout.LayoutParams createButtonLayoutParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        return params;
    }

    private Drawable getOtherButtonBg(String[] titles, int i, boolean titleIsEmpty) {

        if (titleIsEmpty) {
            if (titles.length == 1) {
                return mAttrs.otherButtonSingleBackground;
            }
            if (titles.length == 2) {
                switch (i) {
                    case 0:
                        return mAttrs.otherButtonTopBackground;
                    case 1:
                        return mAttrs.otherButtonBottomBackground;
                }
            }
            if (titles.length > 2) {
                if (i == 0) {
                    return mAttrs.otherButtonTopBackground;
                }
                if (i == (titles.length - 1)) {
                    return mAttrs.otherButtonBottomBackground;
                }
                return mAttrs.getOtherButtonMiddleBackground();
            }
        } else {

            if (titles.length == 1) {
                return mAttrs.otherButtonBottomBackground;
            }

            if (titles.length == 2) {
                switch (i) {
                    case 0:
                        return mAttrs.getOtherButtonMiddleBackground();
                    case 1:
                        return mAttrs.otherButtonBottomBackground;
                }
            }
            if (titles.length > 2) {
                if (i == 0) {
                    return mAttrs.getOtherButtonMiddleBackground();
                }
                if (i == (titles.length - 1)) {
                    return mAttrs.otherButtonBottomBackground;
                }
                return mAttrs.getOtherButtonMiddleBackground();
            }
        }
        return null;
    }

    private Attributes readAttribute() {
        Attributes attrs = new Attributes(getActivity());
        TypedArray a = getActivity().getTheme().obtainStyledAttributes(null, R.styleable.SelectorDialog, R.attr.selectorDialogStyle, 0);
        Drawable background = a.getDrawable(R.styleable.SelectorDialog_selectorDialogBackground);
        if (background != null) {
            attrs.background = background;
        }

        Drawable cancelButtonBackground = a.getDrawable(R.styleable.SelectorDialog_cancelButtonBackground);
        if (cancelButtonBackground != null) {
            attrs.cancelButtonBackground = cancelButtonBackground;
        }
        Drawable otherButtonTopBackground = a.getDrawable(R.styleable.SelectorDialog_otherButtonTopBackground);
        if (otherButtonTopBackground != null) {
            attrs.otherButtonTopBackground = otherButtonTopBackground;
        }
        Drawable otherButtonMiddleBackground = a.getDrawable(R.styleable.SelectorDialog_otherButtonMiddleBackground);
        if (otherButtonMiddleBackground != null) {
            attrs.otherButtonMiddleBackground = otherButtonMiddleBackground;
        }
        Drawable otherButtonBottomBackground = a.getDrawable(R.styleable.SelectorDialog_otherButtonBottomBackground);
        if (otherButtonBottomBackground != null) {
            attrs.otherButtonBottomBackground = otherButtonBottomBackground;
        }
        Drawable otherButtonSingleBackground = a.getDrawable(R.styleable.SelectorDialog_otherButtonSingleBackground);
        if (otherButtonSingleBackground != null) {
            attrs.otherButtonSingleBackground = otherButtonSingleBackground;
        }
        attrs.cancelButtonTextColor = a.getColor(R.styleable.SelectorDialog_cancelButtonTextColor, attrs.cancelButtonTextColor);
        attrs.otherButtonTextColor = a.getColor(R.styleable.SelectorDialog_otherButtonTextColor, attrs.otherButtonTextColor);
        attrs.padding = (int) a.getDimension(R.styleable.SelectorDialog_selectorDialogPadding, attrs.padding);
        attrs.otherButtonSpacing = (int) a.getDimension(R.styleable.SelectorDialog_otherButtonSpacing, attrs.otherButtonSpacing);
        attrs.cancelButtonMarginTop = (int) a.getDimension(R.styleable.SelectorDialog_cancelButtonMarginTop, attrs.cancelButtonMarginTop);
        attrs.SelectorDialogTextSize = a.getDimensionPixelSize(R.styleable.SelectorDialog_selectorDialogTextSize, (int) attrs.SelectorDialogTextSize);

        a.recycle();
        return attrs;
    }

    private String getTitle() {
        return getArguments().getString(ARG_TITLE_BUTTON_TITLE);
    }

    private String getCancelButtonTitle() {
        return getArguments().getString(ARG_CANCEL_BUTTON_TITLE);
    }

    private String[] getOtherButtonTitles() {
        return getArguments().getStringArray(ARG_OTHER_BUTTON_TITLES);
    }

    private boolean getCancelableOnTouchOutside() {
        return getArguments().getBoolean(ARG_CANCELABLE_ONTOUCHOUTSIDE);
    }

    public void setSelectorDialogListener(SelectorDialogListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == BottomSelectorDialog.BG_VIEW_ID && !getCancelableOnTouchOutside()) {
            return;
        }
        dismiss();
        if (v.getId() != BottomSelectorDialog.CANCEL_BUTTON_ID && v.getId() != BottomSelectorDialog.BG_VIEW_ID) {
            if (mListener != null) {
                mListener.onOtherButtonClick(this, v.getId() - CANCEL_BUTTON_ID - 1);
            }
            isCancel = false;
        }
    }

    public static Builder createBuilder(Context context, FragmentManager fragmentManager) {
        return new Builder(context, fragmentManager);
    }

    private static class Attributes {
        private Context mContext;

        public Attributes(Context context) {
            mContext = context;
            this.background = new ColorDrawable(Color.TRANSPARENT);
            this.cancelButtonBackground = new ColorDrawable(Color.BLACK);

            ColorDrawable gray = new ColorDrawable(Color.GRAY);
            this.otherButtonTopBackground = gray;
            this.otherButtonMiddleBackground = gray;
            this.otherButtonBottomBackground = gray;
            this.otherButtonSingleBackground = gray;
            this.cancelButtonTextColor = Color.WHITE;
            this.otherButtonTextColor = Color.BLACK;
            this.padding = dp2px(20);
            this.otherButtonSpacing = dp2px(2);
            this.cancelButtonMarginTop = dp2px(10);
            this.SelectorDialogTextSize = dp2px(18);
            this.SelectorDialogTitleTextSize = dp2px(10);
        }

        private int dp2px(int dp) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, mContext.getResources().getDisplayMetrics());
        }

        public Drawable getOtherButtonMiddleBackground() {
            if (otherButtonMiddleBackground instanceof StateListDrawable) {
                TypedArray a = mContext.getTheme().obtainStyledAttributes(null, R.styleable.SelectorDialog, R.attr.selectorDialogStyle, 0);
                otherButtonMiddleBackground = a.getDrawable(R.styleable.SelectorDialog_otherButtonMiddleBackground);
                a.recycle();
            }
            return otherButtonMiddleBackground;
        }

        Drawable background;
        Drawable cancelButtonBackground;
        Drawable otherButtonTopBackground;
        Drawable otherButtonMiddleBackground;
        Drawable otherButtonBottomBackground;
        Drawable otherButtonSingleBackground;
        int cancelButtonTextColor;
        int otherButtonTextColor;
        int padding;
        int otherButtonSpacing;
        int cancelButtonMarginTop;
        float SelectorDialogTextSize;
        float SelectorDialogTitleTextSize;
    }

    public static class Builder {

        private Context mContext;
        private FragmentManager mFragmentManager;

        private String mTitle;
        private String mCancelButtonTitle;
        private String[] mOtherButtonTitles;
        private String mTag = "SelectorDialog";
        private boolean mCancelableOnTouchOutside;
        private SelectorDialogListener mListener;

        public Builder(Context context, FragmentManager fragmentManager) {
            mContext = context;
            mFragmentManager = fragmentManager;
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public Builder setCancelButtonTitle(String title) {
            mCancelButtonTitle = title;
            return this;
        }

        public Builder setCancelButtonTitle(int strId) {
            return setCancelButtonTitle(mContext.getString(strId));
        }

        /**
         * 设置数据
         *
         * @param titles
         * @return
         */
        public Builder setOtherButtonTitles(String... titles) {
            mOtherButtonTitles = titles;
            return this;
        }

        /**
         * 设置数据
         *
         * @param titles
         * @return
         */
        public Builder setOtherButtonTitles(ArrayList<String> titles) {
            mOtherButtonTitles = titles.toArray(new String[0]);//titles.toArray(mOtherButtonTitles);
            return this;
        }

        public Builder setTag(String tag) {
            mTag = tag;
            return this;
        }

        public Builder setListener(SelectorDialogListener listener) {
            this.mListener = listener;
            return this;
        }

        public Builder setCancelableOnTouchOutside(boolean cancelable) {
            mCancelableOnTouchOutside = cancelable;
            return this;
        }

        public Bundle prepareArguments() {
            Bundle bundle = new Bundle();
            bundle.putString(ARG_TITLE_BUTTON_TITLE, mTitle);
            bundle.putString(ARG_CANCEL_BUTTON_TITLE, mCancelButtonTitle);
            bundle.putStringArray(ARG_OTHER_BUTTON_TITLES, mOtherButtonTitles);
            bundle.putBoolean(ARG_CANCELABLE_ONTOUCHOUTSIDE, mCancelableOnTouchOutside);
            return bundle;
        }

        public BottomSelectorDialog show() {
            BottomSelectorDialog SelectorDialog = (BottomSelectorDialog) Fragment.instantiate(mContext, BottomSelectorDialog.class.getName(), prepareArguments());
            SelectorDialog.setSelectorDialogListener(mListener);
            SelectorDialog.show(mFragmentManager, mTag);
            return SelectorDialog;
        }
    }

    public interface SelectorDialogListener {

        void onDismiss(BottomSelectorDialog SelectorDialog, boolean isCancel);

        void onOtherButtonClick(BottomSelectorDialog SelectorDialog, int index);
    }

}
