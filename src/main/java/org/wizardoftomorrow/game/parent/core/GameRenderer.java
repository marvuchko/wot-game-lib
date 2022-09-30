package org.wizardoftomorrow.game.parent.core;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GameRenderer {

    SpriteBatch spriteBatch = new SpriteBatch();
    World world = new World(new Vector2(0, 0), false);
    Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();

    OrthographicCamera camera;

    public GameRenderer(OrthographicCamera camera) {
        this.camera = camera;
    }
}
