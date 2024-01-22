package px.seisen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MainMenuScreen implements Screen {
    final Seisen game;
    Stage stage;
    Texture backgroundTex;
    Image startImage, helpImage, quitImage;

    public MainMenuScreen(final Seisen game) {
        this.game = game;

        backgroundTex = new Texture("gui/bg.png");

        startImage = new Image(new Texture("buttons/start.png"));
        helpImage = new Image(new Texture("buttons/help.png"));
        quitImage = new Image(new Texture("buttons/quit.png"));

        stage = new Stage(new FitViewport(800, 480)); // Use your desired world width and height
        Gdx.input.setInputProcessor(stage);

        // Set up listeners for each button
        startImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle start button click
                game.setScreen(new GameScreen(game));
                dispose();
            }
        });

        helpImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle help button click
                System.out.println("Help button clicked");
            }
        });

        quitImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle quit button click
                Gdx.app.exit();
            }
        });

        // Create a table to layout the buttons
        Table table = new Table();
        table.setFillParent(true);
        table.add(startImage).padBottom(20).row();
        table.add(helpImage).padBottom(20).row();
        table.add(quitImage).padBottom(20);
        stage.addActor(table);
    }

    @Override
    public void show() {
        // No additional setup required here
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the background
        game.batch.begin();
        game.batch.draw(backgroundTex, 0, 0, stage.getWidth(), stage.getHeight());
        game.batch.end();

        // Draw the stage with the buttons
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
        backgroundTex.dispose();
    }
}
