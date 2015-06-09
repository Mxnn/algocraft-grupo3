package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public class NaveTransporteProtoss extends NaveTransporte {
    public static final int VIDA_INICIAL = 125;
    public static final int ESCUDO_INICIAL = 60;
    public static final int VISION = 8;
    public static final int TIEMPO_DE_CONSTRUCCION = 8;
    public static final int CAPACIDAD = 8;
	
    public static int COSTO_MINERAL = 200;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
    public NaveTransporteProtoss(Jugador propietario, Parcela parcela) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.estado = new EstadoProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        /*this.danyo = new Danyo(0, 0);*/
        this.vision = VISION;
        this.rangoAtaque = new RangoAtaque(0, 0);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;

        this.capacidad = CAPACIDAD;
        this.lugaresOcupados = 0;
        this.parcela = parcela;
    }
}
