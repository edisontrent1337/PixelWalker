package com.trent.pixelwalker.controller.rendering.huddrawable;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Sinthu on 5/3/2017.
 */

public class StringDrawable extends HUDDrawable{

    private final GlyphLayout layout;
    private final BitmapFont font;
    private Vector2 position;
    private Vector2 margin;
    private String text;

    private float width = 0f ,height = 0f;

    public StringDrawable(BitmapFont font) {
        this.font = font;
        this.layout = new GlyphLayout();
        this.position = new Vector2(0.0f,0.0f);
        this.text = "Hello World.";
    }


    public void setText(String text) {
        this.text = text;
        layout.setText(font, this.text);
        width = layout.width;
        height = layout.height;
    }

    public void draw(SpriteBatch sb) {
        font.draw(sb,layout, position.x - width / 2, position.y - height / 2);
    }


    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }

    public void put(float marginX, float marginY) {
        this.margin.x = marginX;
        this.margin.y = marginY;
    }


}
