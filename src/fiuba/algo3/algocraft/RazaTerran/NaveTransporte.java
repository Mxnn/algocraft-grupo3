package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadVoladora;

public class NaveTransporte extends UnidadVoladora {
    /*private int capacidad;
    private int plazasOcupadas;*/
    public static final int SUMINISTRO = 2;
    public static final int VIDA = 150;
    public static final int VISION = 8;
    public static final int CUPO_TRANSPORTE = 0;
    public static final int TIEMPO_DE_CONSTRUCCION = 7;

    public NaveTransporte(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        propietario.incrementarPoblacion(SUMINISTRO);
        this.propietario = propietario;
        this.vida = VIDA;
        /*this.danyo = new Danyo(0, 0);
        this.costo = new Costo(100, 100);*/
        this.vision = VISION;
        this.cupoDeTransporte = CUPO_TRANSPORTE;
        this.rangoAtaque = new RangoAtaque(0, 0);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;

        /*this.capacidad = 8;
        this.plazasOcupadas = 0;*/
    }
}
