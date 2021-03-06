package com.ballsproject.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ballsproject.game.BallsScript;
import com.ballsproject.game.objects.GrapplePoint;
import com.ballsproject.game.players.Player;

public class GameState extends State{

//    private final LevelGeneration level;
    private final GrapplePoint point;
    private final Player player;

    public GameState(GameStateManager gsm) {
        super(gsm);
//        level = new LevelGeneration();
        point = new GrapplePoint(400, 500);
        player = new Player((float) BallsScript.WIDTH / 2,400);
        gamecum.setToOrtho(false, BallsScript.WIDTH, BallsScript.HEIGHT);
    }
    @Override
    protected void handleInput() {
        if(Gdx.input.isTouched()){
            player.jump(Gdx.input.getX(), Gdx.input.getY(), 1);
        }
    }

    @Override
    public void update(float dTime) {
        gamecum.position.x = player.getPosition().x + 80;
        this.player.update(dTime);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(gamecum.combined);
        batch.begin();
//        level.update(batch);
        point.update(batch);
        batch.draw(this.player.ballTex, player.getPosition().x, player.getPosition().y,
                this.player.xSize, this.player.ySize);
        batch.end();
        handleInput();
    }
}