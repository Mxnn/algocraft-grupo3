package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.protoss.unidades.AltoTemplario;

import java.util.ArrayList;

public class ArchivosTemplarios extends CreadorDeUnidadesAereas {

    private static final int VIDA_INICIAL = 500;
    private static final int ESCUDO_INICIAL = 500;
    public static int COSTO_MINERAL= 150;
    public static int COSTO_GAZ = 200;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAZ);
    
    
    public ArchivosTemplarios(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();

        this.propietario = propietario;
        this.estado = new EstadoProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.tiempoDeConstruccion = 9;

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS;
    }

    public AltoTemplario crearAltoTemplario(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
//        Boolean elementoUbicado = false;
//        ArrayList<Coordenada> coordenadasVecinas = ((this.parcelaUbicacion).getCoordenada()).obtenerCoordenadasVecinas();
        AltoTemplario altoTemplario = new AltoTemplario(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, altoTemplario);
//        while (!elementoUbicado && coordenadasVecinas.size() > 0) {
//            try {
//                mapa.ubicarElementoEnParcela(coordenadasVecinas.get(0), altoTemplario);
//            }
//            catch (ExcepcionElementoNoAdmitidoEnParcela e) {
//                coordenadasVecinas.remove(0);
//                continue;
//            }
//            catch (ExcepcionParcelaOcupada e) {
//                coordenadasVecinas.remove(0);
//                continue;
//            }
//            catch (ExcepcionCoordenadaFueraDelMapa excepcionCoordenadaFueraDelMapa) {
//                coordenadasVecinas.remove(0);
//                continue;
//            }
//            elementoUbicado = true;
//        }
//
//        if (coordenadasVecinas.size() <= 0)
//            throw new ExcepcionNoHayLugarDisponible();

        return altoTemplario;
    }
}