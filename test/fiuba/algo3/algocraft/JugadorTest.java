package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.ConstruccionesProtoss.*;
import fiuba.algo3.algocraft.Excepciones.*;

import fiuba.algo3.algocraft.RazaTerran.*;
import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {
    public static int RECURSOS_SUFFICIENTES = 1000;
	@Test
	public void alCrearExtractorGasSeAgregaLaConstruccionEnElArrayDelJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa {
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
    public void crearDepositoDeSuministrosAumentaPoblacionDelJugadorEn5YSumaConstruccionesAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

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
      public void creadorDeSoldadosCreaEdificioCreadorDeSoldados() throws ExcepcionRecursosInsuficientes {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeSoldados();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
    }

    @Test
    public void creadorDeUnidadesTerrestresCreaEdificioCreadorDeUnidadesTerrestres() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 2);
    }

    @Test
    public void creadorDeUnidadesAereasCreaEdificioCreadorDeUniadesAereas() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
  
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        unJugador.crearCreadorDeUnidadesAereas();

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 3);
    }
    @Test
    public void sePuedeSumarGazVespeno() throws ExcepcionRecursosInsuficientes {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);

    	Assert.assertEquals(unJugador.obtenerGasVespeno(), Jugador.GAS_VESPENO_INICIAL + RECURSOS_SUFFICIENTES);
    }
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeGasLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionCoordenadaFueraDelMapa {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorGas();
    }
  

    
    @Test
    public void crearExtractorDeGasRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearExtractorGas();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Refineria.COSTO.getCostoMineral());
    }
    @Test
    public void crearExtractorDeMineralRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearExtractorMineral();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - CentroDeMineral.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeMineralesLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorMineral();
    }
    
    
    @Test
    public void crearAdicionalDeSuministrosRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearAdicionalDeSuministro(mapa, new Coordenada (1, 1));

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - DepositoSuministro.COSTO.getCostoMineral());
    }
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearAdicionalDeSuministrosLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada (1, 1));
    }
    

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeSoldadosLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearCreadorDeSoldados();
    }
    
    @Test
    public void crearCreadorDeSoldadosRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearCreadorDeSoldados();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Barraca.COSTO.getCostoMineral());
    }

    
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesTerrestresLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
    	unJugador.crearCreadorDeSoldados();  //construction requirida para crear el creador de unidades terrestres   
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Barraca.COSTO.getCostoMineral());
        unJugador.crearCreadorDeUnidadesTerrestres();
    }
    
    @Test
    public void crearCreadorDeUnidadesTerrestresRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);     
    	unJugador.crearCreadorDeSoldados();   //construction requirida para crear el creador de unidades terrestres    
 
  
    	unJugador.crearCreadorDeUnidadesTerrestres();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Barraca.COSTO.getCostoMineral() - Fabrica.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesAereasLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Barraca.COSTO.getCostoMineral() + Fabrica.COSTO.getCostoMineral());
        unJugador.sumarGasVespeno(-Jugador.GAS_VESPENO_INICIAL + Fabrica.COSTO.getCostoGas());
        unJugador.crearCreadorDeSoldados();  //construction requirida para crear el creador de unidades terrestres   
    	unJugador.crearCreadorDeUnidadesTerrestres();
        unJugador.crearCreadorDeUnidadesAereas();
    }
    
    @Test
    public void crearCreadorDeUnidadesAereasRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);     
    	unJugador.crearCreadorDeSoldados();   //construction requirida para crear el creador de unidades terrestres    
    	unJugador.crearCreadorDeUnidadesTerrestres();
    	
    	unJugador.crearCreadorDeUnidadesAereas();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Barraca.COSTO.getCostoMineral() - Fabrica.COSTO.getCostoMineral() - PuertoEstelar.COSTO.getCostoMineral());
    }
    
    
    
    
    
    
    
    
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeGasParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionCoordenadaFueraDelMapa {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorGas();
    }
  

    
    @Test
    public void crearExtractorDeGasParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

    	unJugador.crearExtractorGas();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Asimilador.COSTO.getCostoMineral());
    }
    @Test
    public void crearExtractorDeMineralParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

    	unJugador.crearExtractorMineral();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL -  NexoMineral.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeMineralesParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorMineral();
    }
    
    
    @Test
    public void crearAdicionalDeSuministrosParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

    	unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Pilon.COSTO.getCostoMineral());
    }
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearAdicionalDeSuministrosParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
    }
    

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeSoldadosParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearCreadorDeSoldados();
    }
    
    @Test
    public void crearCreadorDeSoldadosParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

    	unJugador.crearCreadorDeSoldados();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Acceso.COSTO.getCostoMineral());
    }

    
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesAereasParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
    	unJugador.crearCreadorDeSoldados();  //construction requirida para crear el creador de unidades terrestres   
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Acceso.COSTO.getCostoMineral());
        unJugador.crearCreadorDeUnidadesAereas();
    }
    
    @Test
    public void crearCreadorDeUnidadesAreasParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);     
    	unJugador.crearCreadorDeSoldados();   //construction requirida para crear el creador de unidades terrestres    
 
  
    	unJugador.crearCreadorDeUnidadesAereas();

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Acceso.COSTO.getCostoMineral() - PuertoEstelarProtoss.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesTerrestresParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Acceso.COSTO.getCostoMineral() + ArchivosTemplarios.COSTO.getCostoMineral());
        unJugador.sumarGasVespeno(-Jugador.GAS_VESPENO_INICIAL + PuertoEstelarProtoss.COSTO.getCostoGas());
        unJugador.crearCreadorDeSoldados();  //construction requirida para crear el creador de unidades terrestres   
        unJugador.crearCreadorDeUnidadesAereas();
        unJugador.crearCreadorDeUnidadesTerrestres();
       
    }
    
    @Test
    public void crearCreadorDeUnidadesTerrestresParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);     
    	unJugador.crearCreadorDeSoldados();   //construction requirida para crear el creador de unidades terrestres    
    	unJugador.crearCreadorDeUnidadesAereas();
    	unJugador.crearCreadorDeUnidadesTerrestres();
    	


    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Acceso.COSTO.getCostoMineral() - ArchivosTemplarios.COSTO.getCostoMineral() - PuertoEstelarProtoss.COSTO.getCostoMineral());
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
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElAdicionalDeSuministros() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElExtractorGas() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa {
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
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeUnidadesAereas() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        unJugador.crearCreadorDeUnidadesAereas();

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS));
    }

    @Test(expected = ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesTerrestresSinTenerCreadorDeSoldadosLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeUnidadesTerrestres();
    }

    @Test(expected = ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesAereasSinTenerCreadorDeUnidadesTerrestresLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeUnidadesAereas();
    }

    @Test
    public void elJugadorComienzaConPoblacionInicialCorrecta() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL);
    }

    @Test(expected = ExcepcionNoHaySuministrosDisponibles.class)
    public void crearUnidadSinSuministrosLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;

        unJugador.sumarMinerales(250);
        barraca = (Barraca) unJugador.crearCreadorDeSoldados();
        barraca.crearMarine();
    }

    @Test
    public void crearMarineSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;
        Marine marine;

        unJugador.sumarMinerales(250);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        barraca = (Barraca) unJugador.crearCreadorDeSoldados();
        marine = barraca.crearMarine();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + marine.SUMINISTRO);
    }

    @Test
     public void crearGolliatSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        Fabrica fabrica;
        Golliat golliat;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados();

        fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesTerrestres();
        golliat = fabrica.crearGolliat();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + golliat.SUMINISTRO);
    }

    @Test
    public void crearNaveCienciaSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        PuertoEstelar puerto;
        NaveCiencia nave;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas();
        nave = puerto.crearNaveCiencia();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + nave.SUMINISTRO);
    }

    @Test
    public void crearEspectroSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        PuertoEstelar puerto;
        Espectro espectro;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas();
        espectro = puerto.crearEspectro();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + espectro.SUMINISTRO);
    }

    @Test
    public void crearNaveTransporteSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        PuertoEstelar puerto;
        NaveTransporteTerran nave;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas();
        nave = puerto.crearNaveTransporte();

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + nave.SUMINISTRO);
    }

    @Test
    public void agregarUnidadAgregaUnaUnidadAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;

        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        barraca = (Barraca) unJugador.crearCreadorDeSoldados();
        barraca.crearMarine();

        Assert.assertEquals(unJugador.cantidadDeUnidades(), 1);
    }

    @Test
    public void destruirUnaUnidadRestaPoblacionAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;
        Marine marine;

        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        barraca = (Barraca) unJugador.crearCreadorDeSoldados();
        marine = barraca.crearMarine();

        Assert.assertEquals(unJugador.cantidadDeUnidades(), 1);
        Assert.assertEquals(unJugador.obtenerPoblacion(),  marine.SUMINISTRO);

        marine.destruir();

        Assert.assertEquals(unJugador.cantidadDeUnidades(), 0);
        Assert.assertEquals(unJugador.obtenerPoblacion(), 0);
    }

    @Test
    public void destruirUnAdicionalDeSuministrosRestaPoblacionPeroNoEliminaUnidades() throws ExcepcionRecursosInsuficientes, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        DepositoSuministro deposito;
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);

        deposito = (DepositoSuministro) unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        deposito.recibirDanyo(DepositoSuministro.VIDA_INICIAL + 1);

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 0);
        Assert.assertEquals(unJugador.capacidadDePoblacion(), 0);
    }
}