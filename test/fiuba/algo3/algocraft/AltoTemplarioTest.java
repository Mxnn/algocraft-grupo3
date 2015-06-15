package fiuba.algo3.algocraft;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.razas.protoss.unidades.Zealot;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.unidades.Ataque;

import org.junit.Assert;
import org.junit.Test;

public class AltoTemplarioTest {
    @Test(expected = ExcepcionUnidadEnemiga.class)
    public void alucionacionLanzaExcpecionSiLaUnidadNoEsPropia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionUnidadEnemiga, CloneNotSupportedException, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionEnergiaInsuficiente {
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
        acceso = (Acceso) jugador1.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(1, 2));
        zealot = acceso.crearZealot(mapa);

        jugador2.crearAdicionalDeSuministro(mapa, new Coordenada(18, 18));
        jugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(19, 19));
        jugador2.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(18, 19));
        archivo = (ArchivosTemplarios) jugador2.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(19, 18));
        altoTemplario = archivo.crearAltoTemplario(mapa);
        for (int i = 0; i < 6; i++) 
        	altoTemplario.regenerarEnergia();

        altoTemplario.crearAlucinacion(zealot, mapa);
    }
    
    @Test(expected = ExcepcionEnergiaInsuficiente.class)
    public void alucionacionLanzaExcpecionSiNoAlcanazaLaEnergia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionUnidadEnemiga, CloneNotSupportedException, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionEnergiaInsuficiente {
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
        acceso = (Acceso) jugador1.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(1, 2));
        zealot = acceso.crearZealot(mapa);

        jugador2.crearAdicionalDeSuministro(mapa, new Coordenada(18, 18));
        jugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(19, 19));
        jugador2.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(18, 19));
        archivo = (ArchivosTemplarios) jugador2.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(19, 18));
        altoTemplario = archivo.crearAltoTemplario(mapa);

        altoTemplario.crearAlucinacion(zealot, mapa);
    }
    
    @Test(expected = ExcepcionEnergiaInsuficiente.class)
    public void tormentaPsionicaLanzaExcpecionSiNoAlcanazaLaEnergia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionUnidadEnemiga, CloneNotSupportedException, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionEnergiaInsuficiente, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     
	     AltoTemplario templario = new AltoTemplario(unJugador);
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     Ataque ataque = templario.lanzarTormentaPsionica(listaParcelas);
	     ataque.ejecutarAtaque();
    }
    
}
