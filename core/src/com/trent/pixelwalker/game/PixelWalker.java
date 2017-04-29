package com.trent.pixelwalker.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.trent.pixelwalker.controller.sensors.SensorAdapter;
import com.trent.pixelwalker.screens.GameScreen;
import com.trent.pixelwalker.utils.SensorType;
import com.trent.pixelwalker.utils.Utils;

import java.util.HashMap;
import java.util.Random;

public class PixelWalker extends Game {

    private SensorAdapter sensorAdapter;

    public PixelWalker(SensorAdapter sensorAdapter) {
        this.sensorAdapter = sensorAdapter;
    }


    public enum GameState {
        SPLASH,
        MENU,
        PAUSED,
        GAME;
    }

    private GameState gameState = GameState.PAUSED;

	SpriteBatch batch;


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

        setScreen(new GameScreen(this));
	}

	/*@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);

        if(sensorAdapter.getData().get(SensorType.STEP_COUNTER)!=null)
            Utils.log(TAG, sensorAdapter.getData().get(SensorType.STEP_COUNTER)[0]);

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
	}*/
	
	@Override
	public void dispose () {
		batch.dispose();
	}


    public void setGameState(GameState state) {
        this.gameState = state;
    }

    public SensorAdapter getSensorAdapter() {
        return sensorAdapter;
    }

}
