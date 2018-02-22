package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameObject;
import org.izv.android.juego1718.media.Animation;

public class Tiillo extends GameObject{

    private static final int MAXSALTO = 22;

    private Animation animation;
    private long tiempo;
    private boolean saltando = false;
    private int salto = 0;

    public Tiillo() {
        super(Assets.a);
        this.setX(150);
        this.setY(310);
        animation = new Animation();
        animation.addFrame(Assets.a, 500);
        animation.addFrame(Assets.b, 500);
        animation.addFrame(Assets.c, 500);
        tiempo = System.currentTimeMillis();
    }

    @Override
    public void update() {
        if(getTouchHandler().isMoving() && getTouchHandler().isMovingUp()) {
            this.setSpeedX(0);
            if(!saltando) {
                salto = -MAXSALTO;
                setSpeedY(salto);
                saltando = true;
            }
        }else if(getTouchHandler().isMoving() && getTouchHandler().isMovingLeft()) {
            this.setSpeedX(2);
        }else {
            animation.update((System.currentTimeMillis() - tiempo));
            tiempo = System.currentTimeMillis();
            this.setImage(animation.getImage());
            this.setSpeedX(0);
        }

        if(saltando) {
            setY(getY() + getSpeedY());
            setX(getX() + 2);
            this.setImage(Assets.b);
            this.setImage(Assets.c);
            setSpeedY(getSpeedY() + 1);
            salto++;
            if (salto > MAXSALTO) {
                saltando = false;
                setSpeedY(0);
            }
        }

        if(this.getX() + this.getSpeedX() > 150) {
            this.setX(150);
        }else {
            this.setX(this.getX() + this.getSpeedX());
        }
    }
}
