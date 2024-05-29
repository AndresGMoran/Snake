package com.andresgmoran.engine.core;

import com.andresgmoran.engine.entities.Entity;

public class Collider {
    private float xLeft;
    private float xRight;
    private float yDown;
    private float yUp;
    private int mask;

    private static Collider c1WorldCoords = new Collider();
    private static Collider c2WorldCoords = new Collider();
    private Collider() {}

    public Collider(float xLeft, float xRight, float yDown, float yUp, int mask) {
        this.xLeft = xLeft;
        this.xRight = xRight;
        this.yDown = yDown;
        this.yUp = yUp;
        this.mask = mask;
    }

    public float getxRight() {
        return xRight;
    }

    public float getxLeft() {
        return xLeft;
    }

    public float getyUp() {
        return yUp;
    }

    public float getyDown() {
        return yDown;
    }
    public int getMask() {
        return mask;
    }

    public void setxRight(float xRight) {
        this.xRight = xRight;
    }

    public void setxLeft(float xLeft) {
        this.xLeft = xLeft;
    }

    public void setyUp(float yUp) {
        this.yUp = yUp;
    }

    public void setyDown(float yDown) {
        this.yDown = yDown;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public static boolean checkCollision(Entity e1, Entity e2) {
        Collider c1 = e1.getCollider();
        Collider c2 = e2.getCollider();
        if (c1 == null || c2 == null) {
            return false;
        }
        if ((c1.mask & c2.mask) == 0){
            return false;
        }
        translateToWorldCoords(e1, c1WorldCoords);
        translateToWorldCoords(e2, c2WorldCoords);
        if (c2WorldCoords.xLeft > c1WorldCoords.xRight) {
            return false;
        }
        if (c1WorldCoords.xLeft > c2WorldCoords.xRight) {
            return false;
        }
        if (c1WorldCoords.yDown > c2WorldCoords.yUp) {
            return false;
        }
        if (c2WorldCoords.yDown > c1WorldCoords.yUp) {
            return false;
        }
        return true;
    }
    public static void translateToWorldCoords(Entity e, Collider c){
        Collider c1 = e.getCollider();

        c.xLeft = e.getX() + c1.xLeft;
        c.xRight = e.getX() + e.getWidth() - c1.xRight;
        c.yDown = e.getY() + e.getHeight() - c1.yDown;
        c.yUp = e.getY() + c1.yUp;
        c.mask = c1.getMask();
    }

    @Override
    public String toString() {
        return "Collider{" +
                "xRight=" + xRight +
                ", xLeft=" + xLeft +
                ", yUp=" + yUp +
                ", yDown=" + yDown +
                ", mask=" + mask +
                '}';
    }
}
