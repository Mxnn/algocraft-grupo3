package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;

public class ObjetoMain {
	 public static void main(String[] args) throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada{
		 Juego elJuego = new Juego();
		 elJuego.setMapaParaTests(); //para saber bien la vista
		 Controlador unControlador = new Controlador(elJuego);

		 VistaJuego vista = new VistaJuego(elJuego, unControlador);
		 //para probar que cuando metes un elemento, se muestra en las parcelas
		 Mapa mapa = elJuego.getMapa();
		 mapa.ubicarElementoEnParcela(new Coordenada(2,2), new Barraca(null) );
		 vista.refrescar(mapa);
		 
	 }
}
