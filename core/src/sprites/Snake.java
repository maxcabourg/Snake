package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.snake.SnakeGame;
import states.PlayState;

import java.util.LinkedList;
import java.util.Random;

public class Snake extends Sprite {
    public enum Direction{
        BOTTOM, TOP, LEFT, RIGHT
    }

    public static Direction LAST_DIRECTION;
    private LinkedList<SnakeCase> body;
    private Random random;

    public Snake(){
        body = new LinkedList<>();
        random = new Random();
        int randX = random.nextInt((PlayState.NUMBER_CASES_WIDTH - 2) - 2) + 2;
        int randY = random.nextInt((PlayState.NUMBER_CASES_HEIGHT - 2) - 2) + 2;
        body.addLast(new SnakeCase(randX, randY));
        body.addLast(new SnakeCase(randX - 1, randY));
        body.addLast(new SnakeCase(randX - 2, randY));
        LAST_DIRECTION = Direction.RIGHT;
    }
    @Override
    public void render() {
        for(SnakeCase snakeCase: body){
            snakeCase.render();
        }
    }

    @Override
    public void update() {
        if(isOnApple()){
            eatApple();
        }
        handleInput();
        for(int i = 0; i < body.size() - 1; i++){
            body.get(i).position.x = body.get(i+1).position.x;
            body.get(i).position.y = body.get(i+1).position.y;
        }
        switch(LAST_DIRECTION){
            case RIGHT:
                body.getLast().position.add(1, 0);
                break;
            case LEFT:
                body.getLast().position.add(-1, 0);
                break;
            case TOP:
                body.getLast().position.add(0, 1);
                break;
            case BOTTOM:
                body.getLast().position.add(0, -1);
                break;
        }
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if(LAST_DIRECTION != Direction.BOTTOM && LAST_DIRECTION != Direction.TOP){ //Ne rien faire si le serpent allait vers le bas lorsque l'utilisateur appuie sur UP
                LAST_DIRECTION = Direction.TOP;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(LAST_DIRECTION != Direction.BOTTOM && LAST_DIRECTION != Direction.TOP){
                LAST_DIRECTION = Direction.BOTTOM;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(LAST_DIRECTION != Direction.RIGHT && LAST_DIRECTION != Direction.LEFT){
                LAST_DIRECTION = Direction.LEFT;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(LAST_DIRECTION != Direction.RIGHT && LAST_DIRECTION != Direction.LEFT){
                LAST_DIRECTION = Direction.RIGHT;
            }
        }
    }

    @Override
    public void dispose() {
        for(SnakeCase snakeCase: body){
            snakeCase.dispose();
        }
    }

    private boolean isOnApple(){
        return body.getLast().position.equals(PlayState.getApple().position);
    }

    private void eatApple(){
        body.addFirst(new SnakeCase((int)body.getFirst().position.x, (int)body.getFirst().position.y));
        PlayState.getApple().reposition();
    }

    /**
     * Indique si le serpent se mord la queue
     * @return true si le serpent se mord la queue, false sinon
     */
    public boolean bitesTail(){
        boolean bitesTail = false;
        for(int i = 0; i < body.size() - 2; i++){
            if(body.get(i).position.equals(body.getLast().position))
                bitesTail = true;
        }
        return bitesTail;
    }

    /**
     * Indique si le serpent est en dehors de l'écran
     * @return true si le serpent est en dehors de l'écran, false sinon
     */
    public boolean collapsesScreen(){
        return body.getLast().position.x > PlayState.NUMBER_CASES_WIDTH - 1 || body.getLast().position.x < 0 || body.getLast().position.y > PlayState.NUMBER_CASES_HEIGHT - 1 || body.getLast().position.y < 0;
    }

}
