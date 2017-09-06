package com.zevent.youness.calculationtools;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import bean.User;
import helpers.SendUserTask;
import utils.Connectivity;

public class MainActivity extends AppCompatActivity {

    TextInputLayout userNameEditLayout;
    TextInputLayout passwordEditLayout;
    EditText userNameEdit;
    EditText passwordEdit;
    Button connecterBtn;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();
        initActions();
    }

    private void initActions() {
        connecterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userNameEdit.getText().toString().equals("")  && passwordEdit.getText().toString().equals("") ){
                    userNameEditLayout.setErrorEnabled(true);
                    passwordEditLayout.setErrorEnabled(true);
                    userNameEditLayout.setError("veuillez remplir votre username ");
                    passwordEditLayout.setError("veuillez remplir votre mot de passe ");
                }
                else if(userNameEdit.getText().toString().equals("") && !passwordEdit.getText().toString().equals("") ){
                    userNameEditLayout.setErrorEnabled(true);
                    userNameEditLayout.setError("veuillez remplir votre username ");
                    passwordEditLayout.setError(null);
                    passwordEditLayout.setErrorEnabled(false);
                }
                else if(passwordEdit.getText().toString().equals("") && !userNameEdit.getText().toString().equals("")){
                    passwordEditLayout.setErrorEnabled(true);
                    passwordEditLayout.setError("veuillez remplir votre mot de passe ");
                    userNameEditLayout.setError(null);
                    userNameEditLayout.setErrorEnabled(false);
                }
                else if (!userNameEdit.getText().toString().equals("")  && !passwordEdit.getText().toString().equals(""))  {
                    userNameEditLayout.setError(null);
                    passwordEditLayout.setError(null);
                    userNameEditLayout.setErrorEnabled(false);
                    passwordEditLayout.setErrorEnabled(false);

                    if(Connectivity.isConnected(MainActivity.this)){
                        progressBar.setVisibility(View.VISIBLE);
                        User user=new User(userNameEdit.getText().toString(),passwordEdit.getText().toString());
                        SendUserTask sendUserTask =new SendUserTask();
                        sendUserTask.execute(user);
                        try {
                            Toast.makeText(MainActivity.this,sendUserTask.get() ,Toast.LENGTH_SHORT).show();
                            System.out.println(sendUserTask.get());
                            try {
                                int res=Integer.parseInt(sendUserTask.get());
                                    System.out.println("res == " +res);
                                if(res==1){
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                                    intent.putExtra("userName",userNameEdit.getText().toString());
                                    startActivity(intent);
                                    finish();
                                }else{
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity.this,"données erronées",Toast.LENGTH_SHORT).show();
                                }

                            }catch (Exception e){
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(MainActivity.this,"problème réseau", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }


                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                    else {

                        Toast.makeText(MainActivity.this,"u r offline", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void initViews() {
        userNameEditLayout= (TextInputLayout) findViewById(R.id.userNameEditLayout);
        passwordEditLayout= (TextInputLayout) findViewById(R.id.passwordEditLayout);
        userNameEdit= (EditText) findViewById(R.id.userNameEdit);
        passwordEdit= (EditText) findViewById(R.id.passwordEdit);
        connecterBtn= (Button) findViewById(R.id.connecterBtn);

        progressBar= (ProgressBar) findViewById(R.id.progressBar);

        performAnimationToViews();

    }

    private void performAnimationToViews() {
        Animation loginAnim= AnimationUtils.loadAnimation(this, R.anim.login_anim);
        Animation usernameAnim=AnimationUtils.loadAnimation(this,R.anim.username_anim);
        Animation passwordAnim=AnimationUtils.loadAnimation(this,R.anim.password_anim);
        connecterBtn.startAnimation(loginAnim);
        userNameEditLayout.startAnimation(usernameAnim);
        passwordEditLayout.startAnimation(passwordAnim);
    }

}
