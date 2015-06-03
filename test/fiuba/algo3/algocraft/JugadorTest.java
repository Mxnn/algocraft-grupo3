package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;


public class JugadorTest {

	@Test
	public void AlCrearExtractorGasSeAgregaLaConstruccionEnElArrayDelJugador(){
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		unJugador.crearExtractorGas();
		
		Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
	}
}
