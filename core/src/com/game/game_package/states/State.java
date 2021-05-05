package com.game.game_package.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.game.game_package.GameStateManager;
import com.game.game_package.scene_components.PlayerCamera;

public abstract class State {
    public static OrthographicCamera playerCamera;
    protected Vector2 mouse;
    protected GameStateManager stateManager;

    protected State(GameStateManager gsm){
        this.stateManager = gsm;
        playerCamera = new OrthographicCamera();
        mouse = new Vector2();
    }

    protected abstract void handleInput();

    public abstract void update(float dt);

    public abstract void render(SpriteBatch batch);
}