package com.andresgmoran.game.core;

import com.andresgmoran.engine.core.Blackboard;
import com.andresgmoran.engine.core.EntityManager;
import com.andresgmoran.engine.core.Game;
import com.andresgmoran.game.config.Settings;

public class SnakeGame extends Game {
    private final int rows;
    private final int cols;
    private final SnakeEntityManager entityManager;

    public SnakeGame(int width, int height, int rows, int cols, float fpsLimit) {
        super(width, height, fpsLimit);
        this.rows = rows;
        this.cols = cols;
        entityManager = (SnakeEntityManager) Blackboard.entityManager;
    }

    @Override
    public EntityManager createEntityManager() {
        return new SnakeEntityManager(Settings.MAX_ENTITIES);
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);
    }
}
