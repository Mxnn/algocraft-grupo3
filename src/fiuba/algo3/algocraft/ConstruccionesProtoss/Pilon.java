package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.AdicionalSuministros;
import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;

public class Pilon extends AdicionalSuministros {
    public static int COSTO_MINERAL= 100;
    public static int COSTO_GAZ = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    
    public Pilon(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 300;
        //escudo = 300
        this.tiempoDeConstruccion = 5;
        this.cantidadDeSuministrosAdicionales = 5;
        propietario.incrementarCapacidadDePoblacion(this.cantidadDeSuministrosAdicionales);

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}

