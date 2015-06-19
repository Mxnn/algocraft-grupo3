package fiuba.algo3.algocraft.modelo.utilidades;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;

public class VitalidadProtoss extends Vitalidad {
    private int escudo;
    private int escudoMaximo;
    private int REGENERACION_POR_TURNO = 10;

    public VitalidadProtoss(int vida, int escudo) {
        super(vida);
        this.escudo = escudo;
        this.escudoMaximo = escudo;
    }

    public int getEscudo() {
        return this.escudo;
    }

    @Override
    public void recibirDanyo(int cantidad) throws ExcepcionEstadoMuerto {
        int restaAEscudo = this.escudo - cantidad;
        if (restaAEscudo > 0)
            this.escudo = restaAEscudo;
        else {
            this.escudo = 0;
            super.recibirDanyo(restaAEscudo * (-1));
        }
    }

    @Override
    public void recibirEmp() throws ExcepcionEstadoMuerto{
    	this.recibirDanyo(this.getEscudo());
    }

    @Override
    public void regenerar() {
        int total = this.escudo + this.REGENERACION_POR_TURNO;
        if (total > this.escudoMaximo)
            this.escudo = this.escudoMaximo;
        else
            this.escudo = total;
    }
}
