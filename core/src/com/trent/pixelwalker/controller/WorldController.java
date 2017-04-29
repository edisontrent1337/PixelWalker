package com.trent.pixelwalker.controller;

import com.trent.pixelwalker.controller.sensors.SensorAdapter;
import com.trent.pixelwalker.game.PixelWalker;
import com.trent.pixelwalker.models.Pixel;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Sinthu on 4/28/2017.
 */

public class WorldController {

    // ---------------------------------------------------------------------------------------------
    // MEMBERS & FIELDS
    // ---------------------------------------------------------------------------------------------
    private SensorAdapter sensorAdapter;
    private PixelWalker game;
    private HashSet<Pixel> pixels = new HashSet<Pixel>();
    private int steps = 0;

    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public WorldController(PixelWalker game) {
        this.game = game;
        this.sensorAdapter = game.getSensorAdapter();
    }


    // ---------------------------------------------------------------------------------------------
    // METHODS & FUNCTIONS
    // ---------------------------------------------------------------------------------------------
    public void update() {

    }

    public HashSet<Pixel> getPixels() {
        return pixels;
    }
}
