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
	
	@Test
	public void AlCrearExtractorMineralSeAgregaLaConstruccionEnElArrayDelJugador() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearExtractorMineral();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
    }

    @Test
    public void elJugadorEmpiezaCon200DeMinerales() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.obtenerMineral(), 200);
    }

    @Test
    public void elJugadorEmpiezaCon0GasVespeno() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.obtenerGasVespeno(), 0);
    }
}
