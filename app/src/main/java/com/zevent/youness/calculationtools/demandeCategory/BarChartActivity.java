package com.zevent.youness.calculationtools.demandeCategory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zevent.youness.calculationtools.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import config.Configuration;
import helpers.ReadTask;
import im.dacer.androidcharts.BarView;
import utils.MathUtil;

public class BarChartActivity extends AppCompatActivity {

    BarView barView;
    ArrayList<Integer> values;
    ArrayList<String> semestres=new ArrayList<>();

    BigDecimal[][]nums=new BigDecimal[2][12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        initiate();

        getValuesChart();

        setTitle("bar Chart");


    }


    public void getValuesChart() {
          JSONArray jsonArray = new JSONArray(readTask.get());
            values = new ArrayList<Integer>();
            for (int i = 0; i < 2; i++) {


                for (int j = 0; j < 12; j++) {

                    values.add(5*(j+1));
                    nums[i][j] = new BigDecimal(6*j);
                    semestres.add(""+(j+1));

                }

            }
            int max= MathUtil.calculerMax(nums).intValue();
            barView.setDataList(values,max);

            barView.setBottomTextList(semestres);

    }


    public void initiate() {
        barView = (BarView)findViewById(R.id.bar_view);

    }

}
