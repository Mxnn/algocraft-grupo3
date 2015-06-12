package fiuba.algo3.algocraft.terran.construcciones;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.CreadorDeUnidadesAereas;
import fiuba.algo3.algocraft.Vitalidad;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.Mapa;
import fiuba.algo3.algocraft.TipoDeConstruccion;
import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.terran.unidades.Espectro;
import fiuba.algo3.algocraft.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.terran.unidades.NaveTransporteTerran;

public class PuertoEstelar extends CreadorDeUnidadesAereas {

    private static final int VIDA_INICIAL = 1300;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public PuertoEstelar(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas{
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();

        this.propietario = propietario;
        this.vitalidad = new Vitalidad(VIDA_INICIAL);
        this.tiempoDeConstruccion = 10;

    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS;
    }

    public Espectro crearEspectro(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Espectro espectro = new Espectro(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, espectro);

        return espectro;
    }

    public NaveTransporteTerran crearNaveTransporte(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        NaveTransporteTerran nave = new NaveTransporteTerran(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, nave);

        return nave;
    }

    public NaveCiencia crearNaveCiencia(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        NaveCiencia nave = new NaveCiencia(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, nave);

        return nave;
    }
}
