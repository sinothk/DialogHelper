package com.sinothk.dialog.demo.topRightMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.sinothk.dialog.DialogManager;
import com.sinothk.dialog.demo.R;
import com.sinothk.dialog.topRightMenu.PopMenuItem;

import java.util.ArrayList;

public class TRMMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trm_activity_main);

        final ArrayList<PopMenuItem> menuItems = new ArrayList<>();
        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "考勤统计"));
        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "考统计"));
        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "考勤"));
//        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "PopMenu4"));
//        menuItems.add(new PopMenuItem(R.mipmap.ic_launcher, "PopMenu5"));

        findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogManager.PopMenuView
                        .createPopMenu(TRMMainActivity.this)//, 420
                        .addMenuItemData(menuItems, new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(TRMMainActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show(v);
            }
        });
    }
}
