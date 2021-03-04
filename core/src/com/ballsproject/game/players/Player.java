package com.ballsproject.game.players;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ballsproject.game.BallsScript;

public class Player {
    private final Vector2 position;
    private final Vector2 velocity;

    public float xSize = 100;
    public float ySize = 100;

    private final Rectangle bounds;
    public Texture ballTex;

    private static final float SLIDE = 0.05f;
    private static final int GRAVITY = -16;

    public Player(float xCord, float yCord){
        velocity =  new Vector2(0, 0);
        position = new Vector2(xCord, yCord);
        ballTex = new Texture("Ball.png");
        bounds = new Rectangle(xCord,  yCord, ballTex.getWidth(), ballTex.getHeight());
    }

    public void move(float newX, float newY, float power){
        
    }

    public Vector2 getPosition() {
        return position;

    }

    public void bounce(){
        if (position.y <= 0 | position.y + this.ySize >= BallsScript.HEIGHT){
            velocity.y = -velocity.y * 0.3f;}
        if (position.x <= 0 | position.x + this.xSize >= BallsScript.WIDTH)
            velocity.x = -velocity.x * 0.3f;

    }

    public boolean isJumpable(){
        return (int) position.y == 0;
    }

    public Rectangle getBounds(){
        return bounds;}

    public void jump(int newX, int newY, double forceCoef){
        if (isJumpable()){
            velocity.add(-(position.x - newX), BallsScript.HEIGHT - newY + position.y);
        }
    }

    public void update(float dt){
        if (position.y < BallsScript.HEIGHT){
        velocity.add(0, GRAVITY);}

        if (position.x < 0){
            position.x = 0;
            bounce();
        }
        if (position.x > BallsScript.WIDTH - this.ySize){
            position.x = BallsScript.WIDTH - this.ySize;
            bounce();
        }

        if (position.y > BallsScript.HEIGHT - this.ySize){
            bounce();
            position.y = BallsScript.HEIGHT - this.ySize;
        }
        velocity.scl(dt);

        position.add(velocity.x, velocity.y);
        if(position.y <= 0){
            position.y = 0;
            if (velocity.x - SLIDE * 2 <= 0 | velocity.x + SLIDE * 2 >= 0){
                velocity.x += -velocity.x * SLIDE ;}
            else{
                velocity.x = 0;
            }
            bounce();
        }
        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }
}