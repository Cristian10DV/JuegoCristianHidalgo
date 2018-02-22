package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameObject;
import org.izv.android.juego1718.media.Animation;

public class Nave extends GameObject {

    private Animation animation;
    private long tiempo;

    public Nave() {
        super(Assets.nave1);
        this.setX(5);
        this.setY(260);
        animation = new Animation();
        animation.addFrame(Assets.nave1, 500);
        animation.addFrame(Assets.nave2, 500);
        tiempo = System.currentTimeMillis();

    }

    @Override
    public void update() {
        animation.update((System.currentTimeMillis() - tiempo));
        tiempo = System.currentTimeMillis();
        this.setImage(animation.getImage());
        this.setSpeedX(0);
    }
}
