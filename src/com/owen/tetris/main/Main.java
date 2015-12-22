package com.owen.tetris.main;

import com.owen.tetris.control.GameControl;
import com.owen.tetris.control.PlayerControl;
import com.owen.tetris.dto.GameDto;
import com.owen.tetris.service.GameService;
import com.owen.tetris.ui.JFrameGame;
import com.owen.tetris.ui.JPanelGame;

/**
 * 游戏启动器
 * <p>
 * 组装对象
 * <p>
 * Created by mike on 15/12/13.
 */
public class Main {

    public static void main(String[] args) {
        // 创建游戏数据源
        GameDto dto = new GameDto();
        // 创建游戏面板
        JPanelGame panel = new JPanelGame(dto);
        // 创建游戏逻辑块(连接游戏数据源)
        GameService service = new GameService(dto);
        // 创建游戏控制器(连接游戏面板与游戏逻辑块)
        GameControl gameControl = new GameControl(panel, service);
        // 创建玩家控制器(连接游戏控制器)
        PlayerControl control = new PlayerControl(gameControl);
        // 安装玩家控制器
        panel.setPlayerControl(control);
        // 创建游戏窗口,安装游戏面板
        JFrameGame frame = new JFrameGame(panel);
    }

}
