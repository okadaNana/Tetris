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
        this.dto.getGameAct().round();
    }

    /**
     * 控制器方向键(下)
     */
    public void keyDown() {
        if (this.dto.getGameAct().move(0, +1)) {
            // 无法继续向下移动了
            boolean[][] gameMap = this.dto.getGameMap();
            Point[] actPoints = this.dto.getGameAct().getActPoints();
            for (int i = 0; i < actPoints.length; i++) {
                gameMap[actPoints[i].x][actPoints[i].y] = true;
            }
        }
    }

    /**
     * 控制器方向键(左)
     */
    public void keyLeft() {
        this.dto.getGameAct().move(-1, 0);
    }

    /**
     * 控制器方向键(右)
     */
    public void keyRight() {
        this.dto.getGameAct().move(+1, 0);
    }

}
