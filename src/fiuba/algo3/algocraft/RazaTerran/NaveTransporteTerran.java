package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public class NaveTransporteTerran extends NaveTransporte {
    /*private int capacidad;
    private int plazasOcupadas;*/
	
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    	
    public static final int SUMINISTRO = 2;
    public static final int VIDA_INICIAL = 150;
    public static final int VISION = 8;
    public static final int TIEMPO_DE_CONSTRUCCION = 7;
    public static final int CAPACIDAD = 8;


    public NaveTransporteTerran(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        propietario.agregarUnidad(this, SUMINISTRO);
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);
        /*this.danyo = new Danyo(0, 0);*/
        this.vision = VISION;
        this.rangoAtaque = new RangoAtaque(0, 0);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;

        this.capacidad = CAPACIDAD;
        this.lugaresOcupados = 0;
    }
}
