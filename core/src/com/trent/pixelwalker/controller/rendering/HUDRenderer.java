package com.trent.pixelwalker.controller.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.trent.pixelwalker.controller.WorldController;
import static com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
/**
 * Created by Sinthu on 4/29/2017.
 */

class HUDRenderer extends Renderer{

    static final float CAMERA_WIDTH = Gdx.graphics.getHeight();
    static final float CAMERA_HEIGHT = Gdx.graphics.getWidth();

    private WorldController worldController;

    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public HUDRenderer(WorldController worldController) {
        super(CAMERA_WIDTH,CAMERA_HEIGHT);
        this.worldController = worldController;

        camera.position.set(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2, 0f);
        camera.update();

        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/munro_regular.ttf"));
        loadTexturesAndFonts();
    }

    @Override
    public void render() {
        float steps = worldController.getSteps();
    }

    @Override
    public void resize(int w, int h) {

    }

    @Override
    public void loadTexturesAndFonts() {
        FreeTypeFontParameter parameters = new FreeTypeFontParameter();
        parameters.color = Color.BLACK;
        parameters.size = 32;
        parameters.minFilter = Texture.TextureFilter.Nearest;
        parameters.minFilter = Texture.TextureFilter.Nearest;

    }
}
