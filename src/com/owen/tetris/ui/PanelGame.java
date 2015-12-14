package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 15/12/13.
 */
public class PanelGame extends JPanel {

    private Layer[] layers = new Layer[] {
            new Layer(40, 32, 334, 279),
            new Layer(40, 343, 334, 279),
            new Layer(414, 32, 334, 590),
            new Layer(788, 32, 334, 124),
            new Layer(788, 188, 176, 148),
            new Layer(964, 188, 158, 148),
            new Layer(788, 368, 334, 200)
    };

    public PanelGame() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < layers.length; i++) {
            layers[i].createWindow(g);
        }
    }


}
