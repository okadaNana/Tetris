package com.owen.tetris.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * XML配置文件读取器
 *
 * Created by mike on 15/12/16.
 */
public class ConfigReader {

    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read("config" + File.separator + "cfg.xml");

            Element game = doc.getRootElement();
            GameConfig gameConfig = new GameConfig();

            Element frame = game.element("frame");
            FrameConfig frameConfig = new FrameConfig();
            frameConfig.setWidht(Integer.parseInt(frame.attributeValue("width")));
            frameConfig.setHeight(Integer.parseInt(frame.attributeValue("height")));
            frameConfig.setPadding(Integer.parseInt(frame.attributeValue("padding")));
            frameConfig.setWindowSize(Integer.parseInt(frame.attributeValue("windowSize")));
            gameConfig.setFrameConfig(frameConfig);

            List<LayerConfig> layerConfigs = new ArrayList<>();
            List<Element> layers = frame.elements("layer");
            for (Element layer : layers) {
                LayerConfig layerConfig = new LayerConfig();

                layerConfig.setClassName(layer.attributeValue("className"));
                layerConfig.setX(Integer.parseInt(layer.attributeValue("x")));
                layerConfig.setY(Integer.parseInt(layer.attributeValue("y")));
                layerConfig.setW(Integer.parseInt(layer.attributeValue("w")));
                layerConfig.setH(Integer.parseInt(layer.attributeValue("h")));

                layerConfigs.add(layerConfig);
            }
            gameConfig.setLayerConfig(layerConfigs);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
