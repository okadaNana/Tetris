package com.owen.tetris.control;

import com.owen.tetris.service.GameService;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 玩家控制器
 *
 * Created by mike on 15/12/21.
 */
public class PlayerControl implements KeyListener {

    private GameControl gameControl;

    public PlayerControl(GameControl gameControl) {
        this.gameControl = gameControl;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.print(e.getKeyChar() + ".");
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
