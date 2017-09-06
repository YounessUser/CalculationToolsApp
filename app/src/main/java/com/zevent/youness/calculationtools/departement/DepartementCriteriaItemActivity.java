package com.zevent.youness.calculationtools.departement;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zevent.youness.calculationtools.R;

import java.util.ArrayList;
import java.util.List;

import adapter.DepCriteriaItemAdapter;
import bean.DepartementCriteriaItem;

public class DepartementCriteriaItemActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listDepCriteriaItemView;
    List<DepartementCriteriaItem> departementCriteriaItemList;
    DepCriteriaItemAdapter depCriteriaItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departement_criteria_item);

        listDepCriteriaItemView = (ListView) findViewById(R.id.listDepCriteriaItem);



        getDepartementCriteriaItem();
        depCriteriaItemAdapter = new DepCriteriaItemAdapter(departementCriteriaItemList,this);
        listDepCriteriaItemView.setAdapter(depCriteriaItemAdapter);

        listDepCriteriaItemView.setOnItemClickListener(this);

        setTitle("Deps criteria Item");

    }

    public void getDepartementCriteriaItem(){
        departementCriteriaItemList = new ArrayList<DepartementCriteriaItem>();

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
       DepartementCriteriaItem departementCriteriaItem =(DepartementCriteriaItem) depCriteriaItemAdapter.getItem(position);

        String[] detail={"Description :"+departementCriteriaItem.getDescription(),"DescriptionGlobal :"+departementCriteriaItem.getDescriptionGlobal(),"ArithmitiqueExpresionForGlobalPrice"+departementCriteriaItem.getArithmitiqueExpresionForGlobalPrice(),"ArithmitiqueExpresionForUnitePrice"+departementCriteriaItem.getArithmitiqueExpresionForUnitePrice()};
        // setup the alert builder


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Detail");

// add a list

        builder.setItems(detail, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                System.out.println(which);
            }
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
