package fiuba.algo3.algocraft.utilidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;

public class VitalidadProtoss extends Vitalidad {
    private int escudo;
    private int escudoMaximo;

    public VitalidadProtoss(int vida, int escudo) {
        super(vida);
        this.escudo = escudo;
        this.escudoMaximo = escudo;
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

    public void regenerar() {
        /*int total = this.escudo + cantidad;
        if (total > this.escudoMaximo)
            this.escudo = this.escudoMaximo;
        else
            this.escudo = total;*/
        this.escudo = this.escudoMaximo;
    }
}
