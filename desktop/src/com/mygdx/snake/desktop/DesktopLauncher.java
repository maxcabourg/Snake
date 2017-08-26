package com.mygdx.snake.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.snake.SnakeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SnakeGame.WIDTH;
		config.height = SnakeGame.HEIGHT;
		config.title = SnakeGame.TITLE;
		config.foregroundFPS = 2;
		new LwjglApplication(new SnakeGame(), config);
	}
}
