package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 显示"下一个方块"的窗口
 *
 * Created by mike on 15/12/15.
 */
public class LayerNext extends Layer {

    private static final Image[] NEXT_ACT;

    static {
        NEXT_ACT = new Image[7];
        for (int i = 0; i < NEXT_ACT.length; i++) {
            NEXT_ACT[i] = new ImageIcon("graphics/game/" + i + ".png").getImage();
        }
    }

    public LayerNext(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        drawImageAtCenter(NEXT_ACT[this.dto.getNext()], g);
    }

}
