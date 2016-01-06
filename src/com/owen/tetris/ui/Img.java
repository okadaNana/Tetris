package com.owen.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 图片资源类,方便统一管理
 *
 * Created by mike on 16/1/6.
 */
public class Img {

    private Img() {}

    /**
     * 个人签名
     */
    public static final Image SIGN = new ImageIcon("graphics/string/sign.png").getImage();

    /**
     * 窗口图片
     */
    public static final Image WINDOW = new ImageIcon("graphics/window/Window.png").getImage();

    /**
     * 数字图片(260*36)
     */
    public static final Image NUMBER = new ImageIcon("graphics/string/num.png").getImage();

    /**
     * 矩形值槽
     */
    public static final Image RECT = new ImageIcon("graphics/window/rect.png").getImage();

    /**
     * 数据库窗口标题
     */
    public static final Image DB = new ImageIcon("graphics/string/db.png").getImage();

    /**
     * 本地纪录窗口标题
     */
    public static final Image DISK = new ImageIcon("graphics/string/disk.png").getImage();

    /**
     * 方块图片
     */
    public static final Image ACT = new ImageIcon("graphics/game/rect.png").getImage();

    /**
     * 标题图片
     */
    public static final Image LEVEL = new ImageIcon("graphics/string/level.png").getImage();

    /**
     * 标题图片(分数)
     */
    public static final Image POINT = new ImageIcon("graphics/string/point.png").getImage();

    /**
     * 标题图片(消行)
     */
    public static final Image RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();

    /**
     * 下一个图片数组
     */
    public static final Image[] NEXT_ACT;

    static {
        NEXT_ACT = new Image[7];
        for (int i = 0; i < NEXT_ACT.length; i++) {
            NEXT_ACT[i] = new ImageIcon("graphics/game/" + i + ".png").getImage();
        }
    }

}
