package com.game.game_package.constants;

import com.game.game_package.BallsGameClass;

public class DrawingConstants {
    private final static Integer DefaultHeight = 2400;
    private final static Integer DefaultWidth = 1080;
    public static Integer meter = 100;

    public void calculate_constants(){
        Integer currentHeight = BallsGameClass.HEIGHT;
        Integer currentWidth = BallsGameClass.WIDTH;

        meter = meter / DefaultHeight * currentHeight;
    }
}
