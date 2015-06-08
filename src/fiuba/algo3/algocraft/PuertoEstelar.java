package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.NaveCiencia;
import fiuba.algo3.algocraft.RazaTerran.NaveTransporte;

public class PuertoEstelar extends CreadorDeUnidadesAereas {
	
    public static int COSTO_MINERAL= 150;
    public static int COSTO_GAZ = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    public PuertoEstelar(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas{
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();

        this.propietario = propietario;
        this.vida = 1300;
        this.tiempoDeConstruccion = 10;

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS;
    }

    public Espectro crearEspectro() throws ExcepcionNoHaySuministrosDisponibles {
        return new Espectro(this.propietario);
    }

    public NaveTransporte crearNaveTransporte() throws ExcepcionNoHaySuministrosDisponibles {
        return new NaveTransporte(this.propietario);
    }

    public NaveCiencia crearNaveCiencia() throws ExcepcionNoHaySuministrosDisponibles {
        return new NaveCiencia(this.propietario);
    }
}
