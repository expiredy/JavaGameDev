package com.example.megaextrathiccapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawThread extends Thread{
    private final SurfaceHolder surfaceHolder;
    private volatile boolean running = true;
    private final Player player;

    public DrawThread(Context context, SurfaceHolder surfaceHolder, Player player) {
        this.player = player;
        this.surfaceHolder = surfaceHolder;
    }

    public void requestStop() {
        running = false;
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
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.RED);
                    canvas.drawOval(this.player.draw(), paint);
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}