package com.trent.pixelwalker.controller.sensors;

import com.trent.pixelwalker.utils.SensorType;

import java.util.HashMap;

/**
 * Created by Sinthu on 4/29/2017.
 */

public interface SensorAdapter {

    void onSensorChanged();
    HashMap<SensorType, float[]> getData();
}
