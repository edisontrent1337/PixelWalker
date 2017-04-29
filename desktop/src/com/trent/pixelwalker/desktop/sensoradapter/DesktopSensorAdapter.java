package com.trent.pixelwalker.desktop.sensoradapter;

import com.trent.pixelwalker.controller.sensors.SensorAdapter;
import com.trent.pixelwalker.utils.SensorType;

import java.util.HashMap;

/**
 * Created by Sinthu on 4/29/2017.
 */

public class DesktopSensorAdapter implements SensorAdapter {
    @Override
    public void onSensorChanged() {

    }

    @Override
    public HashMap<SensorType, float[]> getData() {
        return null;
    }

    @Override
    public float getSteps() {
        return 0;
    }
}
