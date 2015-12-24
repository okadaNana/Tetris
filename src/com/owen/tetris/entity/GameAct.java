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

    private static final int MIN_X = 0;
    private static final int MAX_X = 9;
    private static final int MIN_Y = 0;
    private static final int MAX_Y = 17;

    public GameAct() {
        actPoints = new Point[]{
            new Point(4, 0),
            new Point(3, 0),
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
    public boolean move(int moveX, int moveY) {
        for (int i = 0; i < actPoints.length; i++) {
            int newX = actPoints[i].x + moveX;
            int newY = actPoints[i].y + moveY;

            if (this.isOverMap(newX, newY)) {
                return false;
            }
        }

        // 没有return掉,说明判断都通过了
        for (int i = 0; i < actPoints.length; i++) {
            actPoints[i].x += moveX;
            actPoints[i].y += moveY;
        }

        return true;
    }

    /**
     * 方块旋转
     *
     * A.x = O.y + O.x - B.y
     * A.y = O.y - O.x + B.x
     */
    public void round() {
        for (int i = 1; i < actPoints.length; i++) {
            int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
            int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;

            if (this.isOverMap(newX, newY)) {
                // 不可以旋转
                return;
            }
        }

        // 没有return掉,说明判断都通过了
        for (int i = 1; i < actPoints.length; i++) {
            int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
            int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;

            // 这里很重要,要用临时变量来存储计算后都值,否则就会出现x都值已经变化了,却将已变化后都x的值来计算y的值,这样的答案是错的
            actPoints[i].x = newX;
            actPoints[i].y = newY;
        }
    }

    /**
     * 判断某一个点是否超出游戏地图边界
     */
    private boolean isOverMap(int x, int y) {
        return x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y;
    }

}
