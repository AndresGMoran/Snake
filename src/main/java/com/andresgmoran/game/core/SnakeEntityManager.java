package com.andresgmoran.game.core;

import com.andresgmoran.engine.core.AssetManager;
import com.andresgmoran.engine.core.EntityManager;

public class SnakeEntityManager extends EntityManager {
    public SnakeEntityManager(int maxEntities) {
        super(maxEntities);
    }

    @Override
    public AssetManager createAssetManager() {
        return new SnakeAssetManager();
    }
}
