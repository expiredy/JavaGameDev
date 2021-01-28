package com.example.megaextrathiccapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawThread extends Thread{
    private SurfaceHolder surfaceHolder;
    private volatile boolean running = true;
    private float startX, startY, endX, endY;

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public void requestStop() {
        running = false;
    }

    public void setStartCords(float startX, float startY){
        this.startX = startX;
        this.startY = startY;
    }

    public void setEndCords(float endX, float endY){
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public void run() {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.drawColor(Color.BLUE);
                    if (startX != endX && startY != endY){
                        canvas.drawRect(startX, startY, endX, endY, paint);}
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}