package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.protoss.unidades.Zealot;

import org.junit.Test;

public class AltoTemplarioTest {
    @Test(expected = ExcepcionUnidadEnemiga.class)
    public void alucionacionLanzaExcpecionSiLaUnidadNoEsPropia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionUnidadEnemiga, CloneNotSupportedException, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa(2, 20, 20);
        Jugador jugador1 = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador jugador2 = new Jugador("Pablo", Color.AZUL, Protoss.getInstance());
        ArchivosTemplarios archivo;
        Acceso acceso;
        Zealot zealot;
        AltoTemplario altoTemplario;

        jugador1.sumarMinerales(999);
        jugador1.sumarGasVespeno(999);
        jugador2.sumarMinerales(999);
        jugador2.sumarGasVespeno(999);

        jugador1.crearAdicionalDeSuministro(mapa, new Coordenada(2, 2));
        acceso = (Acceso) jugador1.crearCreadorDeSoldados(mapa, new Coordenada(1, 2));
        zealot = acceso.crearZealot(mapa);

        jugador2.crearAdicionalDeSuministro(mapa, new Coordenada(18, 18));
        jugador2.crearCreadorDeSoldados(mapa, new Coordenada(19, 19));
        jugador2.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada (18, 19));
        archivo = (ArchivosTemplarios) jugador2.crearCreadorDeUnidadesAereas(mapa, new Coordenada (19, 18));
        altoTemplario = archivo.crearAltoTemplario(mapa);

        altoTemplario.crearAlucinacion(zealot, mapa);
    }
}
