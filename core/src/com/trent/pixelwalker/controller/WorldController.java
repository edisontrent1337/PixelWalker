package com.trent.pixelwalker.controller;

import com.trent.pixelwalker.controller.sensors.SensorAdapter;
import com.trent.pixelwalker.game.PixelWalker;
import com.trent.pixelwalker.models.Pixel;
import com.trent.pixelwalker.utils.SensorType;
import com.trent.pixelwalker.utils.Utils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Sinthu on 4/28/2017.
 */

public class WorldController {

    // ---------------------------------------------------------------------------------------------
    // MEMBERS & FIELDS
    // ---------------------------------------------------------------------------------------------
    private SensorAdapter sensorAdapter;
    private PixelWalker game;
    private HashSet<Pixel> pixels = new HashSet<Pixel>();
    private int steps = 0;
    public static final String TAG = "WorldController";

    private HashMap<SensorType, float[]> sensorData = new HashMap<SensorType, float[]>();

    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public WorldController(PixelWalker game) {
        this.game = game;
        this.sensorAdapter = game.getSensorAdapter();

        /**
         * Init sensor data hash map with empty arrays with the size of the sensor data array length.
         */
        for(SensorType sensorType : SensorType.values()) {
            sensorData.put(sensorType, new float[sensorType.args]);
        }

    }


    // ---------------------------------------------------------------------------------------------
    // METHODS & FUNCTIONS
    // ---------------------------------------------------------------------------------------------
    public void update() {
        if(sensorAdapter.getData() != null) {
            float currentSteps = sensorData.get(SensorType.STEP_COUNTER)[0];
            float newSteps = sensorAdapter.getSteps();
            if(newSteps < 0) {
                Utils.log(TAG, "Error. Sensor adapter data was negative: " + newSteps);
            }
            float deltaSteps = newSteps - currentSteps;

            if(deltaSteps > 0) {
                steps++;
            }

            sensorData.put(SensorType.STEP_COUNTER, new float[] {newSteps});

            Utils.log(TAG, "Counted steps are: " + steps);

        }
        else {
            Utils.log(TAG, "Data from sensor adapter was not present.");
        }
    }

    public HashSet<Pixel> getPixels() {
        return pixels;
    }
}
