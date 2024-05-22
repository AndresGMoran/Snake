package com.andresgmoran.engine.core;

import com.andresgmoran.engine.graphics.RenderAPI;

public abstract class Game implements Runnable, Updatable {
    private final int width;
    private final int height;
    private float fpsLimit;
    private float updateLimit;
    private Thread thread;
    private boolean finished;
    private RenderAPI renderAPI;

    public Game(int width, int height, float fpsLimit, float updateLimit, int maxEntities) {
        this.width = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.updateLimit = updateLimit;
        this.finished = false;
        Blackboard.entityManager = createEntityManager(maxEntities);
    }
    public void setRenderAPI(RenderAPI renderAPI){
        this.renderAPI = renderAPI;
    }
    public abstract EntityManager createEntityManager(int maxEntities);

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        final long NANO_IN_SECOND = 1_000_000_000;
        final double NANOS_BETWEEN_UPDATES = 1_000_000_000 / fpsLimit;
        long currentFrame;
        long lastFrame = currentFrame = System.nanoTime();
        long lastUpdateFrame = lastFrame = System.nanoTime();
        double deltaTime;
        System.out.println("Iniciando hilo ...");
        while (!finished) {
            currentFrame = System.nanoTime();
            deltaTime = (double)(currentFrame - lastFrame) / NANO_IN_SECOND;
            if (updateLimit > 0) {
                double nanosBetweenUpdates = NANO_IN_SECOND / updateLimit;
                if (currentFrame - lastUpdateFrame >= nanosBetweenUpdates) {
                    updateGame(deltaTime);
                    lastUpdateFrame = currentFrame;
                }
            } else {
                updateGame(deltaTime);
            }

            if (fpsLimit > 0) {
                double nanosBetweenFrames = NANO_IN_SECOND / fpsLimit;
                if (currentFrame - lastFrame > nanosBetweenFrames) {
                    render();
                    lastFrame = currentFrame;
                }
            } else {
                render();
                lastFrame = currentFrame;
            }
        }
    }
    private void updateGame(double deltaTime) {
        processInput();
        update(deltaTime);
        postUpdate(deltaTime);
        lastUpdate(deltaTime);
    }

    private void render() {
        renderAPI.render();
    }

    @Override
    public void update(double deltaTime) {
        Blackboard.entityManager.update(deltaTime);
    }

    @Override
    public void lastUpdate(double deltaTime) {
        Blackboard.entityManager.update(deltaTime);
    }

    @Override
    public void postUpdate(double deltaTime) {
        Blackboard.entityManager.update(deltaTime);
    }

    private void processInput() {
        Blackboard.entityManager.processInput();
    }
}
