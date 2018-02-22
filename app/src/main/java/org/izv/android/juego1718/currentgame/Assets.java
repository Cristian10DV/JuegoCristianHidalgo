package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.media.Graphics;
import org.izv.android.juego1718.media.Image;

public class Assets {

    public static Image background, bk3, nave1, nave2, platillo, a, b, c;

    public static void load(Graphics g) {
        Assets.background = g.newImage("background.jpg");
        Assets.a = g.newImage("a.png");
        Assets.b = g.newImage("b.png");
        Assets.c = g.newImage("c.png");
        Assets.bk3 = g.newImage("bk3.png");
        Assets.nave1 = g.newImage("nave1.png");
        Assets.nave2 = g.newImage("nave2.png");
        Assets.platillo = g.newImage("platillo.png");
    }
}