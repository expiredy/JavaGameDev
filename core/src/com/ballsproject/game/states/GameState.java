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

    public GameState(GameStateManager gsm) {
        super(gsm);
//        level = new LevelGeneration();
        int xPos = (int) (random() * (BallsScript.WIDTH - 200) + 100);
        int yPos = (int) (random() * (BallsScript.HEIGHT - 200) + 100);
        point = new GrapplePoint(xPos, yPos);
        player = new Player((float) BallsScript.WIDTH / 2,400);
        gamecum.setToOrtho(false, BallsScript.WIDTH, BallsScript.HEIGHT);
    }
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            long startTime = TimeUtils.millis();
            if (player.isJumpable()){
                player.jump(Gdx.input.getX(), Gdx.input.getY(), 1.5f);}
            else {
                player.conncet(point);
                System.out.println((TimeUtils.millis() - startTime) * 1000);
            }
        }
    }

    @Override
    public void update(float dTime) {
        handleInput();
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