package states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.snake.SnakeGame;
import sprites.Apple;
import sprites.Snake;

public class PlayState extends State {
    public static int NUMBER_CASES_WIDTH = 20;
    public static int NUMBER_CASES_HEIGHT = 20;
    public static int CASE_WIDTH = SnakeGame.WIDTH  / NUMBER_CASES_WIDTH;
    public static int CASE_HEIGHT = SnakeGame.HEIGHT / NUMBER_CASES_HEIGHT;

    private Snake snake;
    private static Apple apple;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        snake = new Snake();
        apple = new Apple();
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {
        if(snake.bitesTail() || snake.collapsesScreen()){
            gsm.set(new PlayState(gsm));
        }
        else{
            snake.update();
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        snake.render();
        apple.render();
    }

    @Override
    public void dispose() {

    }

    public static Apple getApple() {
        return apple;
    }
}
