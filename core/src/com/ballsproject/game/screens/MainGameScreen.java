        package com.ballsproject.game.screens;

        import com.badlogic.gdx.Screen;
        import com.ballsproject.game.BallsScript;
        
        public class MainGameScreen implements Screen{
            public BallsScript gameScreen;

            public MainGameScreen(BallsScript gameScreen){
                this.gameScreen = gameScreen;
            }
            @Override
            public void show() {
                System.out.println("I show a cuple of MUgic");
            }
        
            @Override
            public void render(float delta) {
            }
        
            @Override
            public void resize(int width, int height) {
            }
        
            @Override
            public void pause() {
            }
        
            @Override
            public void resume() {
            }
        
            @Override
            public void hide() {
            }
        
            @Override
            public void dispose() {
            }
        }
