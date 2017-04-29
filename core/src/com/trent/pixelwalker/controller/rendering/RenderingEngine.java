package com.trent.pixelwalker.controller.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.trent.pixelwalker.controller.WorldController;
import com.trent.pixelwalker.game.PixelWalker;
import com.trent.pixelwalker.utils.Utils;
import penner.easing.*;

/**
 * Created by Sinthu on 4/28/2017.
 */

public class RenderingEngine extends Renderer{

    // ---------------------------------------------------------------------------------------------
    // MEMBERS & FIELDS
    // ---------------------------------------------------------------------------------------------
    static final float CAMERA_WIDTH = 18f;
    static final float CAMERA_HEIGHT = 32f;

    private final float START_ZOOM = 20f;

    private PixelWalker game;
    private WorldController worldController;
    private HUDRenderer hudRenderer;
    private float worldTime = 0f;
    private static final String TAG = RenderingEngine.class.getSimpleName();
    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public RenderingEngine(PixelWalker game, WorldController worldController) {
        super(CAMERA_WIDTH, CAMERA_HEIGHT);
        this.game = game;
        this.worldController = worldController;
        this.hudRenderer = new HUDRenderer();

        camera.zoom = START_ZOOM;
        camera.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
        camera.update();

    }

    // ---------------------------------------------------------------------------------------------
    // METHODS & FIELDS
    // ---------------------------------------------------------------------------------------------


    @Override
    public void render(float delta) {

        worldTime += delta;
        Gdx.gl.glClearColor(1f,1f,1f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        rectRenderer.setProjectionMatrix(camera.combined);
        rectRenderer.setAutoShapeType(true);
        rectRenderer.setColor(Color.RED);

        float test = Expo.easeOut(worldTime,START_ZOOM,-19,3f);


        Utils.log(TAG, test);
        rectRenderer.begin();
        {
            rectRenderer.set(ShapeRenderer.ShapeType.Filled);
            rectRenderer.rect(5,5,2,2);
            rectRenderer.rect(7.2f,5,2,2);
            rectRenderer.rect(9.4f,5,2,2);
            rectRenderer.rect(11.6f,5,2,2);
            rectRenderer.end();
        }


        camera.zoom = (test < 1) ? 1 : test;
        camera.update();
    }

    @Override
    public void resize(int w, int h) {

    }

    protected void moveCamera(float x, float y) {

    }
}
