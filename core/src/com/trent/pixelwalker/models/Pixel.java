package com.trent.pixelwalker.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Sinthu on 4/29/2017.
 */

public class Pixel extends Actor {

    // ---------------------------------------------------------------------------------------------
    // MEMBERS & FIELDS
    // ---------------------------------------------------------------------------------------------
    public static final float DEFAULT_POWER = 1.0f;
    public static final float WIDTH = 1.0f;
    public static final float HEIGHT = 1.0f;

    private Vector2 position;
    private Color color;
    private float time = 0f;

    private float power;

    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public Pixel(Vector2 position, Color color) {
        this.position = position;
        this.color = color;
    }


    // ---------------------------------------------------------------------------------------------
    // METHODS & FUNCTIONS
    // ---------------------------------------------------------------------------------------------
    public void update(float delta) {
        time += delta;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }
}
