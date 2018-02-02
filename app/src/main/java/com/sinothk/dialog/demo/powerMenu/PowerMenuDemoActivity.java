package com.sinothk.dialog.demo.powerMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sinothk.dialog.demo.R;

public class PowerMenuDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_menu_demo);


//        findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PowerMenu powerMenu = new PowerMenu.Builder(PowerMenuDemoActivity.this)
////                        .addItemList(list) // list has "Novel", "Poerty", "Art"
//                        .addItem(new PowerMenuItem("Journals", false))
//                        .addItem(new PowerMenuItem("Travel", true))
//                        .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT) // Animation start point (TOP | LEFT)
//                        .setMenuRadius(10f)
//                        .setMenuShadow(10f)
//                        .setTextColor(getResources().getColor(R.color.colorAccent))
//                        .setSelectedTextColor(Color.WHITE)
//                        .setMenuColor(Color.WHITE)
//                        .setSelectedMenuColor(PowerMenuDemoActivity.this.getResources().getColor(R.color.colorPrimary))
////                        .setOnMenuItemClickListener(onMenuItemClickListener)
//                        .build();
//            }
//        });




    }
}
