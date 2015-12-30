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

    /**
     * 标题图片的宽度
     */
    private static final int IMG_LV_W = IMG_LV.getWidth(null);


    public LayerLevel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        // 窗口标题
        int centerX = this.w - IMG_LV_W >> 1;
        g.drawImage(IMG_LV, this.x + centerX, this.y + PADDING, null);
        // 显示等级
        this.drawNumber(centerX, 64, this.dto.getNowLevel(), 2, g);
    }

}
