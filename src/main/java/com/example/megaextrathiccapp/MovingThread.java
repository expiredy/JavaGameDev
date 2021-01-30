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
    private String direction;
    private float power_level;
    private float speed;
    private final Player player;
    public boolean moving = true;

    public MovingThread(Player player, String direction, float power_level, float speed){
        this.direction = direction;
        this.power_level = power_level;
        this.speed = speed;
        this.player = player;
    }

    private boolean checkForStop(){
        return false;}

    @Override
    public void run() {
        super.run();
    }
}