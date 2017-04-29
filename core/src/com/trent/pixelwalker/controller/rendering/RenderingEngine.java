package com.trent.pixelwalker.controller.rendering;

import com.trent.pixelwalker.game.PixelWalker;

/**
 * Created by Sinthu on 4/28/2017.
 */

public class RenderingEngine extends Renderer{

    // CANVAS DIMENSIONS
    static final float CAMERA_WIDTH = 32f;
    static final float CAMERA_HEIGHT = 18f;

    private PixelWalker game;

    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public RenderingEngine(PixelWalker game) {
        super(CAMERA_WIDTH, CAMERA_HEIGHT);
        this.game = game;

    }



    private void moveCamera(float x, float y) {

    }

    @Override
    public void render() {

    }

    @Override
    public void resize(int w, int h) {

    }
}
