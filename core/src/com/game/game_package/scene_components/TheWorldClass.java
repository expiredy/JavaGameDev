package com.game.game_package.scene_components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
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

    //  objects

    private Player player;

    // main matrix
    // 1:
    public DefaultObject [][] gameField;

    public TheWorldClass(){
        System.out.println(worldsWidth + "" + worldsHeight);
    }

    public void gameWorldGenerator(Integer[][] gameFieldBlueprint){
        world = new World(new Vector2(0, -10), true);
        worldsHeight = gameFieldBlueprint.length;
        worldsWidth = gameFieldBlueprint[0].length;

        gameField = new DefaultObject[worldsHeight][worldsWidth];
        for(int xCord = 0; xCord < worldsHeight; xCord++) {
            for (int yCord = 0; yCord < worldsWidth; yCord++) {
                if (gameFieldBlueprint[xCord][yCord] == 1){
                    gameField[xCord][yCord] = new Wall();
                }
                else if (gameFieldBlueprint[xCord][yCord] == 0){
                    gameField[xCord][yCord] = new FreeSpace();
                }
                else if (gameFieldBlueprint[xCord][yCord] == 2){
                    gameField[xCord][yCord] = new Spike();
                }
            }
        }
    }
}
