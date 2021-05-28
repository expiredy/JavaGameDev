package com.game.game_package.tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button extends com.badlogic.gdx.scenes.scene2d.ui.Button {
    private final Texture buttonUpSprite;
    private final Texture buttonDownSprite;

    private boolean isPressed = false;

    private final int xLowerPos;
    private final int yLowerPos;

    private final int ButtonSize;

    public Button(int xLowerPos, int yLowerPos, int Size, String pathToDownTexture,
                  String pathToUpTexture){
        buttonDownSprite = new Texture(pathToDownTexture);
        buttonUpSprite = new Texture(pathToUpTexture);
        this.xLowerPos = xLowerPos;
        this.yLowerPos = yLowerPos;
        this.ButtonSize = Size;

    }

    public void render(SpriteBatch batch){
        batch.begin();
        if(isPressed){
            batch.draw(this.buttonDownSprite, xLowerPos, yLowerPos, ButtonSize, ButtonSize);}
        else{
            batch.draw(this.buttonUpSprite, xLowerPos, yLowerPos, ButtonSize, ButtonSize);
        }
        batch.end();
    }

    public boolean checkForPressing(float XCordOfPressing, float YCordOfPressing){
        isPressed = ((xLowerPos < XCordOfPressing) && (XCordOfPressing < (xLowerPos + ButtonSize))
                && ((yLowerPos < YCordOfPressing) && (YCordOfPressing < (yLowerPos + ButtonSize))));
        return isPressed;
    }
}
