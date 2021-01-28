package com.example.megaextrathiccapp;
import android.content.Context;

public class Player {
    public float x_pos;
    public float y_pos;


    public Player(){
        float player_size_x = 10;
        float player_size_y = 10;
    }

    public void move(float new_x_cord, float new_y_cord, float speed){
        MovingThread movingThread = new MovingThread(this.x_pos, this.y_pos, new_x_cord, new_y_cord, speed);
    }

    public boolean isJumpable(){
        return true;
    }
}
