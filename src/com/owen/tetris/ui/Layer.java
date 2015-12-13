package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 0窗口
 *
 * Created by mike on 15/12/13.
 */
public class Layer {

    /**
     * 边框的宽度
     */
    private static final int SIZE = 7;

    /**
     * 窗口图片
     */
    private static final Image WINDOW_IMG = new ImageIcon("graphics/window/Window2.png").getImage();

    /**
     * 图片的宽度
     */
    private static final int WINDOW_W = WINDOW_IMG.getWidth(null);

    /**
     * 图片的高度
     */
    private static final int WINDOW_H = WINDOW_IMG.getHeight(null);

    /**
     * 窗口左上角 x 坐标
     */
    private int x;

    /**
     * 窗口左上角 y 坐标
     */
    private int y;

    /**
     * 窗口宽度
     */
    private int w;

    /**
     * 窗口高度
     */
    private int h;

    public Layer(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    /**
     * 绘制窗口
     */
    public void createWindow(Graphics g) {
        g.drawImage(WINDOW_IMG, x, y, x + SIZE, y + SIZE, 0, 0, SIZE, SIZE, null);
        g.drawImage(WINDOW_IMG, x + SIZE, y, x + w - SIZE, y + SIZE, SIZE, 0, WINDOW_W - SIZE, SIZE, null);
        g.drawImage(WINDOW_IMG, x + w - SIZE, y, x + w, y + SIZE, WINDOW_W - SIZE, 0, WINDOW_W, SIZE, null);
        g.drawImage(WINDOW_IMG, x, y + SIZE, x + SIZE, y + h - SIZE, 0, SIZE, SIZE, WINDOW_H - SIZE, null);
        g.drawImage(WINDOW_IMG, x + SIZE, y + SIZE, x + w - SIZE, y + h - SIZE, SIZE, SIZE, WINDOW_W - SIZE, WINDOW_H - SIZE, null);
        g.drawImage(WINDOW_IMG, x + w - SIZE, y + SIZE, x + w, y + h - SIZE, WINDOW_W - SIZE, SIZE, WINDOW_W, WINDOW_H - SIZE, null);
        g.drawImage(WINDOW_IMG, x, y + h - SIZE, x + SIZE, y + h, 0, WINDOW_H - SIZE, SIZE, WINDOW_H, null);
        g.drawImage(WINDOW_IMG, x + SIZE, y + h - SIZE, x + w - SIZE, y + h, SIZE, WINDOW_H - SIZE, WINDOW_W - SIZE, WINDOW_H, null);
        g.drawImage(WINDOW_IMG, x + w - SIZE, y + h - SIZE, x + w, y + h, WINDOW_W - SIZE, WINDOW_H - SIZE, WINDOW_W, WINDOW_H, null);
    }

}
