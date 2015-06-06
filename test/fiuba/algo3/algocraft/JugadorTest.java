package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;

import fiuba.algo3.algocraft.RazaTerran.NaveTransporte;
import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.Golliat;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import fiuba.algo3.algocraft.RazaTerran.NaveCiencia;
import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {

	@Test
	public void alCrearExtractorGasSeAgregaLaConstruccionEnElArrayDelJugador() throws ExcepcionRecursosInsuficientes {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		unJugador.crearExtractorGas();
		
		Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
	}
	
	@Test
	public void alCrearExtractorMineralSeAgregaLaConstruccionEnElArrayDelJugador() throws ExcepcionRecursosInsuficientes {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearExtractorMineral();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
    }

    @Test
    public void elJugadorEmpiezaConLaCantidadDeMineralesInicial() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL);
    }

    @Test
    public void elJugadorEmpiezaConLaCantidadDeGasVespenoInicial() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.obtenerGasVespeno(), Jugador.GAS_VESPENO_INICIAL);
    }

    @Test
    public void elJugadorComienzaConLaCapacidadDePoblacionInicial() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.capacidadDePoblacion(), Jugador.CAPACIDAD_DE_POBLACION_INICIAL);
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
    public void crearCreadorDeGasLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorGas();
    }
  
    @Test
    public void crearExtractorDeGasRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearExtractorGas();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Refineria.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeMineralesLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorMineral();
    }
    
    @Test
    public void crearExtractorDeMineralRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearExtractorMineral();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - CentroDeMineral.COSTO.getCostoMineral());
    }
    
    
    @Test
    public void tieneConstruccionDeTipoDevuelveFalseSiNoSeCreoNada() throws ExcepcionRecursosInsuficientes {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_GAS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_MINERAL));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElAdicionalDeSuministros() throws ExcepcionRecursosInsuficientes{
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearAdicionalDeSuministro();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElExtractorGas() throws ExcepcionRecursosInsuficientes{
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearExtractorGas();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_GAS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElExtractorMineral() throws ExcepcionRecursosInsuficientes{
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearExtractorMineral();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_MINERAL));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeSoldados() throws ExcepcionRecursosInsuficientes{
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeSoldados();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeUnidadesTerrestres() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeUnidadesAereas() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        unJugador.crearCreadorDeUnidadesAereas();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS));
    }

    @Test(expected = ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesTerrestresSinTenerCreadorDeSoldadosLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeUnidadesTerrestres();
    }

    @Test(expected = ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesAereasSinTenerCreadorDeUnidadesTerrestresLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeUnidadesAereas();
    }

    @Test
    public void elJugadorComienzaConPoblacionInicialCorrecta() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL);
    }

    @Test(expected = ExcepcionNoHaySuministrosDisponibles.class)
    public void crearUnidadSinSuministrosLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;

        unJugador.sumarMinerales(250);
        barraca = (Barraca) unJugador.crearCreadorDeSoldados();
        barraca.crearMarine();
    }

    @Test
    public void crearMarineSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;

        unJugador.sumarMinerales(250);
        unJugador.crearAdicionalDeSuministro();
        barraca = (Barraca) unJugador.crearCreadorDeSoldados();
        barraca.crearMarine();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + Marine.SUMINISTRO);
    }

    @Test
     public void crearGolliatSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Fabrica fabrica;

        unJugador.sumarMinerales(450);
        unJugador.sumarGasVespeno(100);
        unJugador.crearAdicionalDeSuministro();
        unJugador.crearCreadorDeSoldados();

        fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesTerrestres();
        fabrica.crearGolliat();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + Golliat.SUMINISTRO);
    }

    @Test
    public void crearNaveCienciaSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        PuertoEstelar puerto;

        unJugador.sumarMinerales(600);
        unJugador.sumarGasVespeno(200);
        unJugador.crearAdicionalDeSuministro();
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas();
        puerto.crearNaveCiencia();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + NaveCiencia.SUMINISTRO);
    }

    @Test
    public void crearEspectroSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        PuertoEstelar puerto;

        unJugador.sumarMinerales(600);
        unJugador.sumarGasVespeno(200);
        unJugador.crearAdicionalDeSuministro();
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas();
        puerto.crearEspectro();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + Espectro.SUMINISTRO);
    }

    @Test
    public void crearNaveTransporteSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        PuertoEstelar puerto;

        unJugador.sumarMinerales(600);
        unJugador.sumarGasVespeno(200);
        unJugador.crearAdicionalDeSuministro();
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas();
        puerto.crearEspectro();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + NaveTransporte.SUMINISTRO);
    }

    //Los demas tambien tienen que hacer lo mismo
}
