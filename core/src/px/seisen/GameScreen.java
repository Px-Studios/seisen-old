package px.seisen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import px.seisen.characters.Hitbox;

public class GameScreen implements Screen {
    final Seisen game;
    private final GameStage stage;
    OrthographicCamera camera;
    Texture backgroundTex, characterTex;

    Player player1, player2;

    float deltaTime;

    public GameScreen(final Seisen game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        stage = new GameStage("Sunrise", "sunrise");

        backgroundTex = new Texture("stages/" + stage.stageId + ".png");
        characterTex = new Texture("characters/hitbox.png");

        Player player1 = new Player("Player 1", new Hitbox(), true);
        Player player2 = new Player("Player 2", new Hitbox(), false);

        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        game.batch.draw(backgroundTex, 0, 0, 800, 480);
        game.batch.draw(characterTex, player1.x, player1.y);
        game.batch.draw(characterTex, player2.x, player2.y);

        game.font.draw(game.batch, "Seisen | Stage " + stage.stageName, 100, 150);

        game.batch.end();

        deltaTime = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player1.moveLeft(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player1.moveRight(delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player2.moveLeft(delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player2.moveRight(delta);
        }
    }

    @Override
    public void resize(int i, int i1) {

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
        characterTex.dispose();
    }
}
