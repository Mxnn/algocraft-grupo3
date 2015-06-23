package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;

public class ObjetoMain {
	 public static void main(String[] args) throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
		 Juego elJuego = new Juego();
		 elJuego.setMapaParaTests(); //para saber bien la vista
		 Controlador unControlador = new Controlador(elJuego);

		 VistaJuego vista = new VistaJuego(elJuego, unControlador);
		 
		 //para probar que cuando metes un elemento, se muestra en las parcelas
		 Mapa mapa = elJuego.getMapa();
         Jugador jTerran = new Jugador("Juan", Color.CELESTE, Terran.getInstance());
         Jugador jProtoss = new Jugador("Pablo", Color.NARANJA, Protoss.getInstance());
		 mapa.ubicarElementoEnParcela(new Coordenada(2,2), new Barraca(jTerran));
		 mapa.ubicarElementoEnParcela(new Coordenada(3,3), new Acceso(jProtoss));
		 vista.refrescar(mapa);
	 }
}
