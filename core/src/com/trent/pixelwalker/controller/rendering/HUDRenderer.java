package com.trent.pixelwalker.controller.rendering;

import com.badlogic.gdx.Gdx;

/**
 * Created by Sinthu on 4/29/2017.
 */

public class HUDRenderer extends Renderer{

    static final float CAMERA_WIDTH = Gdx.graphics.getWidth();
    static final float CAMERA_HEIGHT = Gdx.graphics.getHeight();

    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public HUDRenderer() {
        super(CAMERA_WIDTH,CAMERA_HEIGHT);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int w, int h) {

    }
}
