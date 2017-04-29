package com.trent.pixelwalker.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.trent.pixelwalker.controller.rendering.RenderingEngine;
import com.trent.pixelwalker.game.PixelWalker;

/**
 * Created by Sinthu on 4/29/2017.
 */

public class GameScreen implements Screen, InputProcessor {

    private PixelWalker game;
    private RenderingEngine renderingEngine;
    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public GameScreen (PixelWalker game) {
        this.game = game;
    }




    @Override
    public void show() {
        renderingEngine = new RenderingEngine(game);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }




    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }



}
