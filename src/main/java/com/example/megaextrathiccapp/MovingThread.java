package com.example.megaextrathiccapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MovingThread extends Thread{
    private float x_cord;
    private float y_cord;
    private final float new_x_cord;
    private final float new_y_cord;
    private float speed;
    private final Player player;
    public boolean moving = true;

    public MovingThread(Player subject, float old_x_cord, float old_y_cord, float new_x_cord, float new_y_cord, float speed){
        this.y_cord = old_y_cord;
        this.x_cord = old_x_cord;
        this.new_y_cord = new_y_cord;
        this.new_x_cord = new_x_cord;
        this.speed = speed;
        this.player = subject;
    }
    private boolean checkForStop(){
        return this.player.x_pos >= this.new_x_cord | this.player.y_pos >= this.new_y_cord;}

    @Override
    public void run() {
        float x_speed = this.new_x_cord /  Math.max(this.new_x_cord, this.new_y_cord);
        float y_speed = this.new_y_cord / Math.min(this.new_y_cord, this.new_x_cord);
        while(this.moving){
            if (player.x_pos <= this.new_x_cord) {
                this.player.x_pos += x_speed;
                if (checkForStop()){
                    moving = false;
                }
            }
            else {
                this.player.x_pos -= x_speed;
                if (!checkForStop()){
                    moving = false;
                }
            }
            if (player.y_pos <= this.new_y_cord) {
                this.player.y_pos += y_speed;
                if (checkForStop()){
                    moving = false;
                }
            } else {
                this.player.y_pos -= y_speed;
                if (!checkForStop()){
                    moving = false;
                }
            }

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}