package com.zevent.youness.calculationtools.demandeCategory;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zevent.youness.calculationtools.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import adapter.DemandCategoryAdapter;
import bean.DemandCategory;
import bean.Departement;
import bean.DepartementCriteriaItem;
import config.Configuration;
import helpers.ReadTask;
import helpers.SendIdDemandCategory;

public class DemandCategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listViewDemandCategory;
    List<DemandCategory> demandCategoryList;
    DemandCategoryAdapter demandCategoryAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand_category);

        initViews();

        getDemandCategoryDetails();

        demandCategoryAdapter=new DemandCategoryAdapter(demandCategoryList,this);
        listViewDemandCategory.setAdapter(demandCategoryAdapter);

        listViewDemandCategory.setOnItemClickListener(this);
    }

    public void initViews(){
        listViewDemandCategory =(ListView) findViewById(R.id.listDemandCategory);
    }

    public void getDemandCategoryDetails(){
        demandCategoryList=new ArrayList<DemandCategory>();
       SendIdDemandCategory sendIdDemandCategory=new SendIdDemandCategory();
       sendIdDemandCategory.execute(getIntent().getLongExtra("idDemandCategory",0));
       ReadTask readTask=new ReadTask();
       readTask.execute("http://"+ Configuration.local+":8080/kt_FST_2/webresources/demandCategory/findAll");
       try {
           JSONArray jsonArray=new JSONArray(sendIdDemandCategory.get());
           for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject jsonObject= (JSONObject) jsonArray.get(i);

               DemandCategory demandCategory=new DemandCategory(jsonObject.getLong("id"),(Date) jsonObject.get("dateDemandCategory"),(Departement) jsonObject.get("departement"));
               demandCategoryList.add(demandCategory);
           }
       } catch (InterruptedException | ExecutionException | JSONException e) {
           e.printStackTrace();
       }
        // for (int i = 0; i < 10; i++) {
        //     DemandCategory demandCategory =  new DemandCategory((long) i,new Date(),new Departement((long)i,"dep"+i));
        //     demandCategoryList.add(demandCategory);
        // }
        // System.out.println(demandCategoryList);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        PopupMenu menu = new PopupMenu (this, view);
        final Intent intent= new Intent(this, MenuChartActivity.class);
        menu.setOnMenuItemClickListener (new PopupMenu.OnMenuItemClickListener ()
        {
            @Override
            public boolean onMenuItemClick (MenuItem item)
            {
                int id = item.getItemId();
//                
                if (R.id.stat==id){
                    startActivity(intent);
                }else if(R.id.detail==id){
                    getDetail(position);
                }
                return true;
            }

        });
        menu.inflate (R.menu.demand_category_menu);
        menu.show();
    }

    public void getDetail(int position){

        DemandCategory demandCategory =(DemandCategory) demandCategoryAdapter.getItem(position);


        String[] detail={
                "Id : "+demandCategory.getId(),
                "Departement :"+demandCategory.getDepartment().getName(),
                "Date DemandCategory :"+demandCategory.getDateDemandCategory(),
                "Summ Total :"+demandCategory.getSummTotal(),
                "Summ Druck :"+demandCategory.getSummDruck(),
                "NbrTotalValidation :"+demandCategory.getNbrTotalValidation()

        };
      


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Detail");


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
