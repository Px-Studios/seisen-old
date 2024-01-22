package px.seisen;

import px.seisen.characters.BaseCharacter;

public class Player {
    private final BaseCharacter character;
    public boolean isJumping, isPlayerOne;
    public String name;
    public float x, y;

    public Player(String name, BaseCharacter character, boolean isPlayerOne) {
        this.name = name;
        this.isPlayerOne = isPlayerOne;

        if (isPlayerOne) {
            this.x = 100;
        } else {
            this.x = 600;
        }
        this.y = 100;

        this.isJumping = false;
        this.character = character;
    }

    public void moveLeft(float timeDelta) {
        this.x -= 400 * timeDelta;
    }

    public void moveRight(float timeDelta) {
        this.x += 400 * timeDelta;
    }

    public void stayInBounds() {
        if (this.x < 0)
            this.x = 0;
        if (this.x > 800 - this.character.getWidth())
            this.x = 800 - this.character.getWidth();
    }
}
