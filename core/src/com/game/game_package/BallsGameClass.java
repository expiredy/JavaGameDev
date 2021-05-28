package com.game.game_package;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.game_package.constants.LevelKeyConstants;
import com.game.game_package.states.GameState;

public class BallsGameClass extends Game {
	public static Integer WIDTH;
	public static Integer HEIGHT;
	SpriteBatch batch;
	private GameStateManager stateManager;


	private void startRender(){
		Gdx.gl.glClearColor(1, 1, 1, 1);
	}
	
	@Override
	public void create () {
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		System.out.print(HEIGHT + " " + WIDTH);
		this.batch = new SpriteBatch();
		this.stateManager = new GameStateManager();
		stateManager.addState(new GameState(stateManager, LevelKeyConstants.offlineKey, this));
		startRender();
	}

	@Override
	public void render () {
		stateManager.update(Gdx.graphics.getDeltaTime());
		stateManager.render(batch);
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public static Texture getPlayerSkin(){
		return new Texture( "player_skin\\RedBall.png");
	}
	public void restart() {
		stateManager.removeLastState();
		stateManager.addState(new GameState(stateManager, LevelKeyConstants.offlineKey, this));
	}

}
