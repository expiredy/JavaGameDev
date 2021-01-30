package com.example.megaextrathiccapp;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class DrawView extends SurfaceView implements SurfaceHolder.Callback {
    private DrawThread drawThread;
    public float playerSpeed = 0.0f;
    public MovingThread movePlayer;
    public Player player;
    private Timer addPower;

    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.player = new Player();
        drawThread = new DrawThread(getContext(), getHolder(), this.player);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawThread.requestStop();
        boolean retry = true;
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
               this.addPower = new Timer();
                addPower.start();
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                System.out.println(addPower.getTime());
                this.movePlayer = new MovingThread(this.player, "x", addPower.getTime(), this.playerSpeed);
                this.movePlayer.start();
                break;
        }
        return super.onTouchEvent(event);
    }
}


class Timer extends Thread{
    private boolean runnable = true;
    public int millis = 250;
    public float powerLevel;

    public float getTime(){
        this.runnable = false;
        return powerLevel;
    }

    @Override
    public void run(){
        while (runnable){
            this.powerLevel += this.millis;
            try {
                Thread.sleep(this.millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}