package com.andresgmoran.game.core;

import com.andresgmoran.engine.core.Blackboard;
import com.andresgmoran.engine.core.EntityManager;
import com.andresgmoran.engine.core.Game;
import com.andresgmoran.engine.input.KeyBoardManager;
import com.andresgmoran.engine.math.Vector2;
import com.andresgmoran.game.config.Settings;
import com.andresgmoran.game.entities.Snake;
import com.andresgmoran.game.entities.SnakeFragment;
import com.andresgmoran.game.utils.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame extends Game {
    private final int rows;
    private final int cols;
    private final SnakeEntityManager entityManager;
    private final Random random;
    private final Snake snake;
    private final List<Vector2> emptyCells;

    public SnakeGame(int width, int height, int rows, int cols, float fpsLimit, float upsLimit, int maxEntities) {
        super(width, height, fpsLimit, upsLimit, maxEntities);
        this.rows = rows;
        this.cols = cols;
        this.random = new Random();
        entityManager = (SnakeEntityManager) Blackboard.entityManager;
        snake = entityManager.createSnake(width / 2, height / 2, Direction.RIGHT,
                new KeyBoardManager('w', 's', 'a', 'd', 'm', 'j'));

        int capacity = Settings.ROWS * Settings.COLS - 1;
        emptyCells = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            emptyCells.add(new Vector2(-1, -1));
        }
    }

    private void spawnFood() {
        List<SnakeFragment> fragments = snake.getFragments();


    }

    @Override
    public EntityManager createEntityManager(int maxEntities) {
        return new SnakeEntityManager(maxEntities);
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void gameResized() {
        Blackboard.cellSize = getWidth() < getHeight() ? getWidth() / cols : getHeight() / rows;
    }
}
