package com.owen.tetris.ui;

import com.owen.tetris.entity.GameAct;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏窗口
 *
 * Created by mike on 15/12/15.
 */
public class LayerGame extends Layer {

    private static final int ACT_SIZE = 32;

    private static final int SIZE_ROL = 5;

    public LayerGame(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);

        // 获得方块类型编号(0~6)
        int typeCode = this.dto.getGameAct().getTypeCode();
        // 获得方块数组集合
        Point[] points = this.dto.getGameAct().getActPoints();
        // 打印方块
        for (int i = 0; i < points.length; i++) {
            draActByPoint(points[i].x, points[i].y, typeCode + 1, g);
        }

        // 打印游戏地图
        boolean[][] gameMap = this.dto.getGameMap();
        for (int x = 0; x < gameMap.length; x++) {
            for (int y = 0; y < gameMap[x].length; y++) {
                if (gameMap[x][y]) {
                    draActByPoint(x, y, 0, g);
                }
            }
        }
    }

    /**
     * 绘制正方形块
     */
    private void draActByPoint(int x, int y, int imgIdx, Graphics g) {
        g.drawImage(Img.ACT,
                this.x + (x << SIZE_ROL) + 7,
                this.y + (y << SIZE_ROL) + 7,
                this.x + (x + 1 << SIZE_ROL) + 7,
                this.y + (y +1 << SIZE_ROL) + 7,
                imgIdx << SIZE_ROL, 0, (imgIdx + 1) << SIZE_ROL, 1 << SIZE_ROL, null);
    }

}
