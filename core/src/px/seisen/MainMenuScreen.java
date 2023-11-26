package px.seisen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.lang.invoke.MutableCallSite;

public class MainMenuScreen implements Screen {
    private Stage stage;
    private Table table;
    private Skin skin;
    private BitmapFont customFont;
    private SpriteBatch batch;

    public MainMenuScreen() {
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);

        batch = new SpriteBatch();

        // Load your custom font here
        customFont = new BitmapFont();

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/RcRocketRegular-0WVW9.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24; // Specify the desired font size

        BitmapFont rocketRegular = generator.generateFont(parameter);

        generator.dispose(); // Dispose the generator when done

        skin = new Skin(Gdx.files.internal("skin/metal-ui.json"));

        table = new Table();
        table.setFillParent(true);

        Music music = Gdx.audio.newMusic(Gdx.files.internal("audio/soundtrack.wav"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();

        // Create Start button
        TextButton startButton = new TextButton("Start", skin);
        startButton.getLabel().setFontScale(2.0f); // Adjust the font size
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle Start button click event here
                System.out.println("Start button clicked");
            }
        });

        // Create Exit button
        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.getLabel().setFontScale(2.0f); // Adjust the font size
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit(); // Close the application
            }
        });

        table.add(startButton).padBottom(20);
        table.row();
        table.add(exitButton);

        stage.addActor(table);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        // You can draw other elements or backgrounds here if needed
        batch.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        skin.dispose();
        batch.dispose();
        customFont.dispose();
    }
}
