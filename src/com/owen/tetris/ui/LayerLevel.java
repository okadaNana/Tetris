package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * "等级"窗口
 * <p>
 * Created by mike on 15/12/15.
 */
public class LayerLevel extends Layer {

    /**
     * 标题图片
     */
    private static final Image IMG_LEVEL = new ImageIcon("graphics/string/level.png").getImage();

    /**
     * 数字图片(260*36)
     */
    private static final Image IMG_NUMBER = new ImageIcon("graphics/string/num.png").getImage();

    private static final int IMG_NUMBER_W = 26;

    private static final int IMG_NUMBER_H = 36;

    public LayerLevel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        // 窗口标题
        g.drawImage(IMG_LEVEL, this.x + PADDING, this.y + PADDING, null);
        // 显示等级
        drawNumber(32, 32, 2, g);
    }

    /**
     * 绘制数字
     */
    private void drawNumber(int x, int y, int num, Graphics g) {
        g.drawImage(IMG_NUMBER,
                this.x + x, this.y + y, this.x + x + IMG_NUMBER_W, this.y + y + IMG_NUMBER_H,
                num * IMG_NUMBER_W, 0, (num + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null);
    }

}
