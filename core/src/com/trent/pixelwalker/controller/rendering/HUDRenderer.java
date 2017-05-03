package com.trent.pixelwalker.controller.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.trent.pixelwalker.controller.WorldController;
import com.trent.pixelwalker.controller.rendering.huddrawable.HUDDrawable;
import com.trent.pixelwalker.controller.rendering.huddrawable.StringDrawable;
import com.trent.pixelwalker.models.Player;

import java.util.EnumMap;

import static com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
/**
 * Created by Sinthu on 4/29/2017.
 */

class HUDRenderer extends Renderer{

    static final float CAMERA_WIDTH = Gdx.graphics.getWidth();
    static final float CAMERA_HEIGHT = Gdx.graphics.getHeight();

    private WorldController worldController;
    private Player player;

    enum HUDElement {
        STEPS,
        XP,
        BITS,
        LEVEL;
    }

    private EnumMap<HUDElement, HUDDrawable> hudDrawables;

    // ---------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------------------------------------------------
    public HUDRenderer(WorldController worldController) {
        super(CAMERA_WIDTH,CAMERA_HEIGHT);
        this.worldController = worldController;
        this.player = worldController.getPlayer();
        camera.position.set(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2, 0f);
        camera.update();
        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/munro_regular.ttf"));
        loadTexturesAndFonts();
    }

    @Override
    public void render() {
        StringDrawable steps = (StringDrawable) hudDrawables.get(HUDElement.STEPS);
        steps.setText(Float.toString(player.getSteps()));
        StringDrawable level = (StringDrawable) hudDrawables.get(HUDElement.LEVEL);
        level.setText("LEVEL: "+ Integer.toString(player.getLevel()+25));
        spriteBatch.begin();
        {
            steps.draw(spriteBatch);
            level.draw(spriteBatch);
        }
        spriteBatch.end();

    }



    @Override
    public void resize(int w, int h) {

    }

    @Override
    public void loadTexturesAndFonts() {

        // MUNRO 32 SETUP
        FreeTypeFontParameter parameters = new FreeTypeFontParameter();
        parameters.color = Color.BLACK;
        parameters.size = 32;
        parameters.minFilter = Texture.TextureFilter.Nearest;
        parameters.minFilter = Texture.TextureFilter.Nearest;
        BitmapFont munroSmall = fontGenerator.generateFont(parameters);
        fonts.put(FontType.MUNRO_SMALL, munroSmall);

        // MUNRO 48 SETUP
        parameters.size = 48;
        parameters.color = Color.BLACK;
        parameters.shadowColor = Color.GRAY;
        parameters.shadowOffsetX = 2;
        parameters.shadowOffsetY = 2;
        BitmapFont munroRegular = fontGenerator.generateFont(parameters);
        fonts.put(FontType.MUNRO_REGULAR, munroRegular);

        // HUD SETUP
        hudDrawables = new EnumMap<HUDElement, HUDDrawable>(HUDElement.class);

        StringDrawable steps = new StringDrawable(munroSmall);
        steps.setPosition(50, CAMERA_HEIGHT - 25);
        hudDrawables.put(HUDElement.STEPS,steps);

        StringDrawable level = new StringDrawable(munroRegular);
        level.setPosition(50, CAMERA_HEIGHT - 50);
        hudDrawables.put(HUDElement.LEVEL, level);
    }

    public HUDDrawable getHUDDrawable(HUDElement element) {
        return hudDrawables.get(element);
    }
}
