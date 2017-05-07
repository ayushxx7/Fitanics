package com.oms_infotech.www.fitnessapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    ActionBar bar;
    EditText edphoneno,edname,edweight,edheightft,edheightin;
    Button btn;
    Spinner spincode;
    String name,phoneno,weight,heightft,heightin;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    ArrayList arrayList;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Window window=getWindow();
        window.setStatusBarColor(Color.parseColor("#B3B6B7"));
        bar=getSupportActionBar();
        bar.hide();

        edphoneno=(EditText)findViewById(R.id.edphoneno);
        edname=(EditText)findViewById(R.id.edname);
        edweight=(EditText)findViewById(R.id.edweight);
        edheightft=(EditText)findViewById(R.id.edheightft);
        edheightin=(EditText)findViewById(R.id.edheightin);
        btn=(Button)findViewById(R.id.btncontinue);
        spincode=(Spinner)findViewById(R.id.spincode);

        firebaseAuth=FirebaseAuth.getInstance();

        databaseReference= FirebaseDatabase.getInstance().getReference();
        user= firebaseAuth.getCurrentUser();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInfo();
            }
        });

        arrayList=new ArrayList<String>();
        arrayList.add("+91");
        arrayList.add("+93");
        arrayList.add("+355");
        arrayList.add("+213");
        arrayList.add("+1");
        arrayList.add("+376");
        arrayList.add("+244");
        arrayList.add("+61");
        arrayList.add("+43");
        arrayList.add("+994");
        arrayList.add("+54");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        spincode.setAdapter(arrayAdapter);

    }

    private void saveUserInfo() {

        name=edname.getText().toString();
        phoneno=edphoneno.getText().toString();
        weight=edweight.getText().toString();
        heightft=edheightft.getText().toString();
        heightin=edheightin.getText().toString();


        UserInformation userInformation=new UserInformation(name,phoneno,weight,heightft,heightin);

        databaseReference.child(user.getUid()).setValue(userInformation);
        finish();
        startActivity(new Intent(MainPage.this, activity1.class));
    }
}
