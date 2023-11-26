package px.seisen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import px.seisen.MainMenuScreen;

public class Seisen extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float secondsSinceStart = 0;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();

	secondsSinceStart += Gdx.graphics.getDeltaTime();

		Texture texture = new Texture("logos/seisen-main-logo.png");

		if (secondsSinceStart < 1) {
			batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		} else if (secondsSinceStart < 4) {
			batch.setColor(1, 1, 1, 4 - secondsSinceStart);
			batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			batch.setColor(1, 1, 1, 1);
		} else {
			batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			MainMenuScreen mainMenuScreen = new MainMenuScreen();
			mainMenuScreen.show();
			mainMenuScreen.render(0);
			return;
		}

		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
