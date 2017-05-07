package com.oms_infotech.www.fitnessapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProximityCounter extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager2;
    Sensor sensor2;
    TextView t1,t2;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        sensorManager2=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor2=sensorManager2.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager2.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager2.registerListener(this,sensor2, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_PROXIMITY){

            count=count+1;
            t2.setText(String.valueOf(count/2));
        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //no code required

    }
}
