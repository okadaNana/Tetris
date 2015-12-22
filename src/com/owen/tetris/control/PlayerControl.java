package com.owen.tetris.control;

import com.owen.tetris.service.GameService;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 玩家控制器
 *
 * Created by mike on 15/12/21.
 */
public class PlayerControl extends KeyAdapter {

    private GameControl gameControl;

    public PlayerControl(GameControl gameControl) {
        this.gameControl = gameControl;
    }

    /**
     * 键盘按下事件
     */
    @Override
    public void keyPressed(KeyEvent e) {
        this.gameControl.test();
    }
}
