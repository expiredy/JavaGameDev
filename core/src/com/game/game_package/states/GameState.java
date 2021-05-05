package com.game.game_package.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.game.game_package.BallsGameClass;
import com.game.game_package.GameStateManager;
import com.game.game_package.scene_components.Player;
import com.game.game_package.scene_components.PlayerCamera;

public class GameState extends State{
    private Player player;

    private float startTime;
    private boolean isCollectingForce = false;

    public GameState(GameStateManager gameStateManager) {
        super(gameStateManager);
        initObjects();
        playerCamera.setToOrtho(false, BallsGameClass.WIDTH, BallsGameClass.HEIGHT);
    }

    @Override
    protected void handleInput() {
//        if(Gdx.input.justTouched()){
//            isCollectingForce = true;
//            startTime = System.currentTimeMillis();
//        }
//        else if(!Gdx.input.justTouched() && isCollectingForce){
//            isCollectingForce = false;
//            System.out.println((System.currentTimeMillis() - startTime)) ;
//        }
        if(Gdx.input.justTouched() && !isCollectingForce){
            isCollectingForce = true;
            this.startTime = TimeUtils.millis();
        }
        else if(!Gdx.input.isTouched() & isCollectingForce){
            isCollectingForce = false;
            player.AddForce(Gdx.input.getX(), Gdx.input.getY(), 10);
//            if (player.isJumpable()){
//                player.jump(Gdx.input.getX(), Gdx.input.getY(),(float) (TimeUtils.millis() - powerCounter) / 1000);
//            }
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();

        player.update(deltaTime);

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(playerCamera.combined);
        batch.begin();
        player.drawPlayer(batch);
        batch.end();

    }

    private void initObjects(){
        this.player = new Player(playerCamera, 300, 700);
    }
}
