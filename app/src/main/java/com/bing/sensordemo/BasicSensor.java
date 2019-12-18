package com.bing.sensordemo;

public class BasicSensor {
    int type;
    int argNum;
    String name;
    String info;

    public BasicSensor(int type, int argNum, String name, String info) {
        this.type = type;
        this.argNum = argNum;
        this.name = name;
        this.info = info;
    }

    public int getType() {
        return type;
    }

    public int getArgNum() {
        return argNum;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }


}
