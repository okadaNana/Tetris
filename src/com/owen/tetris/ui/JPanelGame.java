package com.owen.tetris.ui;

import com.owen.tetris.config.ConfigFactory;
import com.owen.tetris.config.GameConfig;
import com.owen.tetris.config.LayerConfig;
import com.owen.tetris.control.GameControl;
import com.owen.tetris.control.PlayerControl;
import com.owen.tetris.dto.GameDto;
import com.owen.tetris.service.GameService;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by mike on 15/12/13.
 */
public class JPanelGame extends JPanel {

    private List<Layer> layers;

    private GameDto dto;

    public JPanelGame(GameDto dto) {
        // 获得 dto 对象
        this.dto = dto;
        initComponent();
        initLayer();
    }

    /**
     * 安装玩家控制器
     */
    public void setPlayerControl(PlayerControl playerControl) {
       this.addKeyListener(playerControl);
    }

    /**
     * 初始化组件
     */
    private void initComponent() {
    }

    /**
     * 初始化层
     */
    private void initLayer() {
        try {
            GameConfig cfg = ConfigFactory.getGameConfig();
            List<LayerConfig> layersCfg = cfg.getLayerConfig();
            layers = new ArrayList<>(cfg.getLayerConfig().size());
            for (LayerConfig layerCfg : layersCfg) {
                Class<?> cls = Class.forName(layerCfg.getClassName());
                Constructor ctr = cls.getConstructor(int.class, int.class, int.class, int.class);
                Layer layer = (Layer) ctr.newInstance(
                        layerCfg.getX(),
                        layerCfg.getY(),
                        layerCfg.getW(),
                        layerCfg.getH()
                );
                // 设置游戏数据对象
                layer.setDto(dto);

                layers.add(layer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 绘制游戏界面
        for (int i = 0; i < layers.size(); layers.get(i++).paint(g));
        this.requestFocus();
    }


}
