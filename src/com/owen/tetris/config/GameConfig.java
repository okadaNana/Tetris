package com.owen.tetris.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏配置
 *
 * Created by mike on 15/12/16.
 */
public class GameConfig {
    private int width;
    private int height;
    private int windowSize;
    private int padding;
    private List<LayerConfig> layerConfig;

    public GameConfig() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read("config/cfg.xml");
        Element game = doc.getRootElement();
        this.setUIConfig(game.element("frame"));
        this.setSystemConfig(game.element("system"));
        this.setDataConfig(game.element("data"));
    }

    /**
     * 配置窗口
     *
     * @param frame 配置文件的窗口配置元素
     */
    private void setUIConfig(Element frame) {
        this.width = Integer.parseInt(frame.attributeValue("width"));
        this.height = Integer.parseInt(frame.attributeValue("height"));
        this.padding = Integer.parseInt(frame.attributeValue("padding"));
        this.windowSize = Integer.parseInt(frame.attributeValue("windowSize"));

        List<Element> layers = frame.elements("layer");
        layerConfig = new ArrayList<>();
        for (Element layer : layers) {
            LayerConfig lc = new LayerConfig(
                    layer.attributeValue("className"),
                    Integer.parseInt(layer.attributeValue("x")),
                    Integer.parseInt(layer.attributeValue("y")),
                    Integer.parseInt(layer.attributeValue("w")),
                    Integer.parseInt(layer.attributeValue("h"))
            );
            layerConfig.add(lc);
        }
    }

    /**
     * 配置系统参数
     *
     * @param system
     */
    private void setSystemConfig(Element system) {
        // TODO
    }

    /**
     * 配置数据访问参数
     *
     * @param data
     */
    private void setDataConfig(Element data) {
        // TODO
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public int getPadding() {
        return padding;
    }

    public List<LayerConfig> getLayerConfig() {
        return layerConfig;
    }
}
