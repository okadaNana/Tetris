package com.owen.tetris.dao;

import com.owen.tetris.dto.Player;

import java.util.List;

/**
 * 数据库数据持久层接口实现类
 *
 * Created by mike on 16/1/13.
 */
public class DataBase implements Data {

    @Override
    public List<Player> loadData() {
        return null;
    }

    @Override
    public void saveData(List<Player> players) {

    }

}
