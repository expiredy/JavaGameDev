package com.example.megaextrathiccapp;
import android.app.Notification;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Player {
    public float x_pos;
    public float y_pos;
//    private Paint mPaint = new Paint();


    public Player(){
        float player_size_x = 10;
        float player_size_y = 10;

//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.RED);
//        RectF playerSprite = new RectF(50, 50, 150, 150);

    }

    public void move(float new_x_cord, float new_y_cord, float speed){
        MovingThread movingThread = new MovingThread(this.x_pos, this.y_pos, new_x_cord, new_y_cord, speed);
    }

    public RectF draw(){
        return new RectF(50, 50, 150, 150);
    }

    public boolean isJumpable(){
        return true;
    }
}
