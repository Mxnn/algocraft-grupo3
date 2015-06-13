package fiuba.algo3.algocraft.terran.construcciones;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.terran.unidades.Espectro;
import fiuba.algo3.algocraft.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.terran.unidades.NaveTransporteTerran;

public class PuertoEstelar extends Construccion {

    private static final int TIEMPO_DE_CONSTRUCCION = 10;
    private static final int VIDA_INICIAL = 1300;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public PuertoEstelar(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION);

        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_MAGICAS;
    }

    public Espectro crearEspectro(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        Espectro espectro = new Espectro(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, espectro);

        return espectro;
    }

    public NaveTransporteTerran crearNaveTransporte(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        NaveTransporteTerran nave = new NaveTransporteTerran(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, nave);

        return nave;
    }

    public NaveCiencia crearNaveCiencia(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        NaveCiencia nave = new NaveCiencia(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, nave);

        return nave;
    }
}
