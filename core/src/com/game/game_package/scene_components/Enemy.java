package com.game.game_package.scene_components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.game.game_package.BallsGameClass;

public class Enemy {

    private static final float GRAVITY = -0.02f;
    private static final float SPEED = 5f;
    private static final float SLIDESPEED = 0.5f;
    private static final float BounceMultiplayer = 0.3f;
    private static final Integer DefaultMovingConstant = 0;
    //Some movement values
    public Vector2 position;

    public Vector2 velocity;
    public Vector2 centerPosition;

    public boolean isDead = false;

    private boolean isGrounded;

    // everything about drawing stuff
    private final Integer xSize = 100;
    private final Integer ySize = 100;
    private Player target;
    public Texture enemySprite;

    public Enemy(int xPosition, Player target) {
        int randomNum = (int)(Math.random() * ySize * 10);
        position = new Vector2(xPosition, BallsGameClass.HEIGHT + randomNum);
        velocity =  new Vector2(DefaultMovingConstant, DefaultMovingConstant);
        this.target = target;
        enemySprite = new Texture("level_particles\\walls\\SomeWallPart.png");
    }

    public void update(float deltaTime){
        //updateCameraPosition(deltaTime);
        centerPosition = new Vector2(position.x + (float)xSize / 2,
                position.y + (float)ySize / 2);
        freeFall();
        updateCurrentPosition(deltaTime);
    }


    private void updateCurrentPosition(float deltaTime){
        velocity.scl(deltaTime);


        position.add(velocity.x, velocity.y);

        velocity.scl(1/deltaTime);

        position.add(velocity.x, velocity.y);
        if(position.y + ySize <= 0){
            isDead = true;
            if (velocity.x - SLIDESPEED * 2 <= 0 | velocity.x + SLIDESPEED * 2 >= 0){
                velocity.x += -velocity.x * SLIDESPEED;}
            else{
                velocity.x = DefaultMovingConstant;
            }
        }
    }

    public boolean checkCollisionsWithTarget() {

        return (((position.x < target.position.x) && (position.x + xSize > target.position.x)) &&
                ((position.y < target.position.y) && (position.y + ySize > target.position.y)));
    }

    private void die() {

    }

    private void freeFall(){
        if (this.isInAir()){
            velocity.add(DefaultMovingConstant, GRAVITY);
        }

    }
    public boolean isInAir(){
        return true;
    }

    public void drawEnemy(Batch batch){
        batch.draw(this.enemySprite, position.x, position.y, xSize, ySize);
    }
}
