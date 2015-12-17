package com.owen.tetris.config;

import org.dom4j.DocumentException;

/**
 * Created by mike on 15/12/17.
 */
public class ConfigFactory {

    private static GameConfig GAME_CONFIG;

    static {
        try {
            GAME_CONFIG = new GameConfig();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static GameConfig getGameConfig() {
        return GAME_CONFIG;
    }

}
