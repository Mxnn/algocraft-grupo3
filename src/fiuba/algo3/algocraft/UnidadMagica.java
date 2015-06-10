package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionEnergiaInsuficiente;

public abstract class UnidadMagica extends Unidad {
    public int ENERGIA_INICIAL;
    public int REGENERACION_ENERGIA;
    protected int energiaMaxima;
    protected int energia;

    public void regenerarEnergia() {
        int total = this.energia + this.REGENERACION_ENERGIA;
        if (total > this.energiaMaxima)
            this.energia = this.energiaMaxima;
        else
            this.energia = total;
    }

    public void gastarEnergia(int cantidad) throws ExcepcionEnergiaInsuficiente {
        int total = this.energia - cantidad;
        if (total < 0)
            throw new ExcepcionEnergiaInsuficiente();
        else
            this.energia = total;
    }
}
