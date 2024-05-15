package com.andresgmoran.engine.entities;

import com.andresgmoran.engine.input.KeyBoardManager;
import com.andresgmoran.engine.math.Vector2;

import java.awt.image.BufferedImage;

public abstract class PlayableEntity extends Entity{
    private final KeyBoardManager keyBoardManager;
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderXRight, float colliderXLeft, float colliderYUp, float colliderYDown, int colliderMask,
                          BufferedImage sprite, KeyBoardManager keyBoardManager) {
        super(x,y,width,height,hp,damage,colliderXRight, colliderXLeft,colliderYUp,colliderYDown, colliderMask,sprite);
        this.keyBoardManager = keyBoardManager;
    }
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderOffSet, int colliderMask, BufferedImage sprite, KeyBoardManager keyBoardManager) {
        super(x,y,width, height, hp,damage,colliderOffSet,colliderOffSet,colliderOffSet,colliderOffSet,colliderMask,sprite);
        this.keyBoardManager = keyBoardManager;
    }
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderOffSetX, float colliderOffSetY, int colliderMask, BufferedImage sprite, KeyBoardManager keyBoardManager) {
        super(x,y,width, height, hp,damage,colliderOffSetX,colliderOffSetX,colliderOffSetY,colliderOffSetY,colliderMask,sprite);
        this.keyBoardManager = keyBoardManager;
    }
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          BufferedImage sprite, KeyBoardManager keyBoardManager) {
        super(x,y,width,height,hp,damage,sprite);
        this.keyBoardManager = keyBoardManager;
    }
    public PlayableEntity(float x, float y, float width, float height, float hp, float damage, KeyBoardManager keyBoardManager) {
        super(x,y,width,height,hp,damage, null);
        this.keyBoardManager = keyBoardManager;
    }
    public abstract void processInput();
    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void lastUpdate(double deltaTime) {

    }

    @Override
    public void postUpdate(double deltaTime) {

    }
}