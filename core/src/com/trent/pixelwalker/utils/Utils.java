package com.trent.pixelwalker.utils;

import com.badlogic.gdx.Gdx;

/**
 * Created by Sinthu on 4/28/2017.
 */

public class Utils {

    public static void log(String tag, String message) {
        Gdx.app.log(tag, message);

    }

    public static void log(String tag, float value) {
        Gdx.app.log(tag, Float.toString(value));

    }

    public static void lof(String tag, int value) {
        Gdx.app.log(tag, Integer.toString(value));
    }

    public static void log(String tag, double value) {
        Gdx.app.log(tag, Double.toString(value));
    }

    public static void log(String message) {
        Gdx.app.log("DEBUG",message);
    }

}
