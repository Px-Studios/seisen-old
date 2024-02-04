package px.seisen.characters;

import com.badlogic.gdx.graphics.Texture;

public class BaseCharacter {
    private final int movementSpeed;
    String id, name;
    int width, height;

    public BaseCharacter() {
        this.id = "base_demo";
        this.name = "BaseDemoCharacter";
        this.width = 100;
        this.height = 200;
        this.movementSpeed = 400;
    }

    public Texture getTexture() {
        return new Texture("characters/" + this.id + ".png");
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
    
    public int getMovementSpeed() {
        return this.movementSpeed;
    }
}
