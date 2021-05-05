package com.game.game_package.scene_components.oclusion;

import com.badlogic.gdx.math.Vector2;

public interface DefaultObject {

    public Vector2 positon = null;

    public abstract void checkForCollision();

    public abstract void update();

    public abstract void spawn();
}
