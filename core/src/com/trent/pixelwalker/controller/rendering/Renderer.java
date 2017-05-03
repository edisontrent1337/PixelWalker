package com.trent.pixelwalker.controller.rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.EnumMap;

/**
 * Created by Sinthu on 18.08.2016.
 */
public abstract class Renderer {

    protected SpriteBatch spriteBatch;
    protected OrthographicCamera camera;
    protected ShapeRenderer shapeRenderer;
    protected FreeTypeFontGenerator fontGenerator;

    protected enum FontType {
        MUNRO_SMALL,
        MUNRO_REGULAR,
        ARIAL,
        ROBOTO;
    }

    protected EnumMap<FontType, BitmapFont> fonts;

    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public Renderer(float viewPortWidth, float viewPortHeight) {
        this.camera = new OrthographicCamera(viewPortWidth, viewPortHeight);
        this.spriteBatch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
        this.fonts = new EnumMap<FontType, BitmapFont>(FontType.class);
    }

    public abstract void loadTexturesAndFonts();
    public abstract void render();
    public abstract void resize(int w, int h);


}
