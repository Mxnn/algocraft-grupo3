package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.juego.Jugador;

public abstract class UnidadMagica extends Unidad {
    protected int regeneracionEnergia;
    protected int energiaMaxima;
    protected int energia;

    public UnidadMagica(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro, int energiaMaxima, int energiaInicial, int regeneracionEnergia) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, vitalidad, tiempoDeConstruccion, cupoDeTransporte, vision, suministro);
        this.energiaMaxima = energiaMaxima;
        this.energia = energiaInicial;
        this.regeneracionEnergia = regeneracionEnergia;
    }

    public void regenerarEnergia() {
        int total = this.energia + this.regeneracionEnergia;
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
