package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Sprite {
    protected Texture sprite;
    protected Vector2 position;

    public abstract void render();
    public abstract void update();
    public abstract void handleInput();
    public abstract void dispose();

    public Texture getSprite(){
        return sprite;
    }

    public Vector2 position(){
        return position;
    }
}
