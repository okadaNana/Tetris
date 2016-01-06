package com.owen.tetris.ui;

import java.awt.*;

/**
 * 分数窗口
 * <p>
 * Created by mike on 15/12/15.
 */
public class LayerPoint extends Layer {

    /**
     * 分数最大位数
     */
    private static final int POINT_BIT = 5;

    /**
     * 标题图片(消行)的高度
     */
    private static final int IMG_RMLINE_H = Img.RMLINE.getHeight(null);

    private static final int LEVEL_UP = 20;

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
        this.rmLineY = this.pointY + Img.POINT.getHeight(null) + PADDING;
        // 初始化经验值y坐标
        this.expY = this.rmLineY + Img.RMLINE.getHeight(null) + PADDING;
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        // 窗口标题文字(分数)
        g.drawImage(Img.POINT, this.x + PADDING, this.y + pointY, null);
        // 显示分数
        this.drawNumber(comX, pointY, this.dto.getNowPoint(), POINT_BIT, g);
        // 窗口标题文字(消行)
        g.drawImage(Img.RMLINE, this.x + PADDING, this.y + rmLineY, null);
        // 显示消行
        this.drawNumber(comX, rmLineY, this.dto.getNowRemoveLine(), POINT_BIT, g);
        // 绘制值槽(经验值)
        int rmLine = this.dto.getNowRemoveLine();
        this.drawRect(expY, "下一级", null, (double) (rmLine % LEVEL_UP), (double) LEVEL_UP, g);
        // TODO 临时
    }

}
