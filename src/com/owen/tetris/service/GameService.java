package com.owen.tetris.service;

import com.owen.tetris.dto.GameDto;
import com.owen.tetris.entity.GameAct;

import java.awt.*;
import java.util.Random;

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

    /**
     * 随机数生成器
     */
    private Random random = new Random();

    private static final int MAX_TYPE = 6;

    public GameService(GameDto dto) {
        this.dto = dto;
        GameAct act = new GameAct(random.nextInt(MAX_TYPE));
        dto.setGameAct(act);
    }

    /**
     * 方块操作(上)
     */
    public void keyUp() {
        this.dto.getGameAct().round(this.dto.getGameMap());
    }

    /**
     * 方块操作(下)
     */
    public void keyDown() {
        if (this.dto.getGameAct().move(0, +1, this.dto.getGameMap())) {
            return;
        }

        // 无法继续向下移动了

        // 方块堆积到地图
        boolean[][] gameMap = this.dto.getGameMap();
        Point[] actPoints = this.dto.getGameAct().getActPoints();
        for (int i = 0; i < actPoints.length; i++) {
            gameMap[actPoints[i].x][actPoints[i].y] = true;
        }

        // 判断是否可以消行
        //  如果可以,就消
        //  算分操作
        //  判读是否升级
        //      如果可以升级,就升级
        // 刷新一个新的方块

        // 创建下一个方块
        this.dto.getGameAct().init(this.dto.getNext());
        // 然后随机生成下一个方块
        this.dto.setNext(random.nextInt(MAX_TYPE));
    }

    /**
     * 方块操作(左)
     */
    public void keyLeft() {
        this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
    }

    /**
     * 方块操作(右)
     */
    public void keyRight() {
        this.dto.getGameAct().move(+1, 0, this.dto.getGameMap());
    }

    // TODO ================  测试专用方法 =======================

    public void testLevelUp() {
        this.dto.setNowLevel(this.dto.getNowLevel() + 1);
    }
}
