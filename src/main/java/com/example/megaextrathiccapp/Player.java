package com.example.megaextrathiccapp;
import android.app.Notification;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.ArrayList;

public class Player {
    public float x_pos;
    public float y_pos;
    private final int maximum_moves = 10;
    public MovingThread [] moveArray = new MovingThread[maximum_moves + 1];
//    private Paint mPaint = new Paint();


    public Player(){
        float player_size_x = 10;
        float player_size_y = 10;

//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.RED);
//        RectF playerSprite = new RectF(50, 50, 150, 150);

    }

    public void move(float new_x_cord, float new_y_cord, float speed){
        this.moveArray[this.moveArray.length] = new MovingThread(this, this.x_pos, this.y_pos, new_x_cord, new_y_cord, speed);
        this.moveArray[this.moveArray.length - 1].start();
        if (this.moveArray.length >= this.maximum_moves){
            this.moveArray[0].moving = false;
//            try {
//                this.moveArray[0].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for (int i=0; i < this.moveArray.length - 2; i++){
                this.moveArray[i] = this.moveArray[i + 1];
            }
        }
    }

    public RectF draw(){
        return new RectF(this.x_pos, this.y_pos, this.x_pos + 50, this.y_pos + 50);
    }

    public boolean isJumpable(){
        return true;
    }
}
