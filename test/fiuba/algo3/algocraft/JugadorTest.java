package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
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
    public void elJugadorEmpiezaConCeroGasVespeno() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.obtenerGasVespeno(), 0);
    }

    @Test
    public void elJugadorComienzaConCeroDeCapacidadDePoblacion() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.capacidadDePoblacion(), 0);
    }

    @Test
    public void crearDepositoDeSuministrosAumentaPoblacionDelJugadorEn5YSumaConstruccionesAlJugador() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearAdicionalDeSuministro();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
        Assert.assertEquals(unJugador.capacidadDePoblacion(), 5);
    }

    @Test
    public void incrementarCapacidadDePoblacionNoSumaMasDeLaPoblacionMaxima() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.incrementarCapacidadDePoblacion(205);

        Assert.assertEquals(unJugador.capacidadDePoblacion(), Jugador.CAPACIDAD_DE_POBLACION_MAXIMA);
    }

    @Test
      public void creadorDeSoldadosCreaEdificioCreadorDeSoldados() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeSoldados();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
    }

    @Test
    public void creadorDeUnidadesTerrestresCreaEdificioCreadorDeUnidadesTerrestres() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeUnidadesTerrestres();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
    }

    @Test
    public void creadorDeUnidadesAereasCreaEdificioCreadorDeUniadesAereas() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeUnidadesAereas();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
    }
}
