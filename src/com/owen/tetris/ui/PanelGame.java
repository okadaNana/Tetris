package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/13.
 */
public class PanelGame extends JPanel {

    public PanelGame() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image img = new ImageIcon("graphics/window/Window.png").getImage();
        drawWindow(64, 64, 500, 500, g);
    }

    private static final Image WINDOW_IMG = new ImageIcon("graphics/window/Window.png").getImage();
    private static final int SIZE = 7;
    private static final int WINDOW_WIDTH = 64;
    private static final int WINDOW_HEIGHT = 64;

    private void drawWindow(int x, int y, int width, int height, Graphics g) {
        g.drawImage(WINDOW_IMG, x, y, x + SIZE, y + SIZE, 0, 0, SIZE, SIZE, null);  // 左上
        g.drawImage(WINDOW_IMG, x + SIZE, y, x + SIZE + width, y + SIZE, SIZE, 0, WINDOW_WIDTH - SIZE, SIZE, null);  // 中上
        g.drawImage(WINDOW_IMG, x + SIZE + width, y, x + SIZE * 2 + width, y + SIZE, WINDOW_WIDTH - SIZE, 0, WINDOW_WIDTH, SIZE, null);  // 右上
        g.drawImage(WINDOW_IMG, x, y + SIZE, x + SIZE, y + SIZE + height, 0, SIZE, SIZE, WINDOW_HEIGHT - SIZE, null);  // 左中
        g.drawImage(WINDOW_IMG, x, y + SIZE + height, x + SIZE, y + SIZE * 2 + height, 0, WINDOW_HEIGHT - SIZE, SIZE, WINDOW_HEIGHT, null);  // 左下
        g.drawImage(WINDOW_IMG, x + SIZE, y + SIZE + height, x + SIZE + width, y + SIZE * 2 + height, SIZE, WINDOW_HEIGHT - SIZE, WINDOW_WIDTH - SIZE, WINDOW_HEIGHT, null);  // 中下
        g.drawImage(WINDOW_IMG, x + SIZE + width, y + SIZE + height, x + SIZE * 2 + width, y + SIZE * 2 + height, WINDOW_WIDTH - SIZE, WINDOW_HEIGHT - 7, WINDOW_WIDTH, WINDOW_HEIGHT, null);  // 右下
        g.drawImage(WINDOW_IMG, x + SIZE + width, y + SIZE, x + SIZE * 2 + width, y + SIZE + height, WINDOW_WIDTH - SIZE, SIZE, WINDOW_WIDTH, WINDOW_HEIGHT - SIZE, null);  // 右中
        g.drawImage(WINDOW_IMG, x + SIZE, y + SIZE, x + SIZE + width, y + SIZE + height, SIZE, SIZE, WINDOW_WIDTH - SIZE, WINDOW_HEIGHT - SIZE, null);  // 中中
    }

}
