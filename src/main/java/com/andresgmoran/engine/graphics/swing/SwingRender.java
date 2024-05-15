package com.andresgmoran.engine.graphics.swing;

import com.andresgmoran.engine.graphics.RenderAPI;

import javax.swing.*;
import java.awt.*;

public class SwingRender extends JPanel implements RenderAPI {
    public SwingRender(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setDoubleBuffered(true);
        setFocusable(true);
    }

    @Override
    public void render() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
