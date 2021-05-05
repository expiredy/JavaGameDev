package com.game.game_package;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.game_package.states.State;

import java.util.Stack;

public class GameStateManager {
    private final Stack<State> states;

    public GameStateManager(){
        this.states = new Stack<State>();
    }

    public void addState(State state){
        this.states.push(state);
    }

    public void removeLastState(){
        this.states.pop();
    }
    public void setStates(State state){
        this.removeLastState();
        this.addState(state);
    }
    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch batch){
        states.peek().render(batch);
    }
}