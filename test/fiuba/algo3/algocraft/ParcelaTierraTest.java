package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.RazaTerran.*;

import org.junit.Assert;
import org.junit.Test;

public class ParcelaTierraTest {

    @Test
    public void parcelaEmpiezaVacia(){
        Parcela parcela = new ParcelaTierra();

        Assert.assertTrue(parcela.estaVacia());
    }

    @Test
    public void devolverElementoDevuelveInteractuableGuardado() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro();
        Parcela parcela = new ParcelaTierra();
        Interactuable marine = new Marine(unJugador);
        parcela.guardarElemento(marine);

        Assert.assertSame(marine, parcela.devolverElemento());
    }

    @Test
    public void estaVaciaDevuelveFalseCuandoEstaOcupada() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Parcela parcela = new ParcelaTierra();
        unJugador.crearAdicionalDeSuministro();
        Interactuable marine = new Marine(unJugador);
        parcela.guardarElemento(marine);

        Assert.assertFalse(parcela.estaVacia());
    }

    @Test(expected = ExcepcionParcelaOcupada.class)
    public void guardarElementoSobreUnaParcelaYaOcupdaLanzaExcepcion() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro();
        Parcela parcela = new ParcelaTierra();
        Interactuable marine = new Marine(unJugador);
        Interactuable golliat = new Golliat(unJugador);

        parcela.guardarElemento(marine);
        parcela.guardarElemento(golliat);
    }
    
    @Test
    public void parcelaGuardaUnidadesVoladoras() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro();
    	Parcela parcela = new ParcelaTierra();
    	Interactuable espectro = new Espectro(unJugador);

    	parcela.guardarElemento(espectro);

    	Assert.assertSame(espectro, parcela.devolverElemento());
    }
    
    @Test
    public void parcelaGuardaConstruccion() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada {
    	Parcela parcela = new ParcelaTierra();
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro();
    	Interactuable construccion = new Barraca(unJugador);

    	parcela.guardarElemento(construccion);

    	Assert.assertSame(construccion, parcela.devolverElemento());
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractor() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        Parcela parcela = new ParcelaTierra();
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable construccion = new CentroDeMineral(unJugador);

        parcela.guardarElemento(construccion);
    }
}










