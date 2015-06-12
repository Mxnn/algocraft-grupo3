package fiuba.algo3.algocraft.terran.construcciones;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.CreadorDeUnidadesAereas;
import fiuba.algo3.algocraft.Estado;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.Mapa;
import fiuba.algo3.algocraft.TipoDeConstruccion;
import fiuba.algo3.algocraft.Excepciones.*;
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
        this.estado = new Estado(VIDA_INICIAL);
        this.tiempoDeConstruccion = 10;

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS;
    }

    public Espectro crearEspectro(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
//        Boolean elementoUbicado = false;
//        ArrayList<Coordenada> coordenadasVecinas = ((this.parcelaUbicacion).getCoordenada()).obtenerCoordenadasVecinas();
        Espectro espectro = new Espectro(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, espectro);
//        while (!elementoUbicado && coordenadasVecinas.size() > 0) {
//            try {
//                mapa.ubicarElementoEnParcela(coordenadasVecinas.get(0), espectro);
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

        return espectro;
    }

    public NaveTransporteTerran crearNaveTransporte(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
//        Boolean elementoUbicado = false;
//        ArrayList<Coordenada> coordenadasVecinas = ((this.parcelaUbicacion).getCoordenada()).obtenerCoordenadasVecinas();
        NaveTransporteTerran nave = new NaveTransporteTerran(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, nave);
//        while (!elementoUbicado && coordenadasVecinas.size() > 0) {
//            try {
//                mapa.ubicarElementoEnParcela(coordenadasVecinas.get(0), nave);
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

        return nave;
    }

    public NaveCiencia crearNaveCiencia(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
//        Boolean elementoUbicado = false;
//        ArrayList<Coordenada> coordenadasVecinas = ((this.parcelaUbicacion).getCoordenada()).obtenerCoordenadasVecinas();
        NaveCiencia nave = new NaveCiencia(this.propietario);
        mapa.ubicarCercaDeParceala(parcelaUbicacion, nave);
//        while (!elementoUbicado && coordenadasVecinas.size() > 0) {
//            try {
//                mapa.ubicarElementoEnParcela(coordenadasVecinas.get(0), nave);
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

        return nave;
    }
}
