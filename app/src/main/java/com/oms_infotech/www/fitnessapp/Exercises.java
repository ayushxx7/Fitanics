package com.oms_infotech.www.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Exercises extends AppCompatActivity {

    RelativeLayout step,pushup,squat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        step=(RelativeLayout)findViewById(R.id.rlbreakfast);
        squat=(RelativeLayout)findViewById(R.id.rllunch);
        pushup=(RelativeLayout)findViewById(R.id.rldinner);

        step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(Exercises.this,)
            }
        });

        squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        pushup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Exercises.this,ProximityCounter.class);
                startActivity(intent);
            }
        });


    }
}
