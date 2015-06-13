package fiuba.algo3.algocraft.utilidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;

public class VitalidadProtoss extends Vitalidad {
    private int escudo;

    public VitalidadProtoss(int vida, int escudo) {
        super(vida);
        this.escudo = escudo;
    }

    public int getEscudo() {
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
    
    public void recibirEmp() throws ExcepcionEstadoMuerto{
    	this.recibirDanyo(this.getEscudo());
    }
}
