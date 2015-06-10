package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.RazaProtoss.NaveTransporteProtoss;
import fiuba.algo3.algocraft.RazaProtoss.Scout;


public class PuertoEstelarProtoss extends CreadorDeUnidadesAereas{
    private static final int VIDA_INICIAL = 600;
    private static final int ESCUDO_INICIAL = 600;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
	public PuertoEstelarProtoss(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas{
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
		this.propietario = propietario;
        this.estado = new EstadoProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
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



