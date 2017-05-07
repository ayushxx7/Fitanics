package com.oms_infotech.www.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Foodtype extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    EditText edcal;
    ArrayList<String> callist;
    ArrayList<String> fooditems;
    String type,calorie;
    Button btn,scancode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodtype);

        btn=(Button)findViewById(R.id.btncon);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        edcal=(EditText)findViewById(R.id.editText);

        scancode=(Button)findViewById(R.id.buttonscanner);

        scancode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Foodtype.this,MainActivityscan.class);
                startActivity(intent);
            }
        });

        fooditems=new ArrayList<>();
        callist=new ArrayList<>();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,fooditems);

        fooditems.add("Coffee");
        fooditems.add("Moong-dal chila");
        fooditems.add("Cookies");
        fooditems.add("Paratha");
        fooditems.add("Potato with beans");
        fooditems.add("Moong dal");
        fooditems.add("Dal makhni");
        fooditems.add("Sahhi paneer");
        fooditems.add("Laccha paratha");
        fooditems.add("Apples");
        fooditems.add("Oats");
        fooditems.add("Bananas");
        fooditems.add("Mc-cain potatoes");


        callist.add("83");
        callist.add("256");
        callist.add("18");
        callist.add("111");
        callist.add("269");
        callist.add("197");
        callist.add("379");
        callist.add("370");
        callist.add("630");
        callist.add("80");
        callist.add("105");
        callist.add("150");
        callist.add("150");
        
        int index = 0;
        
        autoCompleteTextView.setAdapter(arrayAdapter);
        type=autoCompleteTextView.getText().toString();
      if(autoCompleteTextView!=null){
          
          for(int i=0;i<fooditems.size();i++){
              if(autoCompleteTextView.getText().toString().equals(fooditems.get(i))){
                  index=i;
              }
          }
          edcal.setText(callist.get(index));
      }
        calorie=edcal.getText().toString();
        
//        CalorieCounter caloriecc = new CalorieCounter();
//        caloriecc.MY_VARIABLE=100;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Foodtype.this,CalorieCounter.class);
                intent.putExtra("type",type);
                intent.putExtra("calorie",calorie);
                startActivity(intent);
                finish();
            }
        });

    }
}
