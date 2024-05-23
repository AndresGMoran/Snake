package com.andresgmoran.engine.entities;

import com.andresgmoran.engine.input.KeyBoardManager;
import com.andresgmoran.engine.math.Vector2;

import java.awt.image.BufferedImage;

public class DynamicEntity extends Entity{
    private Vector2 velocity;
    private float linearVelocity;
    private float acceleration;

    public DynamicEntity(float x, float y, float width, float height, float hp, float damage,
                         float colliderXLeft, float colliderXRight, float colliderYUp, float colliderYDown, int colliderMask,
                         BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration ) {
        super(x, y, width, height, hp, damage, colliderXLeft, colliderXRight, colliderYUp, colliderYDown, colliderMask, sprite);
        initDynamicEntity(velocityX, velocityY, linearVelocity, acceleration);
    }

    private void initDynamicEntity( float velocityX, float velocityY, float linearVelocity, float acceleration) {
        this.velocity = new Vector2(velocityX, velocityY);
        this.linearVelocity = linearVelocity;
        this.acceleration = acceleration;
    }

    public DynamicEntity(float x, float y, float width, float height, float hp, float damage,
                         float colliderOffset, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration) {
        this(x, y, width, height, hp, damage, colliderOffset, colliderOffset, colliderOffset, colliderOffset, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration);
    }

    public DynamicEntity(float x, float y, float width, float height, float hp, float damage,
                         float colliderOffsetX, float colliderOffsetY, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration) {
        this(x, y, width, height, hp, damage, colliderOffsetX, colliderOffsetX, colliderOffsetY, colliderOffsetY, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration);
    }

    public DynamicEntity(float x, float y, float width, float height, float hp, float damage, BufferedImage sprite,  float velocityX, float velocityY, float linearVelocity, float acceleration) {
        super(x, y, width, height, hp, damage, sprite);
        initDynamicEntity(velocityX, velocityY, linearVelocity, acceleration);
    }

    @Override
    public void update(double deltaTime) {
        linearVelocity += (float) (acceleration * deltaTime);

    }

    @Override
    public void lastUpdate(double deltaTime) {

    }

    @Override
    public void postUpdate(double deltaTime) {

    }
}
