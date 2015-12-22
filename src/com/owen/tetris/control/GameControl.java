package com.owen.tetris.control;

import com.owen.tetris.service.GameService;
import com.owen.tetris.ui.JPanelGame;

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
    }

}
