package com.andresgmoran.game.entities;

import com.andresgmoran.engine.entities.Entity;
import com.andresgmoran.engine.entities.PlayableEntity;
import com.andresgmoran.engine.input.KeyBoardManager;
import com.andresgmoran.game.config.Settings;
import com.andresgmoran.game.utils.Direction;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Snake extends PlayableEntity {
    private final List<SnakeFragment> fragments;


    public Snake(float x, float y, float width, float height, float hp, float damage, float colliderOffset, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration, KeyBoardManager keyboardManager) {
        super(x, y, width, height, hp, damage, colliderOffset, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration, keyboardManager);
        fragments = new ArrayList<>(Settings.COLS * Settings.ROWS - 1);
    }

    public List<SnakeFragment> getFragments() {
        return fragments;
    }

    @Override
    public void processInput() {
        KeyBoardManager km = getKeyBoardManager();
        if (km.isUp()) {
            setDirection(Direction.UP);
        } else if (km.isDown()) {
            setDirection(Direction.DOWN);
        }
        if (km.isLeft()) {
            setDirection(Direction.LEFT);
        } else if (km.isRight()) {
            setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void lastUpdate(double deltaTime) {

    }

    @Override
    public void postUpdate(double deltaTime) {

    }
}
