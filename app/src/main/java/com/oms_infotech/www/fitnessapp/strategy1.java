package com.oms_infotech.www.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class strategy1 extends AppCompatActivity {
    RadioGroup radioGroup2;
    RadioButton rad4,rad5,rad6;
    Button btn2;
    TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy1);

        radioGroup2=(RadioGroup) findViewById(R.id.Radiogroup2);
        rad4=(RadioButton)findViewById(R.id.radioButton4);
        rad5=(RadioButton)findViewById(R.id.radioButton5);
        rad6=(RadioButton)findViewById(R.id.radioButton6);
        btn2=(Button)findViewById(R.id.button2);
        textView2=(TextView)findViewById(R.id.textView2);
        btn2.setEnabled(false);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rad4.isChecked()) {
                    btn2.setEnabled(true);
                    Intent intent=new Intent(strategy1.this,CalorieCounter.class);
                    intent.putExtra("Goal","Increase");
                    intent.putExtra("Strategy","0.25");
                    startActivity(intent);
                }


                if (rad5.isChecked()) {
                    btn2.setEnabled(true);
                    Intent intent=new Intent(strategy1.this,CalorieCounter.class);
                    intent.putExtra("Goal","Increase");
                    intent.putExtra("Strategy","0.5");
                    startActivity(intent);
                }


                if (rad6.isChecked()) {
                    btn2.setEnabled(true);
                    Intent intent=new Intent(strategy1.this,CalorieCounter.class);
                    intent.putExtra("Goal","Increase");
                    intent.putExtra("Strategy","0.75");
                    startActivity(intent);
                }

            }


        });

    }
}
