package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/13.
 */
public class PanelGame extends JPanel {

    private Layer layer1 = new Layer(128, 32, 320, 576);

    public PanelGame() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        layer1.createWindow(g);

//        Image img = new ImageIcon("graphics/window/Window2.png").getImage();
//
//
//        int x = 32;
//        int y = 32;
//        int w = 256;
//        int h = 128;
//        int size = 7;
//        int imgW = img.getWidth(null);
//        int imgH = img.getHeight(null);
//
//        g.drawImage(img, x, y, x + size, y + size, 0, 0, size, size, null);
//        g.drawImage(img, x + size, y, x + w - size, y + size, size, 0, imgW - size, size, null);
//        g.drawImage(img, x + w - size, y, x + w, y + size, imgW - size, 0, imgW, size, null);
//        g.drawImage(img, x, y + size, x + size, y + h - size, 0, size, size, imgH - size, null);
//        g.drawImage(img, x + size, y + size, x + w - size, y + h - size, size, size, imgW - size, imgH - size, null);
//        g.drawImage(img, x + w - size, y + size, x + w, y + h - size, imgW - size, size, imgW, imgH - size, null);
//        g.drawImage(img, x, y + h - size, x + size, y + h, 0, imgH - size, size, imgH, null);
//        g.drawImage(img, x + size, y + h - size, x + w - size, y + h, size, imgH - size, imgW - size, imgH, null);
//        g.drawImage(img, x + w - size, y + h - size, x + w, y + h, imgW - size, imgH - size, imgW, imgH, null);
    }


}
