package com.game.game_package.scene_components;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.game.game_package.BallsGameClass;

public class Player extends Target{
    //Some objects init

    private final OrthographicCamera camera;

    // some phisiscs constans
    private static final float GRAVITY = -13.0f;
    private static final float SPEED = 20f;
    //private static final float LERP = 0.1f;
    private static final float boundsMultiplayer = 0.3f;


    //Some movement values
    public Vector2 position;
    public Vector2 velocity;
    public Vector2 centerPosition;

    private float xCord;
    private float yCord;

    private boolean isGrounded;

    // everything about drawing stuff
    private final Integer xSize = 100;
    private final Integer ySize = 100;
    private Texture playerSprite;
    private Circle bounds;


    public Player(OrthographicCamera camera, float spawningXCord, float spawningYCord){
        this.camera = camera;
        //camera.makeFolow(this);
        velocity =  new Vector2(0, 0);
        position = new Vector2(spawningXCord, spawningYCord);
        centerPosition = new Vector2(position.x + xSize / 2, position.y + ySize / 2);
        startDrawing();
    }

    public void update(float deltaTime){
        //updateCameraPosition(deltaTime);
        bounds.setPosition(position.x, position.y);
        centerPosition = new Vector2(position.x + xSize / 2, position.y + ySize / 2);
        freeFall();
        updateCurrentPosition(deltaTime);
    }

    private void startDrawing(){
        playerSprite = BallsGameClass.getPlayerSkin();
        bounds = new Circle(position.x, position.y, playerSprite.getHeight());
    }

    public void drawPlayer(Batch batch){

        batch.draw(this.playerSprite, position.x, position.y, xSize, ySize);
    }

    public void AddForce(float xCordToGo, float yCordToGo, double force){
        System.out.println(centerPosition.x + " " + xCordToGo);
        System.out.println(centerPosition.y + " " + yCordToGo);
        float deltaX = xCordToGo - centerPosition.x;
        float deltaY = yCordToGo - centerPosition.y;
        float lengthOfWay = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        float xDirection = SPEED * deltaX  / lengthOfWay;
        float yDirection = SPEED * deltaY / lengthOfWay;
        System.out.println(xDirection + " " + yDirection);
        velocity.add(xDirection * 10, (yDirection - GRAVITY) * 10);
        System.out.println(velocity);
//        float xCordCoef = xCordToGo / yCordToGo;
//        float yCordCoef = 1 - Math.abs(xCordCoef);
//
//        velocity.add(xCordCoef, yCordCoef);
//        System.out.println(xCordCoef + " " + yCordCoef);

        //velocity.x *= force;
        //velocity.y *= force;
    }

    public void bounce(){
        if (position.y <= 0 | position.y + this.ySize >= BallsGameClass.HEIGHT){
            velocity.y = -velocity.y * boundsMultiplayer;}
        if (position.x <= 0 | position.x + this.xSize >= BallsGameClass.WIDTH)
            velocity.x = -velocity.x * boundsMultiplayer;

    }

    private void updateCurrentPosition(float deltaTime){
        velocity.scl(deltaTime);


        position.add(velocity.x, velocity.y);

        velocity.scl(1/deltaTime);
        bounds.setPosition(position.x, position.y);
    }

    private void freeFall(){
        if (this.isInAir()){
            velocity.add(0, GRAVITY);}
        else if(!isGrounded){
            isGrounded = true;
            position.y = 0;
        }
    }
    public boolean isInAir(){
        isGrounded = false;
        return ((int) position.y > 1);

    }

    public void updateCameraPosition(float deltaTime){
        camera.position.set(new Vector3(position.x, position.y, 0));
        camera.update();
    }
}
