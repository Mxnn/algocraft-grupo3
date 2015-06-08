package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.CreadorDeUnidadesAereas;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.RazaProtoss.NaveTransporteProtoss;
import fiuba.algo3.algocraft.RazaProtoss.Scout;


public class PuertoEstelarProtoss extends CreadorDeUnidadesAereas{
    public static int COSTO_MINERAL= 150;
    public static int COSTO_GAZ = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    
	public PuertoEstelarProtoss(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas{
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
		this.propietario = propietario;
        this.vida = 600;
        //escudo = 600
        this.tiempoDeConstruccion = 10;

	}
        
    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS;
    }
    
    public Scout crearScout() throws ExcepcionNoHaySuministrosDisponibles {
        return new Scout(this.propietario);
    }
    
    public NaveTransporteProtoss crearNaveTransporte() throws ExcepcionNoHaySuministrosDisponibles {
        return new NaveTransporteProtoss(this.propietario);
    }
 }



