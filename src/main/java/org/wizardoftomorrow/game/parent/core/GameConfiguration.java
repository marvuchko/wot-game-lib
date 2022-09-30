package org.wizardoftomorrow.game.parent.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

import static java.util.Objects.isNull;

public class GameConfiguration extends Game {

    private static GameConfiguration instance;

    @Override
    public void create() {
        var width = Gdx.graphics.getWidth();
        var height = Gdx.graphics.getHeight();

        var camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        var renderer = new GameRenderer(camera);
        var screen = new GameScreen(renderer);
        setScreen(screen);
    }

    public static GameConfiguration getInstance() {
        if (isNull(instance)) {
            instance = new GameConfiguration();
        }
        return instance;
    }
}
