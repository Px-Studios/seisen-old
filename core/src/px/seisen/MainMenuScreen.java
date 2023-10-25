package px.seisen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    SpriteBatch batch;

    @Override
    public void show() {
        batch = new SpriteBatch();

        // we want to add two buttons: "Start Game" and "Exit"
        // use font "fonts/RcRocketRegular-0WVW9.otf"
        // use font size 48
        // use color white
        // use padding 10
        // border in #FF8000
        // background in black
        // when the user clicks on "Start Game", switch to GameScreen
        // when the user clicks on "Exit", exit the game
        // center the buttons vertically and horizontally!

        // create skin with font "fonts/RcRocketRegular-0WVW9.otf" and font size 48, colors are above

        BitmapFont font = new BitmapFont();
        font.getData().setScale(48);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        TextButton startButton = new TextButton("Start Game", textButtonStyle);

        startButton.setPosition(Gdx.graphics.getWidth() / 2 - startButton.getWidth() / 2, Gdx.graphics.getHeight() / 2 - startButton.getHeight() / 2);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        System.out.println("MainMenuScreen.render()");
        ScreenUtils.clear(0, 0, 0, 1);
        // add startButton to the stage:
        // 1. get the stage from the skin
        // 2. add the startButton to the stage
        // 3. draw the stage

        // 1:
        Skin skin = new Skin();
        skin.add("default", new TextButton.TextButtonStyle());
        skin.getFont("default").getData().setScale(48);
        skin.getFont("default").setColor(Color.WHITE);

        // 2:
        TextButton startButton = new TextButton("Start Game", skin);
        startButton.setPosition(Gdx.graphics.getWidth() / 2 - startButton.getWidth() / 2, Gdx.graphics.getHeight() / 2 - startButton.getHeight() / 2);
        startButton.draw(batch, 1);

        // 3 add to SpriteBatch:
        Table table = new Table();
        table.setFillParent(true);
        table.center().center();

        table.add(startButton).pad(10).row();

        table.draw(batch, 1);

        batch.end();
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
        batch.dispose();
    }
}