package px.seisen.characters;

public class BaseCharacter {
    String id, name;
    int width, height;

    public BaseCharacter() {
        this.id = "hitbox";
        this.name = "Hitbox";
        this.width = 300;
        this.height = 600;
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
}
