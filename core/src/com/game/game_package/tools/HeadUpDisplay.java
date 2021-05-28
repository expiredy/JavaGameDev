package com.game.game_package.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class HeadUpDisplay {
    private Stage stage;
    private Label outputLabel;

//    ImageButton UpButton;
//    ImageButton DownButton;
    Button LeftButton;
    Button RightButton;

    public HeadUpDisplay(){
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        ButtonCreation();
    }

    private void ButtonCreation(){
    //   Skin SkinForUpButton = new Skin(Gdx.files.internal("buttons_sprites\\button_ui.json"));
//        Skin SkinForDownButton = new Skin(Gdx.files.internal("buttons_sprites\\DownButtonSprite"));
//        Skin SkinForLeftButton = new Skin(Gdx.files.internal("buttons_sprites\\LeftButtonSprite"));
//        Skin SkinForRightButton = new Skin(Gdx.files.internal("buttons_sprites\\RightButtonSprite"));
//        UpButton = new Button(SkinForUpButton,"small");
//        DownButton = new Button(SkinForUpButton,"small");
//        leftButton = new Button(SkinForUpButton,"small");
//        RightButton = new Button(SkinForUpButton,"small");
//        try {


//        UpButton = new ImageButton(SkinForUpButton);
//        UpButton.setSize(100, 100);
//        UpButton.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(
//                new Texture(Gdx.files.internal("buttons_sprites\\DefaultButtonSpriteUp.jpg"))));
//        UpButton.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(
//                new Texture(Gdx.files.internal("buttons_sprites\\DefaultButtonSpriteDown.jpg"))));
//
//        UpButton.addListener(new InputListener(){
//            @Override
//            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                System.out.println(x + " " + y + " " + button);
//            }
//            @Override
//            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Pressed Image Button");
//                return true;
//            }
//        });
//        stage.addActor(UpButton);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//    }
//
//    private void FakeButtonsCreation(){
//        RightButton
 }

    private void FakeButtonCreation(){
        LeftButton = new Button(100, 100, 50,
                "buttons_sprites\\DefaultButtonSpriteDown.jpg",
                "buttons_sprites\\DefaultButtonSpriteUp.jpg");
    }

    public void render (SpriteBatch batch) {
        LeftButton.render(batch);
    }


    public void checkButtonsForPressing(float xCordOfPressing, float yCordOfPressing) {
        if (LeftButton.checkForPressing(xCordOfPressing, yCordOfPressing)){

        }
    }
}
