package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;

public class EstadoProtoss extends Estado {
    private int escudo;

    public EstadoProtoss(int vida, int escudo) {
        super(vida);
        this.escudo = escudo;
    }

    public int obtenerEscudo() {
        return this.escudo;
    }

    public void recibirDanyo(int cantidad) throws ExcepcionEstadoMuerto {
        int restaAEscudo = this.escudo - cantidad;
        if (restaAEscudo >= 0)
            this.escudo = restaAEscudo;
        else {
            this.escudo = 0;
            super.recibirDanyo(restaAEscudo * (-1));
        }
    }
}
