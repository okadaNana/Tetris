package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/15.
 */
public class LayerLevel extends Layer {

    private static final Image IMG_LEVEL = new ImageIcon("graphics/string/level.png").getImage();

    public LayerLevel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        g.drawImage(IMG_LEVEL, this.x + PADDING, this.y + PADDING, null);
    }

}
