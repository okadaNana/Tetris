package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/15.
 */
public class LayerBackground extends Layer {

    private static final Image IMG_BG = new ImageIcon("graphics/background/bg01.jpg").getImage();

    public LayerBackground(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    protected void paint(Graphics g) {
        g.drawImage(IMG_BG, 0, 0, 1162, 654, null);
    }

}
