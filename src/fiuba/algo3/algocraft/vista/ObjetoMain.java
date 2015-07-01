package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.controlador.ClickEnParcelaListener;
import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.observadores.juego.VistaJuego;
import fiuba.algo3.algocraft.vista.observadores.mapa.ObservadorMapa;

public class ObjetoMain {
	 public static void main(String[] args) throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
		 Juego elJuego = new Juego();
//		 elJuego.setMapaParaTests(); //para saber bien la vista
		 ClickEnParcelaListener unControlador = new ClickEnParcelaListener(elJuego);

		 VistaJuego vista = VistaJuego.createInstance(elJuego, unControlador);
		 
		 ObservadorMapa observador = vista.getObservadorMapa();
		 
		 elJuego.setObservadores(observador, vista);
		 
		 unControlador.setObservadores(observador);
		 
		 unControlador.setVistaJuego(vista);
		 
		 vista.abrirVista();
		 vista.getBarraLateral().setVisible(false);
		 
		 //para probar que cuando metes un elemento, se muestra en las parcelas
//		 Mapa mapa = elJuego.getMapa();
//         Jugador jTerran = new Jugador("Juan", Color.BLANCO, Terran.getInstance());
//         Jugador jProtoss = new Jugador("Pablo", Color.CELESTE, Protoss.getInstance());
//		 
//		 mapa.ubicarElementoEnParcela(new Coordenada(2,2), new Barraca(jTerran));
//		 mapa.ubicarElementoEnParcela(new Coordenada(3,3), new Acceso(jProtoss));
//		 vista.refrescar(mapa);
	 }
}
