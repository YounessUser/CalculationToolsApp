package com.zevent.youness.calculationtools.departement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

import bean.Departement;
import config.Configuration;
import helpers.ReadTask;

public class DepartementActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    ListView listDepsView;
    List<String> depsName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departement);

        initView();
        getDepartementDetails();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,R.layout.department_list,R.id.nameDep,depsName);
        listDepsView.setAdapter(stringArrayAdapter);
        listDepsView.setOnItemClickListener(this);
   }

    public void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Departements");
        setSupportActionBar(toolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listDepsView = (ListView) findViewById(R.id.listDeparts);
    }

    public void getDepartementDetails(){
        depsName=new ArrayList<String>();
       ReadTask readTask=new ReadTask();
       readTask.execute("http://"+ Configuration.local+":8080/kt_FST_2/webresources/departement/findAllDeps");

       try {
           JSONArray jsonArray=new JSONArray(readTask.get());
           for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject jsonObject= (JSONObject) jsonArray.get(i);

               Departement departement=new Departement(jsonObject.getLong("id"),jsonObject.getString("name"));
               depsName.add(departement.getName());
           }
       } catch (InterruptedException | ExecutionException | JSONException e) {
           e.printStackTrace();
       }


    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.departement, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_principal) {

        } else if (id == R.id.recherche) {

        }else if (id == R.id.statistique) {

        } else if (id == R.id.deconnecter) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        final int pos=position;
        Intent intent=new Intent(this,DepCriteriaActivity.class);
        intent.putExtra("depName",depsName.get(pos));
        startActivity(intent);
        finish();

    }
}
