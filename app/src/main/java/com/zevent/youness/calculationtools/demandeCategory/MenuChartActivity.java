package com.zevent.youness.calculationtools.demandeCategory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zevent.youness.calculationtools.R;

public class MenuChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_chart);
    }

    public void lineClick(View view) {
        startActivity(new Intent(this, LineChartActivity.class));
    }

    public void barClick(View view) {
        startActivity(new Intent(this, BarChartActivity.class));
    }
}
