package com.andresgmoran.engine.entities;

import com.andresgmoran.engine.input.KeyBoardManager;
import com.andresgmoran.engine.math.Vector2;
import com.andresgmoran.game.utils.Direction;

import java.awt.image.BufferedImage;

public abstract class PlayableEntity extends DynamicEntity{
    private final KeyBoardManager keyBoardManager;
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderXRight, float colliderXLeft, float colliderYUp, float colliderYDown, int colliderMask,
                          BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration, KeyBoardManager keyBoardManager) {
        super(x,y,width,height,hp,damage,colliderXRight, colliderXLeft,colliderYUp,colliderYDown, colliderMask,sprite,velocityX,velocityY,linearVelocity,acceleration);
        this.keyBoardManager = keyBoardManager;
    }
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderOffSet, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration, KeyBoardManager keyBoardManager) {
        this(x,y,width, height, hp,damage,colliderOffSet,colliderOffSet,colliderOffSet,colliderOffSet,colliderMask,sprite, velocityX,velocityY,linearVelocity,acceleration, keyBoardManager);
    }
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderOffSetX, float colliderOffSetY, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration, KeyBoardManager keyBoardManager) {
        this(x,y,width, height, hp,damage,colliderOffSetX,colliderOffSetX,colliderOffSetY,colliderOffSetY,colliderMask,sprite, velocityX,velocityY,linearVelocity,acceleration, keyBoardManager);
    }
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration, KeyBoardManager keyBoardManager) {
        super(x,y,width,height,hp,damage,sprite, velocityX,velocityY,linearVelocity,acceleration);
        this.keyBoardManager = keyBoardManager;
    }
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage, float velocityX, float velocityY, float linearVelocity, float acceleration, KeyBoardManager keyBoardManager) {
        this(x,y,width,height,hp,damage, null, velocityX,velocityY,linearVelocity,acceleration, keyBoardManager);
    }

    public KeyBoardManager getKeyBoardManager() {
        return keyBoardManager;
    }
    public void setDirection(Direction direction) {
        setVelocity(direction.getDirection().getX(), direction.getDirection().getY());
    }

    public abstract void processInput();

}