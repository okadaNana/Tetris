package com.owen.tetris.config;

import java.util.List;

/**
 * 游戏配置
 *
 * Created by mike on 15/12/16.
 */
public class GameConfig {

    private FrameConfig frameConfig;
    private List<LayerConfig> layerConfig;

    public FrameConfig getFrameConfig() {
        return frameConfig;
    }

    public void setFrameConfig(FrameConfig frameConfig) {
        this.frameConfig = frameConfig;
    }

    public List<LayerConfig> getLayerConfig() {
        return layerConfig;
    }

    public void setLayerConfig(List<LayerConfig> layerConfig) {
        this.layerConfig = layerConfig;
    }
}
