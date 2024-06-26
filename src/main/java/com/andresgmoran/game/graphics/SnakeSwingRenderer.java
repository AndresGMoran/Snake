package com.andresgmoran.game.graphics;

import com.andresgmoran.engine.core.Blackboard;
import com.andresgmoran.engine.core.ResizeListener;
import com.andresgmoran.engine.entities.Entity;
import com.andresgmoran.engine.graphics.swing.SwingRender;
import com.andresgmoran.game.config.Settings;

import java.awt.*;

public class SnakeSwingRenderer extends SwingRender {
    public SnakeSwingRenderer(int width, int height, ResizeListener resizeListener) {
        super(width, height, resizeListener);
    }

    @Override
    public void drawEntity(Graphics2D g2, Entity e) {
        g2.setColor(Color.ORANGE);
        g2.fillRect((int)e.getX(), (int)e.getY(), (int)e.getWidth(), (int)e.getHeight());
    }

    @Override
    public void drawBackground(Graphics2D g2) {
        g2.setColor(Settings.COLOR_BACKGROUND);
        g2.fillRect(0, 0, getWidth(), getHeight());
        for (int row = 0; row < Settings.ROWS; row++) {
            for (int col = 0; col < Settings.COLS; col++) {
                g2.setColor(Settings.COLOR_BACKGROUND_LINES);
                g2.drawRect(col * Blackboard.cellSize, row * Blackboard.cellSize, Blackboard.cellSize, Blackboard.cellSize);
            }
        }
    }
}
