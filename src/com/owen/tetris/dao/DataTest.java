package com.owen.tetris.dao;

import com.owen.tetris.dto.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 16/1/13.
 */
public class DataTest implements Data {

    @Override
    public List<Player> loadData() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("刘明", 100));
        players.add(new Player("刘明", 1000));
        players.add(new Player("刘明", 2000));
        players.add(new Player("刘明", 3000));
        players.add(new Player("刘明", 4000));
        return players;
    }

    @Override
    public void saveData(List<Player> players) {
        System.out.println();
    }

}
