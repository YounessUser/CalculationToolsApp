package com.zevent.youness.calculationtools.departement;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import com.zevent.youness.calculationtools.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import adapter.DepartementDetailAdapter;
import bean.Departement;
import config.Configuration;
import helpers.ReadTask;
import helpers.SendIdDepartement;

/**
 * Created by youness on 2017-08-09.
 */

public class DepartementActivityDetail extends AppCompatActivity {

    ListView listViewDepartement;
    List<Departement> departementList;
    DepartementDetailAdapter departementDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departement_detail);

        initViews();

        getDepartementDetails();

        departementDetailAdapter=new DepartementDetailAdapter(departementList,this);
        listViewDepartement.setAdapter(departementDetailAdapter);


    }

    public void initViews(){
        listViewDepartement =(ListView) findViewById(R.id.listDeps);
    }

    public void getDepartementDetails(){
        departementList=new ArrayList<Departement>();
//        SendIdDepartement sendIdDepartement=new SendIdDepartement();
//        sendIdDepartement.execute(getIntent().getLongExtra("idDepartement",0));
        ReadTask readTask=new ReadTask();
        readTask.execute("http://"+ Configuration.local+":8080/kt_FST_2/webresources/departement/findAllDeps");

        try {
            JSONArray jsonArray=new JSONArray(readTask.get());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject= (JSONObject) jsonArray.get(i);

                Departement departement=new Departement(jsonObject.getLong("id"),jsonObject.getString("name"));
                departementList.add(departement);
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }


    }
}
