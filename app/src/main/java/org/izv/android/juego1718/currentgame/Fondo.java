package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameBackground;
import org.izv.android.juego1718.media.Image;

public class Fondo extends GameBackground {

    public Fondo() {
        super(Assets.bk3);
        this.setMovement(Movement.MOVING);

    }
}
