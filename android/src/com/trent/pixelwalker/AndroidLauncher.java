package com.trent.pixelwalker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.trent.pixelwalker.controller.sensors.SensorAdapter;
import com.trent.pixelwalker.game.PixelWalker;
import com.trent.pixelwalker.sensoradapter.AndroidSensorAdapter;
import com.trent.pixelwalker.utils.SensorType;

import java.util.HashMap;
import java.util.HashSet;

public class AndroidLauncher extends AndroidApplication implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor stepDetector;
    private Sensor stepCounter;
    private Sensor accelerometer;

    private HashSet<Sensor> sensors = new HashSet<>();

    private PixelWalker game;

    private static final String TAG = "ANDROID_LAUNCHER";


    private HashMap<SensorType, float[]> sensorValues = new HashMap<>();

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        SensorAdapter sensorAdapter = new AndroidSensorAdapter() {
            @Override
            public HashMap<SensorType, float[]> getData() {
                return sensorValues;
            }

            @Override
            public float getSteps() {
                if(sensorValues.get(SensorType.STEP_COUNTER) != null)
                    return sensorValues.get(SensorType.STEP_COUNTER)[0];
                else
                    return -1;
            }
        };

        this.game = new PixelWalker(sensorAdapter);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        stepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        stepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensors.add(stepCounter);
        sensors.add(stepDetector);
        sensors.add(accelerometer);

        for(Sensor s : sensors) {
            if(s != null) {
                sensorManager.registerListener(this, s, SensorManager.SENSOR_DELAY_GAME);
            }
            else
                Toast.makeText(this, Integer.toString(s.getType()) + " sensor was not found.", Toast.LENGTH_SHORT).show();

        }

        initialize(game, config);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int type = event.sensor.getType();

        if(event.values != null) {
            float[] values = event.values;
            switch (type) {
                case Sensor.TYPE_ACCELEROMETER:
                    sensorValues.put(SensorType.ACCELEROMETER, values);
                    break;
                case Sensor.TYPE_STEP_COUNTER:
                    sensorValues.put(SensorType.STEP_COUNTER, values);

                    break;
                case Sensor.TYPE_STEP_DETECTOR:
                    sensorValues.put(SensorType.STEP_DETECTOR, values);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
