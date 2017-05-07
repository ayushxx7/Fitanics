package com.oms_infotech.www.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Strategy2 extends AppCompatActivity {
    RadioGroup radioGroup3;
    RadioButton rad7,rad8,rad9;
    Button btn3;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy2);
        radioGroup3=(RadioGroup) findViewById(R.id.radiogroup3);
        rad7=(RadioButton)findViewById(R.id.radioButton7);
        rad8=(RadioButton)findViewById(R.id.radioButton8);
        rad9=(RadioButton)findViewById(R.id.radioButton9);
        btn3=(Button)findViewById(R.id.button3);
        textView3=(TextView)findViewById(R.id.textView3);
        btn3.setEnabled(false);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rad7.isChecked()) {
                    btn3.setEnabled(true);
                    Intent intent=new Intent(Strategy2.this,CalorieCounter.class);
                    intent.putExtra("Goal","Decrease");
                    intent.putExtra("Strategy","0.25");
                    startActivity(intent);

                }


                if (rad8.isChecked()) {
                    btn3.setEnabled(true);
                    Intent intent=new Intent(Strategy2.this,CalorieCounter.class);
                    intent.putExtra("Goal","Decrease");
                    intent.putExtra("Strategy","0.5");
                }


                if (rad9.isChecked()) {
                    btn3.setEnabled(true);
                    Intent intent=new Intent(Strategy2.this,CalorieCounter.class);
                    intent.putExtra("Goal","Decrease");
                    intent.putExtra("Strategy","0.75");
                }
            }
        });
    }
}
