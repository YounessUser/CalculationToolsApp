package com.zevent.youness.calculationtools;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.zevent.youness.calculationtools.demandeCategory.DemandCategoryActivity;
import com.zevent.youness.calculationtools.departement.DepartementActivity;
import com.zevent.youness.calculationtools.departement.DepartementActivityDetail;

import bean.Departement;
import utils.Connectivity;

public class MenuActivity extends AppCompatActivity {


    TextView userConnecte;
    Button departement;
     Button demandCatgoryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().hide();

        initViews();

        String userName=getIntent().getStringExtra("userName");
        if(userName!=null){
            String mystring=new String("Bienvenue "+userName);
            SpannableString content = new SpannableString(mystring);
            content.setSpan(new UnderlineSpan(), 0, mystring.length(), 0);
            userConnecte.setText(content);
        }
        else{
            SharedPreferences prefs = getSharedPreferences("userName", MODE_PRIVATE);
            String restoreduserName = prefs.getString("userName", null);
            String mystring=new String("Bienvenue "+restoreduserName);
            SpannableString content = new SpannableString(mystring);
            content.setSpan(new UnderlineSpan(), 0, mystring.length(), 0);
            userConnecte.setText(content);
        }
    }

    void initViews(){
        userConnecte= (TextView) findViewById(R.id.userConnecte);
        departement=(Button) findViewById(R.id.departement);
        demandCatgoryBtn = (Button) findViewById(R.id.demandCategory);
    }

    public void departementClick(View view) {
        if(Connectivity.isConnected(this)){
            startActivity(new Intent(this, DepartementActivity.class));
            finish();
        }
        else {
            Toast.makeText(this,"u r offline", Toast.LENGTH_SHORT).show();
        }
    }

    public void demandCategoryClick(View view) {
        if(Connectivity.isConnected(this)){
            startActivity(new Intent(this, DemandCategoryActivity.class));
            finish();
        }
        else {
            Toast.makeText(this,"u r offline", Toast.LENGTH_SHORT).show();
        }
    }

    public void configurationClick(View view){}

    public void notificationClick(View view){}

   



}
