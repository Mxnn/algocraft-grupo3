package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.CreadorDeUnidadesAereas;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.RazaProtoss.NaveTransporteP;
import fiuba.algo3.algocraft.RazaProtoss.Scout;


public class PuertoEstelarP extends CreadorDeUnidadesAereas{
	public PuertoEstelarP(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas{
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
		this.propietario = propietario;
        this.vida = 600;
        //escudo = 600
        this.tiempoDeConstruccion = 10;
        //Costo = 150M / 150G
	}
        
    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS;
    }
    
    public Scout crearScout() throws ExcepcionNoHaySuministrosDisponibles {
        return new Scout(this.propietario);
    }
    
    public NaveTransporteP crearSNaveTransporte() throws ExcepcionNoHaySuministrosDisponibles {
        return new NaveTransporteP(this.propietario);
    }
 }



