package com.andresgmoran.engine.core;

import com.andresgmoran.engine.entities.Entity;
import com.andresgmoran.engine.entities.PlayableEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityManager implements Updatable{
    private final Entity[] entities;
    private int numEntities;
    private final List<PlayableEntity> playableEntities;

    public EntityManager(int maxEntities) {
        entities = new Entity[maxEntities];
        numEntities = 0;
        playableEntities = new ArrayList<>();
    }

    public boolean addEntity(Entity entity) {
        if (numEntities < entities.length) {
            entities[numEntities++] = entity;
            if (entity instanceof PlayableEntity) {
                playableEntities.add((PlayableEntity) entity);
            }
            return true;
        }
        return false;
    }

    public void removeEntity(Entity entity) {
        for (int i = 0; i < numEntities; i++) {
            Entity other = entities[i];
            if (entity.equals(other)) {
                entities[i] = entities[numEntities - 1];
                entities[numEntities - 1] = other;
                numEntities--;
            }
        }
    }

    public Entity[] getEntities() {
        return entities;
    }

    public int getNumEntities() {
        return numEntities;
    }

    @Override
    public void update(double deltaTime) {
        for (int i = 0; i < numEntities; i++) {
            entities[i].update(deltaTime);
        }
    }

    @Override
    public void lastUpdate(double deltaTime) {
        for (int i = 0; i < numEntities; i++) {
            entities[i].lastUpdate(deltaTime);
        }
    }

    @Override
    public void postUpdate(double deltaTime) {
        for (int i = 0; i < numEntities; i++) {
            entities[i].postUpdate(deltaTime);
        }
    }

    public void processInput() {
        for (PlayableEntity playableEntity : playableEntities) {
            playableEntity.processInput();
        }
    }
}
