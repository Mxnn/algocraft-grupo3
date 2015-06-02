package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;


public class JugadorTest {

	@Test
	public void AlCrearExtractorGazSeAgarraLaConstruccionEnElArrayDelJugador(){
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		unJugador.crearExtractorGaz();
		
		Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
	}
}
