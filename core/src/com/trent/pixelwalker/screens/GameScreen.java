package com.trent.pixelwalker.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.trent.pixelwalker.controller.WorldController;
import com.trent.pixelwalker.controller.rendering.RenderingEngine;
import com.trent.pixelwalker.game.PixelWalker;
import com.trent.pixelwalker.utils.Utils;

/**
 * Created by Sinthu on 4/29/2017.
 */

public class GameScreen implements Screen, GestureDetector.GestureListener {

    private PixelWalker game;
    private RenderingEngine renderingEngine;
    private WorldController worldController;
    public static final String TAG = GameScreen.class.getName();
    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public GameScreen (PixelWalker game) {
        this.game = game;
        this.worldController = new WorldController(game);
        this.renderingEngine = new RenderingEngine(game, worldController);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(new GestureDetector(this));
    }

    @Override
    public void render(float delta) {
        worldController.update(delta);
        renderingEngine.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        game.setGameState(PixelWalker.GameState.PAUSED);
    }

    @Override
    public void resume() {
        game.setGameState(PixelWalker.GameState.GAME);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        Utils.log(TAG, "Tap at: " + "(" + x +", " + y +")");
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        Utils.log(TAG, "That was a pinch, bro.");
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
