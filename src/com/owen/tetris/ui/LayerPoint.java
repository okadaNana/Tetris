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
     * 分数最大位数
     */
    private static final int POINT_BIT = 5;

    private static final int LEVEL_UP = 20;

    /**
     * 标题图片(分数)
     */
    private static final Image IMG_POINT = new ImageIcon("graphics/string/point.png").getImage();

    /**
     * 标题图片(消行)
     */
    private static final Image IMG_RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();

    /**
     * 标题图片(消行)的高度
     */
    private static final int IMG_RMLINE_H = IMG_RMLINE.getHeight(null);

    /**
     * 消行y坐标
     */
    private final int rmLineY;

    /**
     * 分数y坐标
     */
    private final int pointY;

    /**
     * 经验值y坐标
     */
    private final int expY;

    /**
     * 经验值槽宽度
     */
    private final int expW;

    /**
     * 分数x坐标
     */
    private int comX;

    public LayerPoint(int x, int y, int w, int h) {
        super(x, y, w, h);
        // 初始化共通x坐标
        this.comX = this.w - IMG_NUMBER_W * POINT_BIT - PADDING;
        // 初始化分数显示的y坐标
        this.pointY = PADDING;
        // 初始化消行显示的y坐标
        this.rmLineY =  this.pointY + IMG_POINT.getHeight(null) + PADDING;
        // 初始化经验值y坐标
        this.expY = this.rmLineY + IMG_RMLINE.getHeight(null) + PADDING;
        // 初始化经验值槽宽度
        this.expW = this.w - (PADDING << 1);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        // 窗口标题文字(分数)
        g.drawImage(IMG_POINT, this.x + PADDING, this.y + pointY, null);
        // 显示分数
        this.drawNumber(comX, pointY, this.dto.getNowPoint(), POINT_BIT, g);
        // 窗口标题文字(消行)
        g.drawImage(IMG_RMLINE, this.x + PADDING, this.y + rmLineY, null);
        // 显示消行
        this.drawNumber(comX, rmLineY, this.dto.getNowRemoveLine(), POINT_BIT, g);
        // 绘制值槽(经验值)
        int h = 32;
        g.setColor(Color.BLACK);
        g.fillRect(this.x + PADDING, this.y + expY, this.expW, h);
        g.setColor(Color.WHITE);
        g.fillRect(this.x + PADDING + 1, this.y + expY + 1, this.expW - 2, h - 2);
        g.setColor(Color.BLACK);
        g.fillRect(this.x + PADDING + 2, this.y + expY + 2, this.expW - 4, h - 4);
        g.setColor(Color.GREEN);
        // TODO 临时
        int rmLine = this.dto.getNowRemoveLine();
        int w = (int)(1.0 * (rmLine % LEVEL_UP) / LEVEL_UP * (this.expW - 4));
        System.out.println(w);
        g.fillRect(this.x + PADDING + 2, this.y + expY + 2, w, h - 4);
    }

}
