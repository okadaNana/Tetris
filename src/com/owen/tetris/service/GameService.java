package com.owen.tetris.service;

import com.owen.tetris.dto.GameDto;

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
    }

    public void gameTest() {
        int temp = dto.getNowPoint();
        dto.setNowPoint(temp + 1);
    }

}
