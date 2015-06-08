package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadVoladora;

public class Espectro extends UnidadVoladora {
    public static final int SUMINISTRO = 2;
    public static final int VIDA_INICIAL = 120;
    public static final int VISION = 7;
    public static final int CUPO_TRANSPORTE = 0;
    public static final int TIEMPO_DE_CONSTRUCCION = 8;

    public Espectro(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        propietario.incrementarPoblacion(SUMINISTRO);
        this.propietario = propietario;
        this.vida = VIDA_INICIAL;
        /*this.danyo = new Danyo(20, 8);
        this.costo = new Costo(150, 100);*/
        this.vision = VISION;
        this.cupoDeTransporte = CUPO_TRANSPORTE;
        this.rangoAtaque = new RangoAtaque(5, 0);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
    }
}
