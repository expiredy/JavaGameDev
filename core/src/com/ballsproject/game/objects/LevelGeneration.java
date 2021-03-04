package com.ballsproject.game.objects;

import com.ballsproject.game.BallsScript;

import static java.lang.Math.random;

public class LevelGeneration {
    public GrapplePoint[] zipPointsArray;
    private static int totalZipPoints;

    public LevelGeneration(){
         totalZipPoints = (int) (random() * 10);
         zipPointsArray = new GrapplePoint[totalZipPoints];
         for (int i = 0; i < totalZipPoints; i++){
             int xPos = (int) (random() * (BallsScript.WIDTH - 200) + 100);
             int yPos = (int) (random() * (BallsScript.HEIGHT - 200) + 100);
             zipPointsArray[i] = new GrapplePoint(xPos, yPos);
         }
    }

    public void drawBackground(){

    }

    public void update(){
        drawBackground();
        for (int i=0; i < totalZipPoints; i++){
            zipPointsArray[i].update();
        }
    }
}
