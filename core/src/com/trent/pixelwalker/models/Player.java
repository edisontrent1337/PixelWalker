package com.trent.pixelwalker.models;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.HashMap;

/**
 * Created by Sinthu on 5/3/2017.
 */

public class Player {

    private int level = 1;
    private int pixels = 0;
    private int steps = 0;


    public Player() {

    }

    public int getLevel() {
        return level;
    }

    public int getPixels() {
        return pixels;
    }

    public int getSteps() {
        return steps;
    }

    public void takeStep() {
        steps += 1;
    }


}
