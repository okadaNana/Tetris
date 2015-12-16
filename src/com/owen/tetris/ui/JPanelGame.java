package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/13.
 */
public class JPanelGame extends JPanel {

    private Layer[] layers = new Layer[] {
            new LayerBackground(0, 0, 0, 0),
            new LayerDataBase(40, 32, 334, 279),
            new LayerDisk(40, 343, 334, 279),
            new LayerGame(414, 32, 334, 590),
            new LayerButton(788, 32, 334, 124),
            new LayerNext(788, 188, 176, 148),
            new LayerLevel(964, 188, 158, 148),
            new LayerAbout(788, 368, 334, 200)
    };

    public JPanelGame() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < layers.length; i++) {
            layers[i].paint(g);
        }
    }


}
