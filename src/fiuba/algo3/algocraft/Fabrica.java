package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.RazaTerran.Golliat;

public class Fabrica extends CreadorDeUnidadesTerrestres {
    public Fabrica(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();

        this.propietario = propietario;
        this.vida = 1250;
        this.tiempoDeConstruccion = 12;
        //Costo = 200M/100G
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES;
    }

    public Golliat crearGolliat() throws ExcepcionNoHaySuministrosDisponibles {
        return new Golliat(this.propietario);
    }
}
