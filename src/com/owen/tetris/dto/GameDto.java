package com.owen.tetris.dto;

import com.owen.tetris.entity.GameAct;

import java.util.List;

/**
 * 游戏中,需要在画面上表现到数据的数据载体
 * <p>
 * 界面层调用其 get 方法
 * 业务逻辑层调用其 set 方法
 * <p>
 * Created by mike on 15/12/22.
 */
public class GameDto {

    /**
     * 数据库纪录
     */
    private List<Player> dbRecord;

    /**
     * 本地纪录
     */
    private List<Player> diskRecord;

    /**
     * 堆积的方块
     */
    private boolean[][] gameMap;

    /**
     * 正在下落的方块
     */
    private GameAct gameAct;

    /**
     * 下一个方块
     */
    private int next;

    /**
     * 等级
     */
    private int nowLevel;

    /**
     * 当前的分数
     */
    private int nowPoint;

    /**
     * 当前总共已经移除的行数
     */
    private int nowRemoveLine;

    public GameDto() {

    }

    /**
     * DTO 初始化
     */
    public void dtoInit() {

    }

    public List<Player> getDbRecord() {
        return dbRecord;
    }

    public void setDbRecord(List<Player> dbRecord) {
        this.dbRecord = dbRecord;
    }

    public List<Player> getDiskRecord() {
        return diskRecord;
    }

    public void setDiskRecord(List<Player> diskRecord) {
        this.diskRecord = diskRecord;
    }

    public boolean[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(boolean[][] gameMap) {
        this.gameMap = gameMap;
    }

    public GameAct getGameAct() {
        return gameAct;
    }

    public void setGameAct(GameAct gameAct) {
        this.gameAct = gameAct;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getNowLevel() {
        return nowLevel;
    }

    public void setNowLevel(int nowLevel) {
        this.nowLevel = nowLevel;
    }

    public int getNowPoint() {
        return nowPoint;
    }

    public void setNowPoint(int nowPoint) {
        this.nowPoint = nowPoint;
    }

    public int getNowRemoveLine() {
        return nowRemoveLine;
    }

    public void setNowRemoveLine(int nowRemoveLine) {
        this.nowRemoveLine = nowRemoveLine;
    }
}
