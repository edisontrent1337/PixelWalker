package com.trent.pixelwalker.controller.rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Sinthu on 18.08.2016.
 */
public abstract class Renderer {



    protected SpriteBatch spriteBatch;
    protected OrthographicCamera camera;
    protected ShapeRenderer rectRenderer;


    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public Renderer(float viewPortWidth, float viewPortHeight) {
        this.camera = new OrthographicCamera(viewPortWidth, viewPortHeight);
        this.spriteBatch = new SpriteBatch();
        this.rectRenderer = new ShapeRenderer();

    }

    public abstract void render(float delta);

    public abstract void resize(int w, int h);

}
