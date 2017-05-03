package com.trent.pixelwalker.game;

import com.badlogic.gdx.Game;
import com.trent.pixelwalker.controller.sensors.SensorAdapter;
import com.trent.pixelwalker.screens.GameScreen;

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
    public static final String TAG = "PIXELWALKER_MAIN";


	@Override
	public void create () {
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

	}


    public void setGameState(GameState state) {
        this.gameState = state;
    }

    public SensorAdapter getSensorAdapter() {
        return sensorAdapter;
    }

}
