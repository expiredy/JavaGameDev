    package com.ballsproject.game.states;

    import com.badlogic.gdx.Gdx;
    import com.badlogic.gdx.graphics.g2d.SpriteBatch;
    import com.badlogic.gdx.utils.TimeUtils;
    import com.ballsproject.game.BallsScript;
    import com.ballsproject.game.objects.GrapplePoint;
    import com.ballsproject.game.players.Player;

    import static java.lang.Math.random;

    public class GameState extends State{

//    private final LevelGeneration level;
    public static boolean isPlay = true;
    private final GrapplePoint point;
    private final Player player;
    private boolean moveable = false;
    private long powerCounter;

    public GameState(GameStateManager gsm) {
        super(gsm);
//        level = new LevelGeneration();
        int xPos = (int) (random() * (BallsScript.WIDTH - 200) + 100);
        int yPos = (int) (random() * (BallsScript.HEIGHT - 200) + 100);
        point = new GrapplePoint(xPos, yPos);
        player = new Player((float) BallsScript.WIDTH / 2,400);
        gamecum.setToOrtho(false, BallsScript.WIDTH, BallsScript.HEIGHT);
    }

    private void checkForCollisions(){
      player.checkCollisionsWithGround();
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            moveable = true;
            this.powerCounter = TimeUtils.millis();
            }
        else if(!Gdx.input.isTouched() & moveable){
            moveable = false;
            System.out.println((TimeUtils.millis() - powerCounter) / 1000);
            if (player.isJumpable()){
                player.jump(Gdx.input.getX(), Gdx.input.getY(),(float) (TimeUtils.millis() - powerCounter) / 1000);
            }
        }
    }

    @Override
    public void update(float dTime) {
        handleInput();
        checkForCollisions();
        if (isPlay){
            this.player.update(dTime);}
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(gamecum.combined);
        batch.begin();
//        level.update(batch);
        point.update(batch);
        batch.draw(this.player.ballTex, player.getPosition().x, player.getPosition().y,
                this.player.xSize, this.player.ySize);
        batch.end();

    }
}