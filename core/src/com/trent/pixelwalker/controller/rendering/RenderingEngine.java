package com.trent.pixelwalker.controller.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
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
    private static final String TAG = RenderingEngine.class.getSimpleName();

    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public RenderingEngine(PixelWalker game, WorldController worldController) {
        super(CAMERA_WIDTH, CAMERA_HEIGHT);
        this.game = game;
        this.worldController = worldController;
        this.hudRenderer = new HUDRenderer(worldController);

        this.fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/munro_regular.ttf"));

        camera.zoom = START_ZOOM;
        camera.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
        camera.update();
        Utils.log(TAG, "CAMERA VIEWPORT WxH: " + camera.viewportWidth + " x " + camera.viewportHeight);

        loadTexturesAndFonts();
        // TODO: If more renderers are needed, save them in a hash set and call loadTexturesAndFonts
        // TODO: on all of them in a loop.
        hudRenderer.loadTexturesAndFonts();
    }

    // ---------------------------------------------------------------------------------------------
    // METHODS & FIELDS
    // ---------------------------------------------------------------------------------------------


    /**
     * Renders the scene and calls the render() method of all sub-renderer-objects, such as
     * @link{HUDRenderer}
     */
    @Override
    public void render() {

        Gdx.gl.glClearColor(1f,1f,1f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.setColor(Color.RED);

        float zoom = Expo.easeOut(worldController.getWorldTime(),START_ZOOM,-19,3f);


        Utils.log(TAG, zoom);
        shapeRenderer.begin();
        {
            shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.rect(5,5,2,2);
            shapeRenderer.rect(7.2f,5,2,2);
            shapeRenderer.rect(9.4f,5,2,2);
            shapeRenderer.rect(11.6f,5,2,2);
            shapeRenderer.end();
        }


        camera.zoom = (zoom < 1) ? 1 : zoom;
        camera.update();


        hudRenderer.render();
    }

    @Override
    public void loadTexturesAndFonts() {

    }

    @Override
    public void resize(int w, int h) {

    }

    protected void moveCamera(float x, float y) {

    }
}
