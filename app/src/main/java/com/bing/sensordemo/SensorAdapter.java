package com.bing.sensordemo;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

public class SensorAdapter extends Adapter<SensorAdapter.ViewHolder> {
    List<BasicSensor> basicSensors;
    Context context;

    public SensorAdapter(List<BasicSensor> basicSensors, Context context) {
        this.basicSensors = basicSensors;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sensor_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String name = basicSensors.get(position).getName();
        final String info = basicSensors.get(position).getInfo();
        final int argNum = basicSensors.get(position).getArgNum();
        final int type = basicSensors.get(position).getType();

        if (argNum == -1) {
            holder.sensorInfo.setVisibility(View.INVISIBLE);
        }
        holder.sensorInfo.setText(info);
        holder.sensorName.setText(name);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("type", type);
                intent.putExtra("name", name);
                intent.putExtra("info", info);
                intent.putExtra("argNum",argNum);
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return basicSensors.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView sensorName, sensorInfo;
        Switch mySwitch;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sensorName = itemView.findViewById(R.id.sensor_name);
            sensorInfo = itemView.findViewById(R.id.sensor_info);
            view = itemView;

        }
    }
}
