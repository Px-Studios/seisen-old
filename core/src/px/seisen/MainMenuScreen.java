package px.seisen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.Console;

public class MainMenuScreen implements Screen {
    final Seisen game;
    private Stage stage;
    OrthographicCamera camera;

    public MainMenuScreen(final Seisen game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        SpriteBatch batch = new SpriteBatch();
        int midX = Gdx.graphics.getWidth() / 2;
        int screenTop = Gdx.graphics.getHeight();
        int screenRight = Gdx.graphics.getWidth();

        Texture startTex = new Texture("buttons/start.png");
        Texture helpTex = new Texture("buttons/help.png");
        Texture quitTex = new Texture("buttons/quit.png");

        int buttonWidth = startTex.getWidth();
        int buttonHeight = startTex.getHeight();

        int[] buttonTops = {screenTop - 200, screenTop - 400, screenTop - 600};
        int[] buttonBottoms = {buttonTops[0] - buttonHeight, buttonTops[1] - buttonHeight, buttonTops[2] - buttonHeight};

        int anyButtonLeft = midX - buttonWidth / 2;
        int anyButtonRight = midX + buttonWidth / 2;

        batch.begin();
        for (int i = 0; i < 3; i++) {
            batch.draw(i == 0 ? startTex : (i == 1 ? helpTex : quitTex), anyButtonLeft, buttonBottoms[i]);
        }
        batch.end();

        if (Gdx.input.isButtonJustPressed(0)) {
            int x = screenRight - Gdx.input.getX();
            int y = screenTop - Gdx.input.getY();

            for (int i = 0; i < 3; i++) {
                if (x >= anyButtonLeft && x <= anyButtonRight && y >= buttonBottoms[i] && y <= buttonTops[i]) {
                    String buttonPressedName = i == 0 ? "start" : (i == 1 ? "help" : "quit");

                    switch (buttonPressedName) {
                        case "start":
                            game.setScreen(new GameScreen(game));
                            break;
                        case "help":
                            System.out.println("Help");
                            break;
                        case "quit":
                            Gdx.app.exit();
                            break;
                    }

                    dispose();
                    break;
                }
            }
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

    }
}
