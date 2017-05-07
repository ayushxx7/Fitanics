package com.oms_infotech.www.fitnessapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.vision.barcode.Barcode;

public class MainActivityscan extends AppCompatActivity {

    Button btnscan;
    TextView tv;

    public static final int REQUEST_CODE=100;
    public static final int PERMISSION_REQUEST=200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnscan=(Button)findViewById(R.id.btnscan);
        tv=(TextView)findViewById(R.id.tv);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},PERMISSION_REQUEST);
        }

        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivityscan.this,CameraActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode==REQUEST_CODE&&resultCode==RESULT_OK){
               if(data==null){
                   tv.setText("No barcode found");
               }else{
                   final Barcode barcode=data.getParcelableExtra("barcode");
                   tv.post(new Runnable() {
                       @Override
                       public void run() {
                           tv.setText(barcode.displayValue);

                       }
                   });
               }
       }else {
           super.onActivityResult(requestCode, resultCode, data);
       }
    }
}
