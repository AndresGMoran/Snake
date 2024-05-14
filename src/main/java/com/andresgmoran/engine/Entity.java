package com.andresgmoran.engine;

import com.andresgmoran.engine.math.MathUtils;
import com.andresgmoran.engine.math.Vector2;

import java.awt.image.BufferedImage;

public abstract class Entity {
    private static int idAutoincrement;
    private final int id;
    private final Vector2 position;
    private final float width;
    private final float height;
    private float hp;
    private float damage;
    private Collider collider;
    private BufferedImage sprite;

    public Entity(float x, float y, float width, float height, float hp, float damage,
                  float colliderXRight, float colliderXLeft,float colliderYUp, float colliderYDown, int colliderMask,
                  BufferedImage sprite) {
       this(x,y,width,height,hp,damage,sprite);
       this.collider = new Collider(colliderXRight,colliderXLeft,colliderYUp,colliderYDown,colliderMask);
    }
    public Entity(float x, float y, float width, float height, float hp, float damage,
                  float colliderOffSet, int colliderMask, BufferedImage sprite) {
        this(x,y,width, height, hp,damage,colliderOffSet,colliderOffSet,colliderOffSet,colliderOffSet,colliderMask,sprite);
    }
    public Entity(float x, float y, float width, float height, float hp, float damage,
                  float colliderOffSetX, float colliderOffSetY, int colliderMask, BufferedImage sprite) {
        this(x,y,width, height, hp,damage,colliderOffSetX,colliderOffSetX,colliderOffSetY,colliderOffSetY,colliderMask,sprite);
    }
    public Entity(float x, float y, float width, float height, float hp, float damage,
                  BufferedImage sprite) {
        this. id = ++idAutoincrement;
        this.position = new Vector2(x,y);
        this.width = width;
        this.height = height;
        this.hp = hp;
        this.damage = damage;
        this.collider = null;
        this.sprite = sprite;
    }
    public Entity(float x, float y, float width, float height, float hp, float damage) {
        this(x,y,width,height,hp,damage, null);
    }

    public static int getIdAutoincrement() {
        return idAutoincrement;
    }

    public int getId() {
        return id;
    }

    public Vector2 getPosition() {
        return position;
    }
    public float getX(){
        return position.getX();
    }
    public float getY(){
        return position.getY();
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getHp() {
        return hp;
    }

    public float getDamage() {
        return damage;
    }

    public Collider getCollider() {
        return collider;
    }

    public BufferedImage getSprite() {
        return sprite;
    }
    public void setCollider(float colliderXRight, float colliderXLeft,float colliderYUp, float colliderYDown, int colliderMask){
        if (collider == null){
            collider = new Collider(colliderXRight,colliderXLeft,colliderYUp,colliderYDown,colliderMask);
        }else {
            collider.setxRight(colliderXRight);
            collider.setxLeft(colliderXLeft);
            collider.setyUp(colliderYUp);
            collider.setyDown(colliderYDown);
        }
    }
    public void setCollider(float colliderX, float colliderY, int colliderMask){
        setCollider(colliderX,colliderY,colliderMask);
    }
    public void setCollider(float colliderOffSet, int colliderMask){
        setCollider(colliderOffSet,colliderOffSet, colliderMask);
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
    public void setPosition(float x, float y){
        position.setX(x);
        position.setY(y);
    }
    public void setDamage(float damage){
        this.damage = damage;
    }
    public void hit(Entity e){
        hit(e,damage);

    }
    public void hit(Entity e, float damage){
        e.hp -= damage;
        e.hp = MathUtils.clamp(e.hp,0);
    }
    public abstract void update(double deltaTime);
    public abstract void lastUpdate(double deltaTime);
    public abstract void postUpdate(double deltaTime);
}
