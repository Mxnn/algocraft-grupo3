package fiuba.algo3.algocraft.razas.protoss.construcciones;

import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;
import fiuba.algo3.algocraft.razas.protoss.unidades.AltoTemplario;

public class ArchivosTemplarios extends Construccion {

    private static final int TIEMPO_DE_CONSTRUCCION = 9;
    private static final int VIDA_INICIAL = 500;
    private static final int ESCUDO_INICIAL = 500;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 200;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
    public ArchivosTemplarios(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION);

        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
    }

    @Override
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_MAGICAS;
    }

    public AltoTemplario crearAltoTemplario(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        AltoTemplario altoTemplario = new AltoTemplario(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, altoTemplario);

        return altoTemplario;
    }
}