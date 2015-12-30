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
    private static final Image IMG_LV = new ImageIcon("graphics/string/level.png").getImage();

    private static final int IMG_LV_W = IMG_LV.getWidth(null);

    /**
     * 数字图片(260*36)
     */
    private static final Image IMG_NUMBER = new ImageIcon("graphics/string/num.png").getImage();

    /**
     * 数字切片的宽度
     */
    private static final int IMG_NUMBER_W = IMG_NUMBER.getWidth(null) / 10;

    /**
     * 数字切片的高度
     */
    private static final int IMG_NUMBER_H = IMG_NUMBER.getHeight(null);

    public LayerLevel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        // 窗口标题
        int centerX = this.x + (this.w - IMG_LV_W >> 1);
        g.drawImage(IMG_LV, centerX, this.y + PADDING, null);
        // 显示等级
        drawNumber(16, 64, 789, 5, g);
    }

    /**
     * 绘制数字
     *
     * @param x 左上角x坐标
     * @param y 左上角y坐标
     * @param num 要显示的数字
     * @param maxBit 数字位数
     * @param g 画笔对象
     */
    private void drawNumber(int x, int y, int num, int maxBit, Graphics g) {
        // 把要打印的数字转换成字符串
        String strNum = Integer.toString(num);
        // 循环绘制数字(右对齐)
        for (int i = 0; i < maxBit; i++) {
            // 判断是否满足绘制条件
            if (maxBit - i <= strNum.length()) {
                // 获得竹子在字符串中的下标
                int idx = i - maxBit + strNum.length();
                // 把数字num中的每一个取出
                int bit = strNum.charAt(idx) - '0';
                // 绘制数字
                g.drawImage(IMG_NUMBER,
                        this.x + x + IMG_NUMBER_W * i, this.y + y,
                        this.x + x + IMG_NUMBER_W * (i + 1), this.y + y + IMG_NUMBER_H,
                        bit * IMG_NUMBER_W, 0, (bit + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null);
            }
        }


    }

}
