package com.sinothk.dialog.demo.bottomDialog.dateSelected;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sinothk.dialog.bottomDialog.dateDialog.TimePickerDialog;
import com.sinothk.dialog.bottomDialog.dateDialog.data.Type;
import com.sinothk.dialog.bottomDialog.dateDialog.listener.OnDateSetListener;
import com.sinothk.dialog.bottomDialog.dateDialog.utils.Utils;
import com.sinothk.dialog.demo.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSelectedDemoActivity extends AppCompatActivity implements View.OnClickListener, OnDateSetListener {

    TimePickerDialog mDialogAll;
    TimePickerDialog mDialogYearMonth;
    TimePickerDialog mDialogYearMonthDay;
    TimePickerDialog mDialogMonthDayHourMinute;
    TimePickerDialog mDialogHourMinute;
    TextView mTvTime;

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_date_selected_demo);

        initView();
        long tenYears = 100L * 365 * 1000 * 60 * 60 * 24L;

        mDialogAll = new TimePickerDialog.Builder()
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("时间选择")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis() - tenYears)
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(Utils.sp2px(this, 10))
                .setCallBack(this)
                .build();

        mDialogYearMonth = new TimePickerDialog.Builder()
                .setTitleStringId("时间选择")
                .setType(Type.YEAR_MONTH)
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                .setCallBack(this)
                .build();

        mDialogYearMonthDay = new TimePickerDialog.Builder()
                .setTitleStringId("时间选择")
                .setType(Type.YEAR_MONTH_DAY)
                .setCallBack(this)
                .build();

        mDialogMonthDayHourMinute = new TimePickerDialog.Builder()
                .setTitleStringId("时间选择")
                .setType(Type.MONTH_DAY_HOUR_MIN)
                .setCallBack(this)
                .build();

        mDialogHourMinute = new TimePickerDialog.Builder()
                .setTitleStringId("时间选择")
                .setType(Type.HOURS_MINS)
                .setCallBack(this)
                .build();
    }

    void initView() {
        findViewById(R.id.btn_all).setOnClickListener(this);
        findViewById(R.id.btn_year_month_day).setOnClickListener(this);
        findViewById(R.id.btn_year_month).setOnClickListener(this);
        findViewById(R.id.btn_month_day_hour_minute).setOnClickListener(this);
        findViewById(R.id.btn_hour_minute).setOnClickListener(this);

        mTvTime = (TextView) findViewById(R.id.tv_time);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_all:
                mDialogAll.show(getSupportFragmentManager(), "all");
                break;
            case R.id.btn_year_month:
                mDialogYearMonth.show(getSupportFragmentManager(), "year_month");
                break;
            case R.id.btn_year_month_day:
                mDialogYearMonthDay.show(getSupportFragmentManager(), "year_month_day");
                break;
            case R.id.btn_month_day_hour_minute:
                mDialogMonthDayHourMinute.show(getSupportFragmentManager(), "month_day_hour_minute");
                break;
            case R.id.btn_hour_minute:
                mDialogHourMinute.show(getSupportFragmentManager(), "hour_minute");
                break;
        }
    }


    @Override
    public void onDateSet(TimePickerDialog timePickerDialog, long millseconds) {
        String text = getDateToString(millseconds);
        mTvTime.setText(text);
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }
}
