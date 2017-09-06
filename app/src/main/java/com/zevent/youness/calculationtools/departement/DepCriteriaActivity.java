package com.zevent.youness.calculationtools.departement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zevent.youness.calculationtools.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


import bean.DepartementCriteria;
import config.Configuration;
import helpers.ReadTask;



/**
 * Created by youness on 2017-08-20.
 */

public class DepCriteriaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listDepsCriteriaView;
    List<String> depsCriteriaName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departement_criteria);

        listDepsCriteriaView = (ListView) findViewById(R.id.listDepCriteria);

        getDepartementCriteria();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,R.layout.dep_criteria_list,R.id.nameDepCriteria,depsCriteriaName);
        System.out.printf("---------------------------------------------------------> "+stringArrayAdapter);
        listDepsCriteriaView.setAdapter(stringArrayAdapter);

        listDepsCriteriaView.setOnItemClickListener(this);


         setTitle("Deps criteria");
        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);

    }

    public void getDepartementCriteria(){
        depsCriteriaName=new ArrayList<String>();
        String name =  getIntent().getStringExtra("depName");

       ReadTask readTask=new ReadTask();
       readTask.execute("http://"+ Configuration.local+":8080/kt_FST_2/webresources/DepartementCriteria/findCriteria/"+name);

       try {
           JSONArray jsonArray=new JSONArray(readTask.get());
           for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject jsonObject= (JSONObject) jsonArray.get(i);

               DepartementCriteria departementCriteria=new DepartementCriteria(jsonObject.getLong("id"),jsonObject.getString("name"));
               depsCriteriaName.add(departementCriteria.getName());
           }
       } catch (InterruptedException | ExecutionException | JSONException e) {
           e.printStackTrace();
       }
      
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(this,DepartementCriteriaItemActivity.class);
        intent.putExtra("depCriteriaName",depsCriteriaName.get(position));
        startActivity(intent);
        finish();
    }
}
