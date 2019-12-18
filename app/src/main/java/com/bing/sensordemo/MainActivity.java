package com.bing.sensordemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager manager;
    //传感器列表
    List<BasicSensor> basicSensors;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basicSensors = new ArrayList<>();
        recyclerView = findViewById(R.id.list);
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        initData();
        SensorAdapter adapter = new SensorAdapter(basicSensors, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    /**
     * 初始化数据
     */
    public void initData() {
        basicSensors.add(new BasicSensor(-1,-1,"运动传感器概述",""));
        basicSensors.add(new BasicSensor(Sensor.TYPE_ACCELEROMETER, 3, "加速度计", "有偏差校准，返回沿x、y、z轴的加速度"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_LINEAR_ACCELERATION, 3, "加速度计", "返回不包含重力沿x、y、z轴的加速度"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_ACCELEROMETER_UNCALIBRATED, 3, "加速度计", "无任何偏差补偿,返回沿x、y、z轴的加速度"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_GRAVITY, 3, "重力传感器", "返回沿x、y、z轴的重力"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_GYROSCOPE, 3, "陀螺仪", "有偏差校准，返回绕x、y、z轴旋转的速率"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED, 3, "陀螺仪", "无任何偏差不超，返回绕x、y、z轴旋转的速率"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_ROTATION_VECTOR, 4, "旋转矢量", "返回沿x、y、z轴的旋转矢量分量以及旋转矢量的标量分量"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_STEP_COUNTER, 1, "计步器", "返回自激活传感器以来的最后一次重新启动以来的步数"));

        basicSensors.add(new BasicSensor(-1,-1,"位置传感器概述",""));
        basicSensors.add(new BasicSensor(Sensor.TYPE_GAME_ROTATION_VECTOR,3,"游戏旋转矢量","返回沿x、y、z轴的旋转矢量分量以及旋转矢量的标量分量"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,3,"地理旋转矢量","返回沿x、y、z轴的旋转矢量分量以及旋转矢量的标量分量"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_MAGNETIC_FIELD,3,"磁场强度","返回沿x、y、z轴的地磁场强度"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED,3,"磁场强度","无校准，返回沿x、y、z轴的地磁场强度"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_ORIENTATION,3,"方向传感器","返回方位角（z），螺距（x），滚动（x）"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_PROXIMITY,1,"距离传感器","返回与物体的距离，某些传感器返回二进制的值"));

        basicSensors.add(new BasicSensor(-1,-1,"环境传感器概述",""));
        basicSensors.add(new BasicSensor(Sensor.TYPE_AMBIENT_TEMPERATURE,1,"环境温度","返回周围环境温度"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_LIGHT,1,"光传感器","返回光照强度"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_PRESSURE,1,"压力传感器","返回环境空气压力"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_RELATIVE_HUMIDITY,1,"湿度传感器","返回环境相对湿度"));
        basicSensors.add(new BasicSensor(Sensor.TYPE_TEMPERATURE,1,"温度传感器","返回设备温度"));
    }
}
