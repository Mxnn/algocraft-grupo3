package fiuba.algo3.algocraft.razas.terran.unidades;

import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.Vitalidad;
import fiuba.algo3.algocraft.utilidades.unidades.NaveTransporte;

public class NaveTransporteTerran extends NaveTransporte {

    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public static final int VIDA_INICIAL = 150;
    public static final int VISION = 8;
    public static final int TIEMPO_DE_CONSTRUCCION = 7;
    public static final int CAPACIDAD = 8;
    public static final int CUPO_DE_TRANSPORTE = 0;
    public static final int SUMINISTRO = 2;

    public NaveTransporteTerran(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, CAPACIDAD);
    }
}
