package fiuba.algo3.algocraft.utilidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;

public class Vitalidad {
    protected int vida;

    public Vitalidad(int vida) {
        this.vida = vida;
    }

    public void recibirDanyo(int cantidad) throws ExcepcionEstadoMuerto {
        int vidaRestada = this.vida - cantidad;
        if (vidaRestada > 0)
            this.vida = vidaRestada;
        else
            throw new ExcepcionEstadoMuerto();
    }

    public int getVida() {
        return this.vida;
    }
}