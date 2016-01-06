package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/15.
 */
public class LayerAbout extends Layer {

    private static final Image IMG_SIGN = new ImageIcon("graphics/string/sign.png").getImage();

    public LayerAbout(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        this.drawImageAtCenter(IMG_SIGN, g);
    }

}
