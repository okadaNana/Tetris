package com.owen.tetris.dao;

import com.owen.tetris.dto.Player;

import java.util.List;

/**
 * 数据持久层接口
 *
 * Created by mike on 16/1/13.
 */
public interface Data {

    /**
     * 读取数据
     */
    List<Player> loadData();

    /**
     * 存储数据
     */
    void saveData(List<Player> players);

}
