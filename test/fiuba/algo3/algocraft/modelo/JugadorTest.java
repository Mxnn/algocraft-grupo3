package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Asimilador;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.NexoMineral;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Pilon;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.DepositoSuministro;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveTransporteTerran;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.AdicionalSuministros;

public class JugadorTest {
    public static int RECURSOS_SUFFICIENTES = 1000;
	@Test
	public void alCrearExtractorGasSeAgregaLaConstruccionEnElArrayDelJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
		Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
		unJugador.crearExtractorGas(mapa, ubicacionVolcan);
		
		Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
	}
	
	@Test
	public void alCrearExtractorMineralSeAgregaLaConstruccionEnElArrayDelJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
        unJugador.crearExtractorMineral(mapa, ubicacionMineral);

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
    }

    @Test
    public void elJugadorEmpiezaConLaCantidadDeMineralesInicial() throws ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL);
    }

    @Test
    public void elJugadorEmpiezaConLaCantidadDeGasVespenoInicial() throws ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.getGasVespeno(), Jugador.GAS_VESPENO_INICIAL);
    }

    @Test
    public void elJugadorComienzaConLaCapacidadDePoblacionInicial() throws ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.getCapacidadDePoblacion(), Jugador.CAPACIDAD_DE_POBLACION_INICIAL);
    }

    @Test
    public void crearDepositoDeSuministrosAumentaPoblacionDelJugadorEn5YSumaConstruccionesAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {
        Juego juego = new Juego();
    	Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
        Assert.assertEquals(unJugador.getCapacidadDePoblacion(), 5);
    }

    @Test
    public void creadorDeUnidadesBasicasCreaEdificioCreadorDeUnidadesBasicas() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 1);
    }

    @Test
    public void creadorDeUnidadesAvanzadasCreaEdificioCreadorDeUnidadesAvanzadas() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 2);
    }

    @Test
    public void creadorDeUnidadesMagicasCreaEdificioCreadorDeUniadesMagicas() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 3);
    }
    @Test
    public void sePuedeSumarGasVespeno() throws ExcepcionRecursosInsuficientes, ExcepcionNombreCorto {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);

    	Assert.assertEquals(unJugador.getGasVespeno(), Jugador.GAS_VESPENO_INICIAL + RECURSOS_SUFFICIENTES);
    }
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeGasLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorGas(mapa, ubicacionVolcan);
    }

    @Test
    public void crearExtractorDeGasRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
    	unJugador.crearExtractorGas(mapa, ubicacionVolcan);

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL - Refineria.COSTO.getCostoMineral());
    }

    @Test
    public void crearExtractorDeMineralRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
    	unJugador.crearExtractorMineral(mapa, ubicacionMineral);

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL - CentroDeMineral.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeMineralesLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
        unJugador.crearExtractorMineral(mapa, ubicacionMineral);
    }
    
    @Test
    public void crearAdicionalDeSuministrosRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearAdicionalDeSuministro(mapa, new Coordenada (1, 1));

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL - DepositoSuministro.COSTO.getCostoMineral());
    }
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearAdicionalDeSuministrosLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada (1, 1));
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesBasicasLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));
    }
    
    @Test
    public void crearCreadorDeUnidadesBasicasRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

    	unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL - Barraca.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesAvanzadasLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
    	unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));  //construction requirida para crear el creador de unidades terrestres
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Barraca.COSTO.getCostoMineral());
        unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));
    }
    
    @Test
    public void crearCreadorDeUnidadesAvanzadasRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);     

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 4));

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Barraca.COSTO.getCostoMineral() - Fabrica.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesMagicasLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Barraca.COSTO.getCostoMineral() + Fabrica.COSTO.getCostoMineral());
        unJugador.sumarGasVespeno(-Jugador.GAS_VESPENO_INICIAL + Fabrica.COSTO.getCostoGas());

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));
    }
    
    @Test
    public void crearCreadorDeUnidadesMagicasRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 4));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);
    	
    	unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 3));

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Barraca.COSTO.getCostoMineral() - Fabrica.COSTO.getCostoMineral() - PuertoEstelar.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeGasParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);

        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorGas(mapa, ubicacionVolcan);
    }

    @Test
    public void crearExtractorDeGasParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));
    	unJugador.crearExtractorGas(mapa, ubicacionVolcan);

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL - Asimilador.COSTO.getCostoMineral());
    }
    @Test
    public void crearExtractorDeMineralParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
    	unJugador.crearExtractorMineral(mapa, ubicacionMineral);

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL -  NexoMineral.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearExtractorDeMineralesParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearExtractorMineral(mapa, ubicacionMineral);
    }
    
    @Test
    public void crearAdicionalDeSuministrosParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

    	unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL - Pilon.COSTO.getCostoMineral());
    }
    
    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearAdicionalDeSuministrosParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesBasicasParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL);
        unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));
    }
    
    @Test
    public void crearCreadorDeUnidadesBasicasParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

    	unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL - Acceso.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesMagicasParaProtossLanzaExcepcionSiNoHaySuministros() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);

        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado())
            unJugador.terminarTurno(juego);

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Acceso.COSTO.getCostoMineral());
        unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 2));
    }
    
    @Test
    public void crearCreadorDeUnidadesMagicasParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);

        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado())
            unJugador.terminarTurno(juego);
  
    	unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Acceso.COSTO.getCostoMineral() - ArchivosTemplarios.COSTO.getCostoMineral() - PuertoEstelarProtoss.COSTO.getCostoMineral());
    }

    @Test(expected = ExcepcionRecursosInsuficientes.class)
    public void crearCreadorDeUnidadesAvanzadasParaProtossLanzaExcepcionSiNoHayRecursos() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);

        unJugador.sumarMinerales(-Jugador.MINERAL_INICIAL + Acceso.COSTO.getCostoMineral() + ArchivosTemplarios.COSTO.getCostoMineral());
        unJugador.sumarGasVespeno(-Jugador.GAS_VESPENO_INICIAL + PuertoEstelarProtoss.COSTO.getCostoGas());

        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));
    }
    
    @Test
    public void crearCreadorDeUnidadesAvanzadasParaProtossRestaRecursosAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);

        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));

    	Assert.assertEquals(unJugador.getMinerales(), Jugador.MINERAL_INICIAL + RECURSOS_SUFFICIENTES - Acceso.COSTO.getCostoMineral() - ArchivosTemplarios.COSTO.getCostoMineral() - PuertoEstelarProtoss.COSTO.getCostoMineral());
    }
    
    @Test
    public void tieneConstruccionDeTipoDevuelveFalseSiNoSeCreoNada() throws ExcepcionRecursosInsuficientes, ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_GAS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_MINERAL));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_BASICAS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_MAGICAS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS));
        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElAdicionalDeSuministros() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);

        AdicionalSuministros adicional = (AdicionalSuministros) unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        while(!adicional.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElExtractorGas() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Coordenada ubicacionVolcan = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        mapa.insertarParcela(new ParcelaVolcan(ubicacionVolcan));

        Refineria refineria = (Refineria) unJugador.crearExtractorGas(mapa, ubicacionVolcan);

        while (!refineria.estaCreado())
            
        	unJugador.terminarTurno(juego);

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_GAS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElExtractorMineral() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 20, 20);
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);

        mapa.insertarParcela(new ParcelaMineral(ubicacionMineral));
        CentroDeMineral centro = (CentroDeMineral) unJugador.crearExtractorMineral(mapa, ubicacionMineral);

        while(!centro.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_MINERAL));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeSoldados() throws ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        while(!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_BASICAS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeUnidadesTerrestres() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS));
    }

    @Test
    public void tieneConstruccionDeTipoExtractorGasDevuelveTrueSiSeCreoElCreadorDeUnidadesAereas() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));

        while(!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_MAGICAS));
    }

    @Test(expected = ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesAvanzadasSinTenerCreadorDeUnidadesBasicasLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 4));
    }

    @Test(expected = ExcepcionConstruccionesRequeridasNoCreadas.class)
    public void jugadorCreaCreadorDeUnidadesMagicasSinTenerCreadorDeUnidadesTerrestresLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 2));
    }

    @Test
    public void elJugadorComienzaConPoblacionInicialCorrecta() throws ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        Assert.assertEquals(unJugador.getPoblacion(), Jugador.POBLACION_INICIAL);
    }

    @Test(expected = ExcepcionNoHaySuministrosDisponibles.class)
    public void crearUnidadSinSuministrosLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa (2, 20, 20);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);

        unJugador.sumarMinerales(250);
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        barraca.crearMarine(mapa);
    }

    @Test
    public void crearMarineSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Barraca barraca;
        Marine marine;

        unJugador.sumarMinerales(250);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        marine = barraca.crearMarine(mapa);

        Assert.assertEquals(unJugador.getPoblacion(), Jugador.POBLACION_INICIAL + marine.getSuministro());
    }

    @Test
     public void crearGolliatSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);
        Fabrica fabrica;
        Golliat golliat;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        golliat = fabrica.crearGolliat(mapa);

        Assert.assertEquals(unJugador.getPoblacion(), Jugador.POBLACION_INICIAL + golliat.getSuministro());
    }

    @Test
    public void crearNaveCienciaSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        PuertoEstelar puerto;
        NaveCiencia nave;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        nave = puerto.crearNaveCiencia(mapa);

        Assert.assertEquals(unJugador.getPoblacion(), Jugador.POBLACION_INICIAL + nave.getSuministro());
    }

    @Test
    public void crearEspectroSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        PuertoEstelar puerto;
        Espectro espectro;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        espectro = puerto.crearEspectro(mapa);

        Assert.assertEquals(unJugador.getPoblacion(), Jugador.POBLACION_INICIAL + espectro.getSuministro());
    }

    @Test
    public void crearNaveTransporteSumaPoblacionCorrectaAlJugador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        PuertoEstelar puerto;
        NaveTransporteTerran nave;

        unJugador.sumarMinerales(RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        nave = puerto.crearNaveTransporte(mapa);

        Assert.assertEquals(unJugador.getPoblacion(), Jugador.POBLACION_INICIAL + nave.getSuministro());
    }

    @Test
    public void agregarUnidadAgregaUnaUnidadAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Barraca barraca;

        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        barraca.crearMarine(mapa);

        Assert.assertEquals(unJugador.getCantidadDeUnidades(), 1);
    }

    @Test
    public void destruirUnaUnidadRestaPoblacionAlJugador() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Barraca barraca;
        Marine marine;

        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        marine = barraca.crearMarine(mapa);

        Assert.assertEquals(unJugador.getCantidadDeUnidades(), 1);
        Assert.assertEquals(unJugador.getPoblacion(), marine.getSuministro());

        marine.destruir();

        Assert.assertEquals(unJugador.getCantidadDeUnidades(), 0);
        Assert.assertEquals(unJugador.getPoblacion(), 0);
    }

    @Test
    public void destruirUnAdicionalDeSuministrosRestaPoblacionPeroNoEliminaUnidades() throws ExcepcionRecursosInsuficientes, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        DepositoSuministro deposito;
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);

        deposito = (DepositoSuministro) unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        deposito.recibirDanyo(DepositoSuministro.VIDA_INICIAL + 1);

        Assert.assertEquals(unJugador.cantidadDeConstrucciones(), 0);
        Assert.assertEquals(unJugador.getCapacidadDePoblacion(), 0);
    }

    @Test
    public void crearAdicionalSuministrosUbicaALaConstruccionEnElMapa() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        DepositoSuministro deposito;

        deposito = (DepositoSuministro) unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertSame(deposito, mapa.devolverElementoEnParcela(new Coordenada(1, 1)));
    }

    @Test(expected = ExcepcionNombreCorto.class)
    public void crearJugadorConNombreConMenosDe4LetrasLanzaExcepcion() throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNumeroDeBasesInvalido {
        new Jugador("tre", Color.ROJO, Terran.getInstance());
    }

    @Test
    public void jugadorTieneConstruccionDeTipoDevuelveFalseSiLaConstruccionNoEstaCreada() throws ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertFalse(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }

    @Test
    public void jugadorTieneConstruccionDeTipoDevuelveTrueSiSePasaronLosTurnosNecesariosParaLaCreacionDeLaConstruccion() throws ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);

        DepositoSuministro deposito = (DepositoSuministro) unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        while(!deposito.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertTrue(unJugador.tieneConstruccionDeTipo(TipoDeConstruccion.ADICIONAL_SUMINISTROS));
    }
}