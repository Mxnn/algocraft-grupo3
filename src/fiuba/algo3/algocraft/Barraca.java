package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.RazaTerran.Marine;

public class Barraca extends CreadorDeSoldados {
	public Barraca(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 1000;
        this.tiempoDeConstruccion = 12;
        //Costo = 150M
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_SOLDADOS;
    }

    public Marine crearMarine() throws ExcepcionNoHaySuministrosDisponibles {
        return new Marine(this.propietario);
    }
}
