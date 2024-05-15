package com.andresgmoran.engine.core;

import com.andresgmoran.engine.graphics.RenderAPI;

public abstract class Game implements Runnable, Updatable {
    private final int width;
    private final int height;
    private final float fpsLimit;
    private Thread thread;
    private boolean finished;
    private RenderAPI renderAPI;

    public Game(int width, int height, float fpsLimit) {
        this.width = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.finished = false;
        Blackboard.entityManager = createEntityManager();
    }
    public void setRenderAPI(RenderAPI renderAPI){
        this.renderAPI = renderAPI;
    }
    public abstract EntityManager createEntityManager();

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
        double deltaTime;
        System.out.println("Iniciando hilo ...");
        while (!finished) {
            currentFrame = System.nanoTime();
            deltaTime = (double)(currentFrame - lastFrame) / NANO_IN_SECOND;
            if (currentFrame - lastFrame > NANOS_BETWEEN_UPDATES) {
                processInput();
                update(deltaTime);
                postUpdate(deltaTime);
                lastUpdate(deltaTime);
                render();
                lastFrame = currentFrame;
            }
        }
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
