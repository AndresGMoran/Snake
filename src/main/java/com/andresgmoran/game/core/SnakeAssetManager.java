package com.andresgmoran.game.core;

import com.andresgmoran.engine.core.AssetManager;

public class SnakeAssetManager extends AssetManager {

    @Override
    public void loadAll() {
        loadSprite("player", "/sprites/snake.jpg");
        loadSprite("food", "/sprites/snake.jpg");
    }
}
