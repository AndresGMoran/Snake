package com.andresgmoran.game.graphics;

import com.andresgmoran.engine.entities.Entity;
import com.andresgmoran.engine.graphics.swing.SwingRender;

import java.awt.*;

public class SnakeSwingRenderer extends SwingRender {
    public SnakeSwingRenderer(int width, int height) {
        super(width, height);
    }

    @Override
    public void drawEntity(Graphics2D g2, Entity e) {
        g2.setColor(Color.ORANGE);
        g2.fillRect((int)e.getX(), (int)e.getY(), (int)e.getWidth(), (int)e.getHeight());
    }

    @Override
    public void drawBackground(Graphics2D g2) {
        g2.setColor(Color.gray);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
