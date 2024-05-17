package com.andresgmoran;

import com.andresgmoran.engine.graphics.LibUI;
import com.andresgmoran.game.config.Settings;
import com.andresgmoran.game.core.SnakeGame;
import com.andresgmoran.game.graphics.SnakeSwingRenderer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(Settings.WIDTH, Settings.HEIGHT, Settings.ROWS, Settings.COLS, Settings.TARGET_FPS);
        SnakeSwingRenderer snakeSwingRenderer = new SnakeSwingRenderer(Settings.WIDTH, Settings.HEIGHT);
        snakeGame.setRenderAPI(snakeSwingRenderer);
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Snake");
        frame.add(snakeSwingRenderer);
        frame.pack();
        LibUI.setMonitor(frame, 1);
        frame.setVisible(true);
        snakeGame.start();
    }
}