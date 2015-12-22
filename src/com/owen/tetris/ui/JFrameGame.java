package com.owen.tetris.ui;

import com.owen.tetris.config.ConfigFactory;
import com.owen.tetris.config.GameConfig;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/13.
 */
public class JFrameGame extends JFrame {

    public JFrameGame(JPanelGame panel) {
        GameConfig cfg = ConfigFactory.getGameConfig();

        this.setTitle(cfg.getTitle());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(cfg.getWidth(), cfg.getHeight());
        this.setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = (screen.width - this.getWidth()) >> 1;  // 先乘除,后加减,再位移
        int y = ((screen.height - this.getHeight()) >> 1) - cfg.getWindowUp();
        this.setLocation(x, y);
        this.setContentPane(new JPanelGame());
        this.setVisible(true);
    }

}
