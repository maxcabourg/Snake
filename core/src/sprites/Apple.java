package sprites;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import states.PlayState;

import java.util.Random;

public class Apple extends Sprite {
    private Random random;
    private ShapeRenderer shapeRenderer;

    public Apple(){
        random = new Random();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        int randX = random.nextInt(PlayState.NUMBER_CASES_WIDTH);
        int randY = random.nextInt(PlayState.NUMBER_CASES_HEIGHT);
        position = new Vector2(randX, randY);
    }
    @Override
    public void render() {
        shapeRenderer.begin();
        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.rect(position.x * PlayState.CASE_WIDTH, position.y * PlayState.CASE_HEIGHT, PlayState.CASE_WIDTH, PlayState.CASE_HEIGHT);
        shapeRenderer.end();
    }

    public void reposition(){
        int randX = random.nextInt(PlayState.NUMBER_CASES_WIDTH);
        int randY = random.nextInt(PlayState.NUMBER_CASES_HEIGHT);
        position.set(randX, randY);
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
