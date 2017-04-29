package com.trent.pixelwalker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.trent.pixelwalker.controller.sensors.SensorAdapter;
import com.trent.pixelwalker.desktop.sensoradapter.DesktopSensorAdapter;
import com.trent.pixelwalker.game.PixelWalker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
        SensorAdapter sensorAdapter = new DesktopSensorAdapter();
		new LwjglApplication(new PixelWalker(sensorAdapter), config);
	}
}
