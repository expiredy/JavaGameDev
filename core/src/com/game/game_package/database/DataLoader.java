package com.game.game_package.database;

import com.game.game_package.constants.LevelKeyConstants;

public class DataLoader {

    public Integer[][] levelBlueprint;

    public DataLoader(int worldsHeight, int worldsWidth){

        this.levelBlueprint = new Integer[worldsHeight][worldsWidth];

        for(int yCord = 0; yCord < worldsHeight; yCord++) {
            for (int xCord = 0; xCord < worldsWidth; xCord++) {
                if (yCord % (worldsHeight - 1) == 0 || xCord % (worldsWidth - 1) == 0){
                    levelBlueprint[yCord][xCord] = LevelKeyConstants.wallId;
                }
                else{
                    levelBlueprint[yCord][xCord] = LevelKeyConstants.freeSpaceId;
                }
            }
        }
    }
}
