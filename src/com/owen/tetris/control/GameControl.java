package com.owen.tetris.control;

import com.owen.tetris.dao.Data;
import com.owen.tetris.dao.DataBase;
import com.owen.tetris.dao.DataTest;
import com.owen.tetris.dto.Player;
import com.owen.tetris.service.GameService;
import com.owen.tetris.ui.JPanelGame;

import java.util.List;

/**
 * 游戏控制器
 * <p>
 * 作用:<br />
 * 1)接收玩家键盘事件<br />
 * 2)控制游戏逻辑
 * <p>
 * Created by mike on 15/12/21.
 */
public class GameControl {

    /**
     * 数据访问接口A
     */
    private Data dataA;

    /**
     * 数据访问接口B
     */
    private Data dataB;

    /**
     * 游戏界面层
     */
    private JPanelGame panelGame;

    /**
     * 游戏逻辑层
     */
    private GameService gameService;

    public GameControl(JPanelGame panelGame, GameService gameService) {
        this.panelGame = panelGame;
        this.gameService = gameService;
        this.dataA = new DataTest();
        this.dataB = new DataTest();
        this.gameService.setDbRecord(dataA.loadData());
        this.gameService.setDiskRecord(dataB.loadData());
    }

    /**
     * 控制器方向键(上)
     */
    public void keyUp() {
        this.gameService.keyUp();
        this.panelGame.repaint();
    }

    /**
     * 控制器方向键(下)
     */
    public void keyDown() {
        this.gameService.keyDown();
        this.panelGame.repaint();
    }

    /**
     * 控制器方向键(左)
     */
    public void keyLeft() {
        this.gameService.keyLeft();
        this.panelGame.repaint();
    }

    /**
     * 控制器方向键(右)
     */
    public void keyRight() {
        this.gameService.keyRight();
        this.panelGame.repaint();
    }

    // TODO ================  测试专用方法 =======================
    public void testLeveUp() {
        this.gameService.testLevelUp();
        this.panelGame.repaint();
    }

}
