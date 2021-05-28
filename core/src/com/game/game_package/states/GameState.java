package com.game.game_package.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.game_package.BallsGameClass;
import com.game.game_package.GameStateManager;
import com.game.game_package.scene_components.Enemy;
import com.game.game_package.scene_components.Player;
import com.game.game_package.scene_components.TheWorldClass;
import com.game.game_package.tools.HeadUpDisplay;

import java.util.Random;

public class GameState extends State{
    private Player player;
    private Player currentPlayer;
    private Enemy[] enemies;

    Integer MaxEnemies = 8;
    Integer totalEnemies = 0;

    private HeadUpDisplay playerHUD;

    private TheWorldClass GameField;
    private float startTime;
    private boolean isCollectingForce = false;

    private BallsGameClass gameSession;


    public GameState(GameStateManager gameStateManager, String gameMode, BallsGameClass ballsGameClass) {
        super(gameStateManager);
        GameField = new TheWorldClass();

        initObjects();
        this.gameSession = new BallsGameClass();
        playerCamera.setToOrtho(false, BallsGameClass.WIDTH, BallsGameClass.HEIGHT);

    }

    @Override
    protected void handleInput() {


         if(Gdx.input.isTouched()){
//             playerHUD.checkButtonsForPressing(Gdx.input.getX(), Gdx.input.getY());
//             player.AddForce(Gdx.input.getX(), Gdx.input.getY(), 3);
             player.AddForce(Gdx.input.getX(), Gdx.input.getY(), 1);
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        player.update(deltaTime);
        enemies_spawner();
        for (Integer i = 0; i < MaxEnemies; i++){
            if (enemies[i] != null){
                enemies[i].update(deltaTime);

                if (enemies[i].checkCollisionsWithTarget()){
                    gameSession.restart();}
                if (enemies[i].isDead){
                    int randomNum = (int)(Math.random() * BallsGameClass.WIDTH);
                    enemies[i] = new Enemy(randomNum, player);
            }

            }
        }
    }

    private void enemies_spawner() {
        if(totalEnemies < MaxEnemies){
            int randomNum = (int)(Math.random() * BallsGameClass.WIDTH);
            enemies[totalEnemies] = new Enemy(randomNum, player);
            totalEnemies += 1;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(playerCamera.combined);
        batch.begin();
        GameField.renderBackground(batch);
        player.drawPlayer(batch);
        for (Enemy enemy: enemies){
            if (enemy != null){
                enemy.drawEnemy(batch);}
        }
        //playerHUD.render(batch);
        batch.end();

    }

    private void initObjects(){
        this.player = new Player(playerCamera, 300, 700);
        enemies = new Enemy[MaxEnemies];
        enemies_spawner();
    }
}
