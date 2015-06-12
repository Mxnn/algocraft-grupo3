package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.protoss.construcciones.*;
import fiuba.algo3.algocraft.terran.construcciones.*;
import fiuba.algo3.algocraft.terran.unidades.*;

import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {
    public static int RECURSOS_SUFFICIENTES = 1000;
	@Test
	public void alCrearExtractorGasSeAgregaLaConstruccionEnElArrayDelJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
		Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
		unJugador.crearExtractorGas(mapa, ubicacionVolcan);
		
		Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
	}
	
	@Test
	public void alCrearExtractorMineralSeAgregaLaConstruccionEnElArrayDelJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
        unJugador.crearExtractorMineral(mapa, ubicacionMineral);

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
    public void crearDepositoDeSuministrosAumentaPoblacionDelJugadorEn5YSumaConstruccionesAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
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
    public void creadorDeSoldadosCreaEdificioCreadorDeSoldados() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
    }

    @Test
    public void creadorDeUnidadesTerrestresCreaEdificioCreadorDeUnidadesTerrestres() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 2);
    }

    @Test
    public void creadorDeUnidadesAereasCreaEdificioCreadorDeUniadesAereas() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
  
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 4));

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 3);
    }
    @Test
    public void sePuedeSumarGazVespeno() throws ExcepcionRecursosInsuficientes {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);

    	Assert.assertEquals(unJugador.obtenerGasVespeno(), Jugador.GAS_VESPENO_INICIAL + RECURSOS_SUFFICIENTES);
    }
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeGasLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorGas(mapa, ubicacionVolcan);
    }

    @Test
    public void crearExtractorDeGasRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
    	unJugador.crearExtractorGas(mapa, ubicacionVolcan);

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Refineria.COSTO.getCostoMineral());
    }
    @Test
    public void crearExtractorDeMineralRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
    	unJugador.crearExtractorMineral(mapa, ubicacionMineral);

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - CentroDeMineral.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeMineralesLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
        unJugador.crearExtractorMineral(mapa, ubicacionMineral);
    }
    
    @Test
    public void crearAdicionalDeSuministrosRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearAdicionalDeSuministro(mapa, new Coordenada (1, 1));

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - DepositoSuministro.COSTO.getCostoMineral());
    }
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearAdicionalDeSuministrosLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada (1, 1));
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeSoldadosLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
    }
    
    @Test
    public void crearCreadorDeSoldadosRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Barraca.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesTerrestresLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
    	unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));  //construction requirida para crear el creador de unidades terrestres
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Barraca.COSTO.getCostoMineral());
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));
    }
    
    @Test
    public void crearCreadorDeUnidadesTerrestresRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);     
    	unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));   //construction requirida para crear el creador de unidades terrestres
  
    	unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Barraca.COSTO.getCostoMineral() - Fabrica.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesAereasLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Barraca.COSTO.getCostoMineral() + Fabrica.COSTO.getCostoMineral());
        unJugador.sumarGasVespeno(-Jugador.GAS_VESPENO_INICIAL + Fabrica.COSTO.getCostoGas());

        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));  //construction requirida para crear el creador de unidades terrestres
    	unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 4));
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 3));
    }
    
    @Test
    public void crearCreadorDeUnidadesAereasRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);     
    	unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));   //construction requirida para crear el creador de unidades terrestres
    	unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 4));
    	
    	unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 3));

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Barraca.COSTO.getCostoMineral() - Fabrica.COSTO.getCostoMineral() - PuertoEstelar.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeGasParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);

        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorGas(mapa, ubicacionVolcan);
    }

    @Test
    public void crearExtractorDeGasParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
    	unJugador.crearExtractorGas(mapa, ubicacionVolcan);

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Asimilador.COSTO.getCostoMineral());
    }
    @Test
    public void crearExtractorDeMineralParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
    	unJugador.crearExtractorMineral(mapa, ubicacionMineral);

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL -  NexoMineral.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeMineralesParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorMineral(mapa, ubicacionMineral);
    }
    
    @Test
    public void crearAdicionalDeSuministrosParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

    	unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Pilon.COSTO.getCostoMineral());
    }
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearAdicionalDeSuministrosParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeSoldadosParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
    }
    
    @Test
    public void crearCreadorDeSoldadosParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

    	unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL - Acceso.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesAereasParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

    	unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));  //construction requirida para crear el creador de unidades terrestres
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Acceso.COSTO.getCostoMineral());
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 2));
    }
    
    @Test
    public void crearCreadorDeUnidadesAereasParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);     
    	unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));   //construction requirida para crear el creador de unidades terrestres
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 1));
  
    	unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 3));

    	Assert.assertEquals(unJugador.obtenerMineral(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Acceso.COSTO.getCostoMineral() - ArchivosTemplarios.COSTO.getCostoMineral() - PuertoEstelarProtoss.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesTerrestresParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Acceso.COSTO.getCostoMineral() + ArchivosTemplarios.COSTO.getCostoMineral());
        unJugador.sumarGasVespeno(-Jugador.GAS_VESPENO_INICIAL + PuertoEstelarProtoss.COSTO.getCostoGas());
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));  //construction requirida para crear el creador de unidades terrestres
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 4));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));
    }
    
    @Test
    public void crearCreadorDeUnidadesTerrestresParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);     
    	unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));   //construction requirida para crear el creador de unidades terrestres
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 4));

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
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElAdicionalDeSuministros() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElExtractorGas() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));

        unJugador.crearExtractorGas(mapa, ubicacionVolcan);

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_GAS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElExtractorMineral() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
        unJugador.crearExtractorMineral(mapa, ubicacionMineral);

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_MINERAL));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeSoldados() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_SOLDADOS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeUnidadesTerrestres() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeUnidadesAereas() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 4));

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS));
    }

    @Test(expected = ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesTerrestresSinTenerCreadorDeSoldadosLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 4));
    }

    @Test(expected = ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesAereasSinTenerCreadorDeUnidadesTerrestresLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 2));
    }

    @Test
    public void elJugadorComienzaConPoblacionInicialCorrecta() {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL);
    }

    @Test(expected = ExcepcionNoHaySuministrosDisponibles.class)
    public void crearUnidadSinSuministrosLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;

        unJugador.sumarMinerales(250);
        barraca = (Barraca) unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        barraca.crearMarine(mapa);
    }

    @Test
    public void crearMarineSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;
        Marine marine;

        unJugador.sumarMinerales(250);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        barraca = (Barraca) unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        marine = barraca.crearMarine(mapa);

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + marine.SUMINISTRO);
    }

    @Test
     public void crearGolliatSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        Fabrica fabrica;
        Golliat golliat;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));

        fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));
        golliat = fabrica.crearGolliat(mapa);

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + golliat.SUMINISTRO);
    }

    @Test
    public void crearNaveCienciaSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        PuertoEstelar puerto;
        NaveCiencia nave;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 4));
        nave = puerto.crearNaveCiencia(mapa);

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + nave.SUMINISTRO);
    }

    @Test
    public void crearEspectroSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        PuertoEstelar puerto;
        Espectro espectro;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 3));

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 4));
        espectro = puerto.crearEspectro(mapa);

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + espectro.SUMINISTRO);
    }

    @Test
    public void crearNaveTransporteSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        PuertoEstelar puerto;
        NaveTransporteTerran nave;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 4));

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 3));
        nave = puerto.crearNaveTransporte(mapa);

        Assert.assertEquals(unJugador.obtenerPoblacion(), Jugador.POBLACION_INICIAL + nave.SUMINISTRO);
    }

    @Test
    public void agregarUnidadAgregaUnaUnidadAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;

        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        barraca = (Barraca) unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        barraca.crearMarine(mapa);

        Assert.assertEquals(unJugador.cantidadDeUnidades(), 1);
    }

    @Test
    public void destruirUnaUnidadRestaPoblacionAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca;
        Marine marine;

        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        barraca = (Barraca) unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        marine = barraca.crearMarine(mapa);

        Assert.assertEquals(unJugador.cantidadDeUnidades(), 1);
        Assert.assertEquals(unJugador.obtenerPoblacion(),  marine.SUMINISTRO);

        marine.destruir();

        Assert.assertEquals(unJugador.cantidadDeUnidades(), 0);
        Assert.assertEquals(unJugador.obtenerPoblacion(), 0);
    }

    @Test
    public void destruirUnAdicionalDeSuministrosRestaPoblacionPeroNoEliminaUnidades() throws ExcepcionRecursosInsuficientes, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
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

    @Test
    public void crearAdicionalSuministrosUbicaALaConstruccionEnElMapa() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        DepositoSuministro deposito;

        deposito = (DepositoSuministro) unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertSame(deposito, mapa.devolverElementoEnParcela(new Coordenada(1, 1)));
    }
}