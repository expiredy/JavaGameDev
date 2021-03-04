package com.ballsproject.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class State {
    public OrthographicCamera gamecum;
    protected Vector2 mouse;
    protected GameStateManager stateManager;

    protected State(GameStateManager gsm){
        this.stateManager = gsm;
        gamecum = new OrthographicCamera();
        mouse = new Vector2();
    }

    protected abstract void handleInput();

    protected abstract void update(float dt);

    protected abstract void render(SpriteBatch batch);
}
