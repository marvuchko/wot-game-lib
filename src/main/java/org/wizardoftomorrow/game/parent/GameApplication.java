package org.wizardoftomorrow.game.parent;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.wizardoftomorrow.game.parent.core.GameConfiguration;
import org.wizardoftomorrow.game.parent.core.PcConfiguration;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameApplication extends Lwjgl3Application {

    static GameApplication currentInstance;

    private GameApplication(ApplicationListener listener, Lwjgl3ApplicationConfiguration config) {
        super(listener, config);
    }

    public static GameApplication create(GameConfiguration gameConfiguration, PcConfiguration pcConfiguration) {
        currentInstance = new GameApplication(gameConfiguration, pcConfiguration);
        return currentInstance;
    }

}
