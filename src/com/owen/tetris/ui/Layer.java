package com.owen.tetris.ui;

import com.owen.tetris.config.ConfigFactory;
import com.owen.tetris.config.GameConfig;
import com.owen.tetris.dto.GameDto;

import javax.swing.*;
import java.awt.*;

/**
 * 窗口
 *
 * Created by mike on 15/12/13.
 */
public abstract class Layer {

    /**
     * 窗口内容的内边距
     */
    protected static final int PADDING;

    /**
     * 边框的宽度
     */
    private static final int SIZE;

    static {
        GameConfig cfg = ConfigFactory.getGameConfig();
        PADDING = cfg.getPadding();
        SIZE = cfg.getWindowSize();
    }

    /**
     * 窗口图片
     */
    private static final Image WINDOW_IMG = new ImageIcon("graphics/window/Window.png").getImage();

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
    protected final int x;

    /**
     * 窗口左上角 y 坐标
     */
    protected final int y;

    /**
     * 窗口宽度
     */
    protected final int w;

    /**
     * 窗口高度
     */
    protected final int h;

    /**
     * 游戏数据
     */
    protected GameDto dto;


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

    public Layer(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    /**
     * 绘制窗口
     */
    protected void createWindow(Graphics g) {
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

    public void setDto(GameDto dto) {
        this.dto = dto;
    }

    /**
     * 刷新游戏具体内容
     *
     * @param g 画笔
     */
    protected abstract void paint(Graphics g);

    /**
     * 绘制数字
     *
     * @param x 左上角x坐标
     * @param y 左上角y坐标
     * @param num 要显示的数字
     * @param maxBit 数字位数
     * @param g 画笔对象
     */
    protected void drawNumber(int x, int y, int num, int maxBit, Graphics g) {
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
