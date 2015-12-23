package com.owen.tetris.entity;

import java.awt.*;

/**
 * 方块
 * <p>
 * Created by mike on 15/12/22.
 */
public class GameAct {

    /**
     * 4小格的坐标数组
     */
    private Point[] actPoints;

    public GameAct() {
        actPoints = new Point[]{
            new Point(3, 0),
            new Point(4, 0),
            new Point(5, 0),
            new Point(5, 1)
        };
    }

    public Point[] getActPoints() {
        return actPoints;
    }

    /**
     * 方块移动
     *
     * @param moveX x 轴偏移量
     * @param moveY y 轴偏移量
     */
    public void move(int moveX, int moveY) {
        for (int i = 0; i < actPoints.length; i++) {
            actPoints[i].x += moveX;
            actPoints[i].y += moveY;
        }
    }

}
