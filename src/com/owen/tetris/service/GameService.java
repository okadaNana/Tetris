package com.owen.tetris.service;

import com.owen.tetris.dto.GameDto;
import com.owen.tetris.entity.GameAct;

import java.awt.*;

/**
 * 游戏逻辑
 * <p>
 * Created by mike on 15/12/21.
 */
public class GameService {

    /**
     * 游戏数据,游戏逻辑调用其 set 方法
     */
    private GameDto dto;

    public GameService(GameDto dto) {
        this.dto = dto;
        GameAct act = new GameAct();
        dto.setGameAct(act);
    }

    /**
     * 控制器方向键(上)
     */
    public void keyUp() {
        if (this.canMove(0, -1)) {
            this.dto.getGameAct().move(0, -1);
        }
    }

    /**
     * 控制器方向键(下)
     */
    public void keyDown() {
        if (this.canMove(0, +1)) {
            this.dto.getGameAct().move(0, +1);
        }
    }

    /**
     * 控制器方向键(左)
     */
    public void keyLeft() {
        if (this.canMove(-1, 0)) {
            this.dto.getGameAct().move(-1, 0);
        }
    }

    /**
     * 控制器方向键(右)
     */
    public void keyRight() {
        if (this.canMove(+1, 0)) {
            this.dto.getGameAct().move(+1, 0);
        }
    }

    /**
     * 边界判定
     *
     * @param moveX
     * @param moveY
     * @return
     */
    private boolean canMove(int moveX, int moveY) {
        Point[] nowPoints = this.dto.getGameAct().getActPoints();
        for (int i = 0; i < nowPoints.length; i++) {
            int newX = nowPoints[i].x + moveX;
            int newY = nowPoints[i].y + moveY;

            if (newX < 0 || newX > 9 || newY < 0 || newY > 17) {
                return false;
            }
        }

        return true;
    }

}
