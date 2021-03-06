package com.ballsproject.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GrapplePoint {
    public int xPos;
    public int yPos;

    private static final int xSize = 50;
    private static final int ySize = 50;

    public GrapplePoint(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void interact(){


    }
    

    public void update(SpriteBatch batch){
        Pixmap pixmap = new Pixmap(xSize, ySize, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLUE);
        pixmap.fillCircle(xSize / 2, ySize / 2, xSize);
        Texture texture = new Texture(pixmap);
//        Gdx.gl10.glLineWidth(10);
//        shapeDebugger.setProjectionMatrix(GameState.gamecum.combined);
//        shapeDebugger.begin(ShapeRenderer.ShapeType.Line);
//        shapeDebugger.setColor(1, 1, 1, 1);
//        shapeDebugger.line(2, 2, 5, 5);
        batch.draw(texture, xPos, yPos);
    }
}