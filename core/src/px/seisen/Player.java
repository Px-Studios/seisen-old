package px.seisen;

import com.badlogic.gdx.graphics.g2d.Sprite;
import px.seisen.characters.BaseCharacter;

public class Player {
    private final BaseCharacter character;
    private Sprite sprite;
    private boolean isFacingRight;
    private boolean isJumping;
    private final boolean isPlayerOne;
    private final String name;
    private float x, y;

    public Player(String name, BaseCharacter character, boolean isPlayerOne) {
        this.name = name;
        this.sprite = null;
        this.isJumping = false;
        this.character = character;
        this.isPlayerOne = isPlayerOne;
        this.isFacingRight = isPlayerOne;

        if (isPlayerOne) {
            this.x = 100;
        } else {
            this.x = 600;
        }
        this.y = 100 - 20;

    }

    public void updateSpritePosition() {
        this.sprite.setPosition(this.x, this.y);
    }

    public void moveLeft(float timeDelta) {
        this.x -= this.character.getMovementSpeed() * timeDelta;
        this.isFacingRight = false;
        this.updateSpritePosition();
    }

    public void moveRight(float timeDelta) {
        this.x += this.character.getMovementSpeed() * timeDelta;
        this.isFacingRight = true;
        this.updateSpritePosition();
    }

    public void stayInBounds() {
        if (this.x < 0) {
            this.x = 0;
        }

        float rightEdgePosition = this.x + this.character.getWidth();
        if (rightEdgePosition > 800) {
            this.x = 800 - this.character.getWidth();
        }
    }

    public float getX() {
        return this.x;
    }
    public float getY() {
        return this.y;
    }
    public BaseCharacter getCharacter() {
        return this.character;
    }
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    public Sprite getSprite() {
        return this.sprite;
    }
    public boolean isPlayerOne() {
        return this.isPlayerOne;
    }
    public boolean isJumping() {
        return this.isJumping;
    }
    public String getName() {
        return this.name;
    }
    public boolean isFacingRight() {
        return this.isFacingRight;
    }
}
