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

    private static Image ACT = new ImageIcon("graphics/game/rect.png").getImage();

    private static int ACT_SIZE = 32;

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
            g.drawImage(ACT,
                    this.x + points[i].x * ACT_SIZE + 7,
                    this.y + points[i].y * ACT_SIZE + 7,
                    this.x + points[i].x * ACT_SIZE + ACT_SIZE + 7,
                    this.y + points[i].y * ACT_SIZE + ACT_SIZE + 7,
                    (typeCode + 1) * ACT_SIZE, 0, (typeCode + 1) * ACT_SIZE + ACT_SIZE, ACT_SIZE, null);
        }

        // 打印游戏地图
        boolean[][] gameMap = this.dto.getGameMap();
        for (int x = 0; x < gameMap.length; x++) {
            for (int y = 0; y < gameMap[x].length; y++) {
                if (gameMap[x][y]) {
                    g.drawImage(ACT,
                            this.x + x * ACT_SIZE + 7,
                            this.y + y * ACT_SIZE + 7,
                            this.x + x * ACT_SIZE + ACT_SIZE + 7,
                            this.y + y * ACT_SIZE + ACT_SIZE + 7,
                            0, 0, 32, 32, null);
                }
            }
        }
    }

}
