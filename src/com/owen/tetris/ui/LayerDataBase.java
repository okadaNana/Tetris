package com.owen.tetris.ui;

import com.sun.scenario.effect.impl.prism.PrImage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/15.
 */
public class LayerDataBase extends Layer {

    private static final int MAX_ROW = 5;

    /**
     * 起始 Y 坐标
     */
    private static int START_Y = 0;

    /**
     * 间距
     */
    private static int SPA = 0;

    private static final int RECT_H = IMG_RECT_H + 4;

    public LayerDataBase(int x, int y, int w, int h) {
        super(x, y, w, h);
        SPA = (this.h - RECT_H * 5 - (PADDING << 1) - Img.DB.getHeight(null)) / MAX_ROW;
        START_Y = PADDING + Img.DB.getHeight(null) + SPA;
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        g.drawImage(Img.DB, this.x + PADDING, this.y + PADDING, null);
        for (int i = 0; i < MAX_ROW; i++) {
            this.drawRect(START_Y + i * (RECT_H + SPA), "No Data", "", 0, 100, g);
        }
    }

}
