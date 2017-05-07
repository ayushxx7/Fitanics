package com.oms_infotech.www.fitnessapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
RelativeLayout rlbreakfast,rllunch,rldinner,rlexer,rlsnacks,rlwater;
    ActionBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bar=getSupportActionBar();
        bar.hide();
        rlbreakfast=(RelativeLayout)findViewById(R.id.rlbreakfast);
        rllunch=(RelativeLayout)findViewById(R.id.rllunch);
        rldinner=(RelativeLayout)findViewById(R.id.rldinner);
        rlexer=(RelativeLayout)findViewById(R.id.rlexercise);
        rlsnacks=(RelativeLayout)findViewById(R.id.rlsnacks);
        rlwater=(RelativeLayout)findViewById(R.id.rlwater);

        rlbreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Foodtype.class);
                startActivity(intent);
            }
        });
        rllunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Foodtype.class);
                startActivity(intent);
            }
        });rldinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Foodtype.class);
                startActivity(intent);
            }
        });rlsnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Foodtype.class);
                startActivity(intent);
            }
        });
        rlexer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Exercises.class);
                startActivity(intent);

            }
        });
    }

}
