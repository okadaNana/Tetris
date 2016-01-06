package com.owen.tetris.ui;

import com.owen.tetris.config.ConfigFactory;
import com.owen.tetris.config.GameConfig;
import com.owen.tetris.dto.GameDto;

import javax.swing.*;
import java.awt.*;

/**
 * 窗口
 * <p>
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
     * 图片的宽度
     */
    private static final int WINDOW_W = Img.WINDOW.getWidth(null);

    /**
     * 图片的高度
     */
    private static final int WINDOW_H = Img.WINDOW.getHeight(null);

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
     * 数字切片的宽度
     */
    protected static final int IMG_NUMBER_W = Img.NUMBER.getWidth(null) / 10;

    /**
     * 数字切片的高度
     */
    private static final int IMG_NUMBER_H = Img.NUMBER.getHeight(null);


    /**
     * 矩形值槽图片的高度
     */
    private static final int IMG_RECT_H = Img.RECT.getHeight(null);

    /**
     * 矩形值槽图片的宽度
     */
    private static final int IMG_RECT_W = Img.RECT.getWidth(null);

    /**
     * 矩形值槽的宽度
     */
    private final int rectW;

    private static final Font DEF_FONT = new Font("黑体", Font.BOLD, 20);

    public Layer(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.rectW = this.w - (PADDING << 1);
    }

    /**
     * 绘制窗口
     */
    protected void createWindow(Graphics g) {
        g.drawImage(Img.WINDOW, x, y, x + SIZE, y + SIZE, 0, 0, SIZE, SIZE, null);
        g.drawImage(Img.WINDOW, x + SIZE, y, x + w - SIZE, y + SIZE, SIZE, 0, WINDOW_W - SIZE, SIZE, null);
        g.drawImage(Img.WINDOW, x + w - SIZE, y, x + w, y + SIZE, WINDOW_W - SIZE, 0, WINDOW_W, SIZE, null);
        g.drawImage(Img.WINDOW, x, y + SIZE, x + SIZE, y + h - SIZE, 0, SIZE, SIZE, WINDOW_H - SIZE, null);
        g.drawImage(Img.WINDOW, x + SIZE, y + SIZE, x + w - SIZE, y + h - SIZE, SIZE, SIZE, WINDOW_W - SIZE, WINDOW_H - SIZE, null);
        g.drawImage(Img.WINDOW, x + w - SIZE, y + SIZE, x + w, y + h - SIZE, WINDOW_W - SIZE, SIZE, WINDOW_W, WINDOW_H - SIZE, null);
        g.drawImage(Img.WINDOW, x, y + h - SIZE, x + SIZE, y + h, 0, WINDOW_H - SIZE, SIZE, WINDOW_H, null);
        g.drawImage(Img.WINDOW, x + SIZE, y + h - SIZE, x + w - SIZE, y + h, SIZE, WINDOW_H - SIZE, WINDOW_W - SIZE, WINDOW_H, null);
        g.drawImage(Img.WINDOW, x + w - SIZE, y + h - SIZE, x + w, y + h, WINDOW_W - SIZE, WINDOW_H - SIZE, WINDOW_W, WINDOW_H, null);
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
     * @param x      左上角x坐标
     * @param y      左上角y坐标
     * @param num    要显示的数字
     * @param maxBit 数字位数
     * @param g      画笔对象
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
                g.drawImage(Img.NUMBER,
                        this.x + x + IMG_NUMBER_W * i, this.y + y,
                        this.x + x + IMG_NUMBER_W * (i + 1), this.y + y + IMG_NUMBER_H,
                        bit * IMG_NUMBER_W, 0, (bit + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null);
            }
        }
    }


    /**
     * 绘制值槽
     */
    protected void drawRect(int y, String title, String number, double value, double maxValue, Graphics g) {
        // 各种值初始化
        int rect_x = this.x + PADDING;
        int rect_y = this.y + y;
        // 绘制背景
        g.setColor(Color.BLACK);
        g.fillRect(rect_x, rect_y, rectW, IMG_RECT_H + 4);
        g.setColor(Color.WHITE);
        g.fillRect(rect_x + 1, rect_y + 1, rectW - 2, IMG_RECT_H + 2);
        g.setColor(Color.BLACK);
        g.fillRect(rect_x + 2, rect_y + 2, rectW - 4, IMG_RECT_H);
        // 绘制值槽
        // 求出比率
        double p = value / maxValue;
        // 求出宽度
        int w = (int) (p * (rectW - 4));
        // 求出颜色
        int subIdx = (int) (p * IMG_RECT_W);
        g.drawImage(Img.RECT,
                rect_x + 2, rect_y + 2,
                rect_x - 2 + w, rect_y + 2 + IMG_RECT_H,
                subIdx, 0, subIdx + 1, IMG_RECT_H,
                null);

        g.setColor(Color.WHITE);
        g.setFont(DEF_FONT);
        g.drawString(title, rect_x + 4, rect_y + 22);
        if (number != null) {
            // TODO 绘制数值
        }
    }

    /**
     * 把图片绘制在正中间
     */
    protected void drawImageAtCenter(Image img, Graphics g) {
        int imgW = img.getWidth(null);
        int imgH = img.getHeight(null);
        g.drawImage(img, this.x + (this.w - imgW >> 1), this.y + (this.h - imgH >> 1), null);
    }

}
