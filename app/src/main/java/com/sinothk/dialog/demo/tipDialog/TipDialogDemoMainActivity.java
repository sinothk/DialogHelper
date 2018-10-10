package com.sinothk.dialog.demo.tipDialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sinothk.dialog.demo.R;
import com.sinothk.dialog.tipDialog.PromptDialog;
import com.sinothk.helpers.dialog.DialogHelper;

/**
 * github:limxing
 */
public class TipDialogDemoMainActivity extends AppCompatActivity {
    PromptDialog promptDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_dialog_demo_main);

//        promptDialog = new PromptDialog(this);
//
//        //设置自定义属性
//        promptDialog.getDefaultBuilder()
//                .touchAble(true)
//                .round(3)
//                .loadingDuration(3000);
//
//
//        //按钮的定义，创建一个按钮的对象
//        final DialogButton confirm = new DialogButton("确定", new DialogButtonListener() {
//            @Override
//            public void onClick(DialogButton button) {
//                Toast.makeText(TipDialogDemoMainActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        confirm.setTextColor(Color.parseColor("#DAA520"));
//        confirm.setFocusBacColor(Color.parseColor("#FAFAD2"));
//        confirm.setDelyClick(true);//点击后，是否再对话框消失后响应按钮的监听事件
////
//        findViewById(R.id.main_warn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                promptDialog.showWarnAlert("你确定要退出登录？", new DialogButton("取消", new DialogButtonListener() {
//                    @Override
//                    public void onClick(DialogButton button) {
//                        Toast.makeText(TipDialogDemoMainActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
//                    }
//                }), confirm);
//            }
//        });
//
//
//        findViewById(R.id.main_system).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //可创建android效果的底部Sheet选择，默认IOS效果，sheetCellPad=0为Android效果的Sheet
////                promptDialog.getAlertDefaultBuilder().sheetCellPad(0).round(0);
//                //设置按钮的特点，颜色大小什么的，具体看PromptButton的成员变量
//                DialogButton cancel = new DialogButton("取消", null);
//                cancel.setTextColor(Color.parseColor("#FF0000"));
//                //设置显示的文字大小及颜色
////                promptDialog.getAlertDefaultBuilder().textSize(12).textColor(Color.RED);
//                //默认两个按钮为Alert对话框，大于三个按钮的为底部SHeet形式展现
//
//
//                DialogButton[] btns = {new DialogButton("男", new DialogButtonListener() {
//                    @Override
//                    public void onClick(DialogButton button) {
//                        Toast.makeText(TipDialogDemoMainActivity.this, "男", Toast.LENGTH_SHORT).show();
//                    }
//                }), new DialogButton("男", new DialogButtonListener() {
//                    @Override
//                    public void onClick(DialogButton button) {
//                        Toast.makeText(TipDialogDemoMainActivity.this, "男", Toast.LENGTH_SHORT).show();
//                    }
//                })};
//
//                promptDialog.showAlertSheet("选择性别", true, cancel,
//                        new DialogButton("男", new DialogButtonListener() {
//                            @Override
//                            public void onClick(DialogButton button) {
//                                Toast.makeText(TipDialogDemoMainActivity.this, "男", Toast.LENGTH_SHORT).show();
//                            }
//                        }),
//                        new DialogButton("女", new DialogButtonListener() {
//                            @Override
//                            public void onClick(DialogButton button) {
//                                Toast.makeText(TipDialogDemoMainActivity.this, "女", Toast.LENGTH_SHORT).show();
//                            }
//                        }),
//                        new DialogButton("选项3", Color.GREEN, null),
//                        new DialogButton("选项4", Color.GREEN, null));
//            }
//        });
//
//        findViewById(R.id.main_ad).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                promptDialog.getDefaultBuilder().backAlpha(150);
//                Glide.with(TipDialogDemoMainActivity.this).load("https://timgsa.baidu.com/timg?image&quality=80&" +
//                        "size=b9999_10000&sec=1495518782659&di=25b120262114749ae8543652d2de5715&" +
//                        "imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2Fallimg%2F160316%2F9-160316152R5.jpg")
////                        .placeholder(getResources().getDrawable(R.drawable.ic_prompt_holder))
//                        .into(promptDialog.showAd(true, new OnAdClickListener() {
//                            @Override
//                            public void onAdClick() {
//                                Toast.makeText(TipDialogDemoMainActivity.this, "点击了广告", Toast.LENGTH_SHORT).show();
//                            }
//                        }));
//            }
//        });

    }

//    /**
//     * 根据需要处理返回键，这里主要针对Alert和Sheet的对话框的返回处理
//     */
//    @Override
//    public void onBackPressed() {
////        if (promptDialog.onBackPressed())
////            super.onBackPressed();
//    }

    public void warningTip(View view) {
        DialogHelper.getTipDialog(this).showWarn("注意");
    }

    public void successTip(View view) {
        DialogHelper.getTipDialog(this).showSuccess("登陆成功");
    }

    public void errorTip(View view) {
        DialogHelper.getTipDialog(this).showError("登录失败");
    }

    public void showInfo(View view) {
        DialogHelper.getTipDialog(this).showInfo("成功了");
    }

    public void showCustom(View view) {
        DialogHelper.getTipDialog(this).showCustom(R.mipmap.ic_launcher, "自定义图标的");
    }
}
