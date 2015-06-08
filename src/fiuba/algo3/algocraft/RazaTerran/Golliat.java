package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public class Golliat extends UnidadTerrestre {
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 50;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public static final int VIDA_INICIAL = 125;
    public static final int VISION = 8;
    public static final int CUPO_TRANSPORTE = 2;
    public static final int TIEMPO_DE_CONSTRUCCION = 6;

    public Golliat(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);
        /*this.danyo = new Danyo(10, 12);*/
        this.vision = VISION;
        this.cupoDeTransporte = CUPO_TRANSPORTE;
        this.rangoAtaque = new RangoAtaque(5, 6);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
    }
}