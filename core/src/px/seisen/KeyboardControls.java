package px.seisen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KeyboardControls {
    public void handleInput(Player player1, Player player2, float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

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

        for (Player player : new Player[]{player1, player2}) {
            player.stayInBounds();

            if (!player.isFacingRight() && !player.getSprite().isFlipX()) {
                player.getSprite().flip(true, false);
            } else if (player.isFacingRight() && player.getSprite().isFlipX()) {
                player.getSprite().flip(true, false);
            }
        }
    }
}
