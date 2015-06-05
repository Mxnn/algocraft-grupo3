package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;

import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {

	@Test
	public void AlCrearExtractorGasSeAgregaLaConstruccionEnElArrayDelJugador() throws ExcepcionRecursosInsuficientes{
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

        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 2);
    }

    @Test
    public void creadorDeUnidadesAereasCreaEdificioCreadorDeUniadesAereas() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        unJugador.crearCreadorDeUnidadesAereas();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 3);
    }
   
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void siElJugadorNoTieneSuficamenteRecursosNoSeCreaElExtractorDeGaz() throws ExcepcionRecursosInsuficientes{
    	Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );
    	unJugador.setMineral(0);
    	
    	unJugador.crearExtractorGas();
    	
    }
  
    @Test
    public void CreandoElExtractorGasSeSacanLosMineralesDelJugador() throws ExcepcionRecursosInsuficientes{
    	Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );
    	unJugador.setMineral(120);
    	unJugador.crearExtractorGas();

    	Assert.assertEquals(unJugador.obtenerMineral(),20);
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveFalseSiNoSeCreoNada() throws ExcepcionRecursosInsuficientes{
        Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );

        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_GAS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_MINERAL));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElAdicionalDeSuministros() throws ExcepcionRecursosInsuficientes{
        Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );

        unJugador.crearAdicionalDeSuministro();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElExtractorGas() throws ExcepcionRecursosInsuficientes{
        Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );

        unJugador.crearExtractorGas();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_GAS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElExtractorMineral() throws ExcepcionRecursosInsuficientes{
        Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );

        unJugador.crearExtractorMineral();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_MINERAL));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeSoldados() throws ExcepcionRecursosInsuficientes{
        Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );

        unJugador.crearCreadorDeSoldados();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeUnidadesTerrestres() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );

        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeUnidadesAereas() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );

        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        unJugador.crearCreadorDeUnidadesAereas();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS));
    }

    @Test(expected= ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesTerrestresSinTenerCreadorDeSoldadosLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );

        unJugador.crearCreadorDeUnidadesTerrestres();
    }

    @Test(expected= ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesAereasSinTenerCreadorDeUnidadesTerrestresLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO,Terran.getInstance() );

        unJugador.crearCreadorDeUnidadesAereas();
    }

}
