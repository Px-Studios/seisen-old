package px.seisen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    final Seisen game;
    OrthographicCamera camera;
    Texture backgroundTex, characterTex;
    Rectangle characterRect;
    Boolean isJumping;

    public GameScreen(final Seisen game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        backgroundTex = new Texture("stages/sunrise.png");
        characterTex = new Texture("characters/hitbox.png");

        characterRect = new Rectangle();
        characterRect.x = 300;
        characterRect.y = 50;
        characterRect.width = 50;
        characterRect.height = 100;

        isJumping = false;
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

        game.font.draw(game.batch, "[Stage 1] Sunrise", 100, 150);

        game.batch.draw(backgroundTex, 0, 0, 800, 480);
        game.batch.draw(characterTex, characterRect.x, characterRect.y, 100, 300);

        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            characterRect.x -= 400 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            characterRect.x += 400 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            isJumping = true;

        if (isJumping) {
            characterRect.y += 200 * Gdx.graphics.getDeltaTime();
            if (characterRect.y > 100) {
                isJumping = false;
                characterRect.y = 50;
            }
        }

		if (characterRect.x < 0)
            characterRect.x = 0;
		if (characterRect.x > 800 - characterRect.width)
            characterRect.x = 800 - characterRect.width;
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
