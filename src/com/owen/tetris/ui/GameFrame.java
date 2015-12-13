package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/13.
 */
public class GameFrame extends JFrame {

    public GameFrame() {
        this.setTitle("Java俄罗斯方块");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 700);
        this.setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = (screen.width - this.getWidth()) >> 1;
        int y = (screen.height - this.getHeight()) >> 1;
        this.setLocation(x, y);
        this.setContentPane(new PanelGame());
    }

}
