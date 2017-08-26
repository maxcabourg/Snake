package states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import states.GameStateManager;

/**
 * Created by MAX on 19/08/2017.
 */

public abstract class State {

    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float deltaTime);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();

}
