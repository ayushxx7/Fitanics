package com.oms_infotech.www.fitnessapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    ActionBar bar;
    EditText edemail,edpass;
    Button butcontinue;
    String email,pass;
    TextView tvsignup;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressdialog;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Window window=this.getWindow();
        window.setStatusBarColor(Color.parseColor("#B3B6B7"));
        bar=getSupportActionBar();
        bar.hide();


        edemail=(EditText)findViewById(R.id.edemail);
        edpass=(EditText)findViewById(R.id.edpass);
        butcontinue=(Button)findViewById(R.id.butcontinue);
        tvsignup=(TextView) findViewById(R.id.textViewsignup);
        progressdialog=new ProgressDialog(this);

        firebaseAuth=FirebaseAuth.getInstance();
        butcontinue.setEnabled(false);

        if (firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(SignupActivity.this,CalorieCounter.class));
        }

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(SignupActivity.this,MainActivity.class));
            }
        });

        edpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                butcontinue.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edpass.length()>0){
                    butcontinue.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable){

            }
        });


        butcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                loginuser();
            }
        });

    }

    private void loginuser() {
        email=edemail.getText().toString();
        pass=edpass.getText().toString();

        progressdialog.setMessage("Loading...");
        progressdialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressdialog.dismiss();
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(SignupActivity.this,CalorieCounter.class));
                }else{
                    Toast.makeText(SignupActivity.this, "Invalid username/password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
