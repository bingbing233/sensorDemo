package com.bing.sensordemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Parameter;

public class Main2Activity extends AppCompatActivity implements SensorEventListener {
    Sensor sensor;
    SensorManager sensorManager;
    TextView textName, textInfo, textData;
    int argNumber;
    int sensorType;
    int lisgtState = 0;
CameraManager cameraManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cameraManager =(CameraManager) getSystemService(CAMERA_SERVICE);
        Intent intent = getIntent();
        textName = findViewById(R.id.text_sensor_name);
        textData = findViewById(R.id.text_data);
        textInfo = findViewById(R.id.text_sensor_info);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorType= intent.getIntExtra("type", -1);
        argNumber = intent.getIntExtra("argNum", 0);
        String name = intent.getStringExtra("name");
        String info = intent.getStringExtra("info");
        sensor = sensorManager.getDefaultSensor(sensorType);

        textName.setText(name);
        textInfo.setText(info);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.start:
                sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
                break;
            case R.id.stop:
                sensorManager.unregisterListener(this);
                break;
        }
        return true;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String data = "";
        for (int i = 0; i < argNumber; i++) {
            data = data + "参数" + i + ": " + event.values[i] + " \n\n";
        }
        textData.setText(data);
        Log.d("data", data);
        if(sensor.getType()==sensorType){
                        if(event.values[0]>2000){
                            turnOnLight();
                        }
                        else {
                            turnOffLight();
                        }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void turnOnLight(){
            try {
                cameraManager.setTorchMode("0",true);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
    }
    public void turnOffLight(){
        try {
            cameraManager.setTorchMode("0",false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}
