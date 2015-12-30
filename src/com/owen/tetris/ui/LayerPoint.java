package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 分数窗口
 *
 * Created by mike on 15/12/15.
 */
public class LayerPoint extends Layer {

    /**
     * 标题图片(分数)
     */
    private static final Image IMG_POINT = new ImageIcon("graphics/string/point.png").getImage();

    private static final int POINT_Y = PADDING;

    /**
     * 标题图片(消行)
     */
    private static final Image IMG_RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();

    /**
     * 标题图片(消行)的高度
     */
    private static final int IMG_RMLINE_H = IMG_RMLINE.getHeight(null);

    private static final int IMG_RMLINE_Y =  IMG_RMLINE_H + (PADDING << 1);

    /**
     * 分数最大位数
     */
    private static final int POINT_BIT = 5;

    private static int POINT_X;

    public LayerPoint(int x, int y, int w, int h) {
        super(x, y, w, h);
        // 初始化分数显示的x坐标
        POINT_X = this.w - IMG_NUMBER_W * POINT_BIT - PADDING;
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        // 窗口标题文字(分数)
        g.drawImage(IMG_POINT, this.x + PADDING, this.y + POINT_Y, null);
        this.drawNumber(POINT_X, POINT_Y, this.dto.getNowPoint(), POINT_BIT, g);
        // 窗口标题文字(消行)
        g.drawImage(IMG_RMLINE, this.x + PADDING, this.y + IMG_RMLINE_Y, null);
        this.drawNumber(POINT_X, IMG_RMLINE_Y, this.dto.getNowRemoveLine(), POINT_BIT, g);
    }

}
