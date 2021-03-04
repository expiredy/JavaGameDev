package com.ballsproject.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ballsproject.game.states.GameState;
import com.ballsproject.game.states.GameStateManager;


public class BallsScript extends Game{
	public static Integer WIDTH;
	public static Integer HEIGHT;
	private GameStateManager stateManager;
	SpriteBatch batch;

	private void startRender(){
		Gdx.gl.glClearColor(1, 0, 0,1);
	}
	
	@Override
	public void create ()
	{
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		this.batch = new SpriteBatch();
		this.stateManager = new GameStateManager();
		stateManager.addState(new GameState(stateManager));
		startRender();
	}

	@Override
	public void render () {
		stateManager.update(Gdx.graphics.getDeltaTime());
		stateManager.render(batch);
		super.render();
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
	}
}