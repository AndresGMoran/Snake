package com.andresgmoran.engine.core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AssetManager {
    private final Map<String,BufferedImage> sprites;

    public AssetManager() {
        sprites = new HashMap<>();
    }

    public void loadSprite(String name, String path) {
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getResourceAsStream(path));
            sprites.put(name, bufferedImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getSprite(String name) {
        return sprites.get(name);
    }
}
