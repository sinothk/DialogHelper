package com.sinothk.dialog.demo.topRightMenu;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sinothk.dialog.demo.R;
import com.sinothk.dialog.topRightMenu.PopMenuItem;
import com.sinothk.dialog.DialogView;

import java.util.ArrayList;

public class TopDialogDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_dialog_demo_activity_main);
    }

    public void style1(View view) {

        final ArrayList<PopMenuItem> menuItems = new ArrayList<>();
        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "考勤统计", R.drawable.ic_prompt_alert_warn));
        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "考统计"));
        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "考勤"));
        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "PopMenu4"));
        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "PopMenu5"));

        DialogView.getTopDialog(this).show(view, menuItems, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TopDialogDemoMainActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
            }
        }, R.color.lineColor, 2);
    }
}
