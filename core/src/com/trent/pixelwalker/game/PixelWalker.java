package com.trent.pixelwalker.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.trent.pixelwalker.utils.SensorType;
import com.trent.pixelwalker.utils.Utils;

import java.util.HashMap;
import java.util.Random;

public class PixelWalker extends Game {
	SpriteBatch batch;
	Texture img;


    Random r = new Random();

    ShapeRenderer shapeRenderer;
    HashMap<Integer, Color> colors = new HashMap<Integer, Color>();

    int steps = 0;
    public static final String TAG = "PIXELWALKER_MAIN";

    public static final int WIDTH = 1920 / 128;
    public static final int HEIGHT = 1080 / 128;


    //TESTING
    private HashMap<SensorType, float[]> currentSensorValues = new HashMap<SensorType, float[]>();

	@Override
	public void create () {
		batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        for(SensorType type : SensorType.values()) {
            currentSensorValues.put(type, new float[type.args]);
        }

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);


        int rows = (int) Math.floor(steps / WIDTH);
        int x = 0;
        int y = 0;
            for (int i = 0; i < steps; i++) {
                if(x % WIDTH == 0 && x != 0) {
                    y++;
                    x = 0;
                }
                shapeRenderer.setColor(colors.get(i));
                shapeRenderer.rect(x * 128, y * 128, 120, 120);
                x++;
            }

        shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void updateSensorValues(SensorType type, float[] values) {

        if(type.equals(SensorType.STEP_COUNTER)) {
            float currentSteps = currentSensorValues.get(SensorType.STEP_COUNTER)[0];
            float newSteps = values[0];



            // Calculating delta between old and new values
            float deltaSteps = newSteps - currentSteps;

            if (deltaSteps > 0) {
                colors.put(steps,new Color(
                        r.nextFloat(),
                        r.nextFloat(),
                        r.nextFloat(),
                        1f
                ));
                steps++;

            }

            currentSensorValues.put(SensorType.STEP_COUNTER, new float[]{newSteps});

            Utils.log("DELTA STEPS:", deltaSteps);
            Utils.log("OLD HARDWARE STEPS: ", currentSteps);
            Utils.log("NEW HARDWARE STEPS: ", newSteps);
            Utils.log("STEPS COUNTED: ", steps);
            Utils.log("SAVED DATA IN MAP: ", currentSensorValues.get(SensorType.STEP_COUNTER)[0]);
        }
    }

}
