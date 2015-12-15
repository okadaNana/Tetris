package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/15.
 */
public class LayerDataBase extends Layer {

    private static final Image IMG_DB = new ImageIcon("graphics/string/db.png").getImage();

    public LayerDataBase(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        g.drawImage(IMG_DB, this.x + PADDING, this.y + PADDING, null);
    }

}
