package com.game.game_package.scene_components;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;


public class PlayerCamera extends OrthographicCamera {

    private final static float LERP = 0.1f;

    public boolean isFollowing = false;

    private Target targetForFollowing;

    public PlayerCamera(){
        super();
    }

    @Override
    public void update() {

    }

    @Override
    public void update(boolean updateFrustum) {

    }

    public void makeFollow(Player target){
        this.targetForFollowing = target;
        isFollowing = true;
    }

    public void updateCameraPosition(float deltaTime){
        Vector3 position = this.position;
        position.x += (targetForFollowing.position.x - position.x) * LERP * deltaTime;
        position.y += (targetForFollowing.position.y - position.y) * LERP * deltaTime;
    }
}
