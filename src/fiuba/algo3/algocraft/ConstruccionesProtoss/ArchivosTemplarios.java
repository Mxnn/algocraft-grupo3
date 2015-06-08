package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.CreadorDeUnidadesTerrestres;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.RazaProtoss.AltoTemplario;

public class ArchivosTemplarios extends CreadorDeUnidadesTerrestres {
	
    public static int COSTO_MINERAL= 150;
    public static int COSTO_GAZ = 200;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    
    public ArchivosTemplarios(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();

        this.propietario = propietario;
        this.vida = 500;
        //escudo = 500
        this.tiempoDeConstruccion = 9;

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES;
    }

    public AltoTemplario crearAltoTemplario() throws ExcepcionNoHaySuministrosDisponibles {
        return new AltoTemplario(this.propietario);
    }
}
