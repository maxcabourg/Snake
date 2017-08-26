package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.snake.SnakeGame;
import states.PlayState;

import static sprites.Snake.Direction.BOTTOM;

public class SnakeCase extends Sprite {

    private ShapeRenderer renderer;

    public SnakeCase(){
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
    }

    public SnakeCase(int x, int y){
        this();
        position = new Vector2(x, y);
    }

    public SnakeCase(SnakeCase snakeCase){
        this();
        position = snakeCase.position;
    }
    @Override
    public void render() {
        renderer.begin();
        renderer.setColor(0, 1, 0, 1);
        renderer.rect(position.x * PlayState.CASE_WIDTH, position.y * PlayState.CASE_HEIGHT, PlayState.CASE_WIDTH, PlayState.CASE_HEIGHT);
        renderer.end();
    }

    @Override
    public void update() {

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {
        sprite.dispose();
    }
}
