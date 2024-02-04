package px.seisen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;

import px.seisen.characters.Hitbox;
import px.seisen.characters.Samurai;
import px.seisen.stages.BaseStage;

public class GameScreen implements Screen {
    final Seisen game;
    private final BaseStage stage;
    private final KeyboardControls keyboardControls;
    OrthographicCamera camera;
    Texture backgroundTex;

    Player player1, player2;
    Sprite player1Sprite, player2Sprite;

    float deltaTime;

    public GameScreen(final Seisen game, BaseStage stage) {
        this.game = game;
        this.stage = stage;
        this.keyboardControls = new KeyboardControls();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        backgroundTex = new Texture("stages/" + stage.stageId + ".png");

        // Removed the type declaration to initialize the class fields instead
        player1 = new Player("Player 1", new Samurai(), true);
        player2 = new Player("Player 2", new Hitbox(), false);

        player1Sprite = new Sprite(player1.getCharacter().getTexture());
        player2Sprite = new Sprite(player2.getCharacter().getTexture());

        player1.setSprite(player1Sprite);
        player2.setSprite(player2Sprite);

        player1.getSprite().setPosition(player1.getX(), player1.getY());
        player2.getSprite().setPosition(player2.getX(), player2.getY());

        player1.getSprite().setSize(player1.getCharacter().getWidth(), player1.getCharacter().getHeight());
        player2.getSprite().setSize(player2.getCharacter().getWidth(), player2.getCharacter().getHeight());
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTex, 0, 0, 800, 480);

        player1.getSprite().draw(game.batch);
        player2.getSprite().draw(game.batch);

        game.font.draw(game.batch, "Seisen | Stage " + stage.stageName, 50, 50);

        game.batch.end();

        delta = Gdx.graphics.getDeltaTime();
        keyboardControls.handleInput(player1, player2, delta);
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / (float) width;
        float scale;
        float cropX = 0;
        float cropY = 0;

        if (aspectRatio > 1.5) {
            scale = (float) width / 800;
            cropY = (height - 480 * scale) / 2;
        } else {
            scale = (float) height / 480;
            cropX = (width - 800 * scale) / 2;
        }

        Gdx.gl.glViewport((int) cropX, (int) cropY, (int) (800 * scale), (int) (480 * scale));

    }

    @Override
    public void show() {
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
        backgroundTex.dispose();
    }
}
