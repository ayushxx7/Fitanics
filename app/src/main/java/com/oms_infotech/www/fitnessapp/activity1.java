package com.oms_infotech.www.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class activity1 extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rad1,rad2,rad3;
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        rad1=(RadioButton)findViewById(R.id.radioButton);
        rad2=(RadioButton)findViewById(R.id.radioButton2);
        rad3=(RadioButton)findViewById(R.id.radioButton3);
        btn=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        btn.setEnabled(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (rad1.isChecked()) {
                        btn.setEnabled(true);
                        Intent intent = new Intent(activity1.this, strategy1.class);
                        startActivity(intent);
                    }


                    if (rad2.isChecked()) {
                        btn.setEnabled(true);
                        Intent intent2 = new Intent(activity1.this, Strategy2.class);
                        startActivity(intent2);
                    }


                    if (rad3.isChecked()) {
                        btn.setEnabled(true);
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Not intent to activity",Toast.LENGTH_SHORT).show();
                }
            }


        });


    }

}
