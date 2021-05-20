package com.game.game_package.scene_components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.game.game_package.BallsGameClass;
import com.game.game_package.constants.LevelKeyConstants;
import com.game.game_package.scene_components.oclusion.DefaultObject;
import com.game.game_package.scene_components.oclusion.FreeSpace;
import com.game.game_package.scene_components.oclusion.Spike;
import com.game.game_package.scene_components.oclusion.Wall;

public class TheWorldClass {
    //toki wo tomare

    // main params like width nad height of matrix
    private Integer worldsHeight;
    private Integer worldsWidth;
    private World world;
    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    //  objects

    private Player player;

    // main matrix
    // 1:
    public DefaultObject [][] gameField;

    public TheWorldClass(){
        backgroundTexture = new Texture("backgrounds/maxresdefault.jpg");
        backgroundSprite = new Sprite(backgroundTexture);
        System.out.println(worldsWidth + "/n" + worldsHeight);
    }

    public void gameWorldGenerator(Integer[][] gameFieldBlueprint){
        this.world = new World(new Vector2(0, -10), true);
        worldsHeight = gameFieldBlueprint.length;
        worldsWidth = gameFieldBlueprint[0].length;

        gameField = new DefaultObject[worldsHeight][worldsWidth];
        for(int yCord = 0; yCord < worldsHeight; yCord++) {
            for (int xCord = 0; xCord < worldsWidth; xCord++) {
                switch (gameFieldBlueprint[yCord][xCord]){
                    case LevelKeyConstants.wallId:
                        gameField[yCord][xCord] = new Wall();
                        break;
                    case LevelKeyConstants.freeSpaceId:
                        gameField[yCord][xCord] = new FreeSpace();
                        break;
                    case LevelKeyConstants.cornerId:
                        gameField[yCord][xCord] = new Spike();
                        break;

                }
            }
        }
    }

    public void renderBackground(Batch spriteBatch) {
        spriteBatch.draw(backgroundTexture, 0 , 0, BallsGameClass.WIDTH, BallsGameClass.HEIGHT);
    }
}
