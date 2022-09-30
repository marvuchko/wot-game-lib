package org.wizardoftomorrow.game.parent.core;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static org.wizardoftomorrow.game.parent.utils.Constants.IDLE_FPS;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PcConfiguration extends Lwjgl3ApplicationConfiguration {

    int width;
    int height;
    boolean fullScreenMode;
    String title;

    @Builder
    public PcConfiguration(int width, int height, boolean fullScreenMode, String title) {
        this.width = width;
        this.height = height;
        this.fullScreenMode = fullScreenMode;
        this.title = title;
        init();
    }

    private void init() {
        setIdleFPS(IDLE_FPS);
        useVsync(true);
        setTitle(title);

        if (isFullScreenMode()) {
            setFullscreenMode(getDisplayMode());
        } else {
            setWindowedMode(width, height);
        }
    }
}
