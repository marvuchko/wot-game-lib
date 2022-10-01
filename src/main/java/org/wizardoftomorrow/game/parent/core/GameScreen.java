package org.wizardoftomorrow.game.parent.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.lwjgl.opengl.GL11;

import static org.wizardoftomorrow.game.parent.utils.Constants.PIXELS_PER_METER;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GameScreen extends ScreenAdapter {

    GameRenderer renderer;

    @Override
    public void render(float delta) {
        update(delta);
        clear();
        renderSprites();
        renderDebugger();
    }

    private static void clear() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    private void renderDebugger() {
        var debugger = renderer.getDebugRenderer();
        debugger.render(renderer.getWorld(), renderer.getCamera().combined.scl(PIXELS_PER_METER));
    }

    private void renderSprites() {
        var batch = renderer.getSpriteBatch();
        batch.begin();
        //TODO Render sprites
        batch.end();
    }

    private void update(float delta) {
        var world = renderer.getWorld();
        var batch = renderer.getSpriteBatch();
        var camera = renderer.getCamera();

        world.step(1 / 60f, 6, 2);
        batch.setProjectionMatrix(camera.combined);
    }
}
