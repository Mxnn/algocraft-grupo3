package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public class NaveTransporteTerran extends NaveTransporte {

    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public static final int VIDA_INICIAL = 150;
    public static final int VISION = 8;
    public static final int TIEMPO_DE_CONSTRUCCION = 7;
    public static final int CAPACIDAD = 8;

    public NaveTransporteTerran(Jugador propietario, Parcela parcela) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);

        this.vision = VISION;

        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;

        this.capacidad = CAPACIDAD;
        this.lugaresOcupados = 0;
        this.parcelaUbicacion = parcela;
    }
}
