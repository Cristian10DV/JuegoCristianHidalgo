package org.izv.android.juego1718;

import android.content.Intent;

import org.izv.android.juego1718.currentgame.Background;
import org.izv.android.juego1718.currentgame.BouncingBall;
import org.izv.android.juego1718.currentgame.Fondo;
import org.izv.android.juego1718.currentgame.Nave;
import org.izv.android.juego1718.currentgame.Tiillo;
import org.izv.android.juego1718.generic.GenericGameActivity;

public class JuegoNuevo extends GenericGameActivity{

    private BouncingBall b1, b2;
    private Tiillo t;
    private Nave n;

    @Override
    public void start() {
        //orden en el que añado, orden en el que se pintan.
        addGameObject(new Fondo());
        //pelota
        b1 = new BouncingBall();
        addGameObject(b1);
        //nave
        n = new Nave();
        addGameObject(n);
        //hombre
        t = new Tiillo();
        addGameObject(t);
    }

    @Override
    public void update() {
        super.update();


        chocapelota(t,b1);
        pelotagana(n,b1);
    }

    private boolean chocapelota(Tiillo t, BouncingBall b) {
        boolean chocan = t.instersects(b);
        if (chocan) {
            if(t.getX()>b.getX()) {
                b.setSpeedX(-(b.getSpeedX() + 1));
            }else {
                b.setSpeedX(b.getSpeedX() + 1);
            }
            if(t.getY()>b.getY()) {
                b.setSpeedY(-(b.getSpeedY() + 1));
            }else {
                b.setSpeedY(b.getSpeedY() + 1);
            }
        }

        return false;
    }
    private boolean pelotagana(Nave n, BouncingBall b) {
        boolean chocan = n.instersects(b);
        if (chocan) {
            Intent intent = new Intent(getApplicationContext(), GameOver.class);
            startActivity(intent);
        }

        return false;
    }

}
