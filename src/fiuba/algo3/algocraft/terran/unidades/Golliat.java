package fiuba.algo3.algocraft.terran.unidades;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;

public class Golliat extends UnidadAgresora {
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 50;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public static final int VIDA_INICIAL = 125;
    public static final int VISION = 8;
    public static final int CUPO_TRANSPORTE = 2;
    public static final int TIEMPO_DE_CONSTRUCCION = 6;

    public Golliat(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        this.suministro = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.vitalidad = new Vitalidad(VIDA_INICIAL);
        this.danyo = new Danyo(10, 12);
        this.vision = VISION;
        this.cupoDeTransporte = CUPO_TRANSPORTE;
        this.rangoAtaque = new RangoAtaque(5, 6);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
    }
    
}