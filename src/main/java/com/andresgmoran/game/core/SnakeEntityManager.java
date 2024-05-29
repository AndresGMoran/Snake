package com.andresgmoran.game.core;

import com.andresgmoran.engine.core.AssetManager;
import com.andresgmoran.engine.core.Blackboard;
import com.andresgmoran.engine.core.EntityManager;
import com.andresgmoran.engine.input.KeyBoardManager;
import com.andresgmoran.game.ColliderMask;
import com.andresgmoran.game.config.Settings;
import com.andresgmoran.game.entities.Food;
import com.andresgmoran.game.entities.Snake;
import com.andresgmoran.game.utils.Direction;

public class SnakeEntityManager extends EntityManager {
    private Food food;

    public SnakeEntityManager(int maxEntities) {
        super(maxEntities);
        food = new Food(0, 0, Blackboard.cellSize, Blackboard.cellSize, 1, 0, Settings.FOOD_COLLIDER_OFFSET,
                ColliderMask.LAYER_FOOD, getAssetManager().getSprite("food"));
        // getAssetManager().getSound("shoot").play();
    }

    @Override
    public AssetManager createAssetManager() {
        return new SnakeAssetManager();
    }

    public Snake createSnake(float x, float y, Direction direction, KeyBoardManager keyboardManager) {
        Snake snake = new Snake(x, y, Blackboard.cellSize, Blackboard.cellSize, Settings.SNAKE_HP, Settings.SNAKE_DAMAGE, Settings.SNAKE_COLLIDER_OFFSET,
                ColliderMask.LAYER_SNAKE, getAssetManager().getSprite("player"), direction.getDirection().getX(), direction.getDirection().getY(), Blackboard.cellSize, 0, keyboardManager);
        addEntity(snake);
        return snake;
    }

    public Food spawnFood(float x, float y) {
        food.setPosition(x, y);
        addEntity(food);
        return food;
    }
}
