package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 显示"下一个方块"的窗口
 *
 * Created by mike on 15/12/15.
 */
public class LayerNext extends Layer {

    public LayerNext(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        drawImageAtCenter(Img.NEXT_ACT[this.dto.getNext()], g);
    }

}
