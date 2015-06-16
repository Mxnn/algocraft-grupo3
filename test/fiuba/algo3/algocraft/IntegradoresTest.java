package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.construcciones.*;
import fiuba.algo3.algocraft.razas.protoss.unidades.*;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.construcciones.*;
import fiuba.algo3.algocraft.razas.terran.unidades.*;
import fiuba.algo3.algocraft.utilidades.*;

import org.junit.Assert;
import org.junit.Test;

public class IntegradoresTest {
	
	public void crearTodasLasConstrucciones(Jugador jTerran, Jugador jProtoss, Mapa mapa, Juego juego)  throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionConstruccionesRequeridasNoCreadas{

        Interactuable gasT = jTerran.crearExtractorGas(mapa, new Coordenada(0,0));
        Interactuable mineralT = jTerran.crearExtractorMineral(mapa, new Coordenada(0,1));
        jTerran.terminarTurno(juego);
        
        Interactuable gasP = jProtoss.crearExtractorGas(mapa, new Coordenada(19,19));
        Interactuable mineralP = jProtoss.crearExtractorMineral(mapa, new Coordenada(19,18));
        jProtoss.terminarTurno(juego);
        
        while(!gasP.estaCreado() || !gasT.estaCreado() || !mineralT.estaCreado() || !mineralP.estaCreado()){
       	 jTerran.terminarTurno(juego);
       	 jProtoss.terminarTurno(juego);
        }

        while ((jTerran.getGasVespeno() <= 200)&&(jTerran.getMinerales()<=400)){
       	 jTerran.terminarTurno(juego);
       	 jProtoss.terminarTurno(juego);
        }
        
        Interactuable basicasT = jTerran.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(1,1));
        jTerran.terminarTurno(juego);
        Interactuable basicasP = jProtoss.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(18,18));
        jProtoss.terminarTurno(juego);
        
        while(!basicasT.estaCreado() || !basicasP.estaCreado()){
       	 jTerran.terminarTurno(juego);
       	 jProtoss.terminarTurno(juego);
        }
        
        Interactuable avanzadasT = jTerran.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2,2));
        jTerran.terminarTurno(juego);
        Interactuable avanzadasP = jProtoss.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(17,17));
        jProtoss.terminarTurno(juego);
        
        while(!avanzadasT.estaCreado() || !avanzadasP.estaCreado()){
       	 jTerran.terminarTurno(juego);
       	 jProtoss.terminarTurno(juego);
        }
        
        Interactuable magicasT = jTerran.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(3,3));
        jTerran.terminarTurno(juego);
        Interactuable magicasP = jProtoss.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(16,16));
        jProtoss.terminarTurno(juego);
        
        while(!magicasT.estaCreado() || !magicasP.estaCreado()){
       	 jTerran.terminarTurno(juego);
       	 jProtoss.terminarTurno(juego);
        }
        
        Interactuable suministrosT = jTerran.crearAdicionalDeSuministro(mapa, new Coordenada(4,4));
        jTerran.terminarTurno(juego);
        Interactuable suministrosP = jProtoss.crearAdicionalDeSuministro(mapa, new Coordenada(15,15));
        jProtoss.terminarTurno(juego);
        
        while(!suministrosT.estaCreado() || !suministrosP.estaCreado()){
          	 jTerran.terminarTurno(juego);
          	 jProtoss.terminarTurno(juego);
           }
        
	}
	
	public void esperarUnidad(Interactuable unidad, Jugador jugador1, Jugador jugador2, Juego juego) throws ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa{
		while(!unidad.estaCreado()){
			jugador1.terminarTurno(juego);
			jugador2.terminarTurno(juego);
		}
	}
	
	
    @Test
    public void pruebaIntegracion1() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso {
        Juego juego = new Juego();
        Jugador jTerran = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador jProtoss = new Jugador("Carlos", Color.AZUL, Protoss.getInstance());
        juego.agregarJugador(jTerran);
        juego.agregarJugador(jProtoss);

        Assert.assertTrue(true);
    }
    
    @Test
    public void escenarioNaveCienciaQuitaEscudoYRestaSuMagia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion, ExcepcionEnergiaInsuficiente{
    	 Juego juego = new Juego();
    	 Mapa mapa = juego.getMapa();
         Jugador jTerran = new Jugador("Juan", Color.ROJO, Terran.getInstance());
         Jugador jProtoss = new Jugador("Carlos", Color.AZUL, Protoss.getInstance());
         juego.agregarJugador(jTerran);
         juego.agregarJugador(jProtoss);
         this.crearTodasLasConstrucciones(jTerran, jProtoss, mapa, juego);
         
         PuertoEstelar puertoT = (PuertoEstelar) mapa.devolverElementoEnParcela(new Coordenada(3,3));
         Acceso acceso = (Acceso) mapa.devolverElementoEnParcela(new Coordenada(18,18));
         NaveCiencia naveCiencia = puertoT.crearNaveCiencia(mapa);
         jTerran.terminarTurno(juego);
         
         Dragon dragon = acceso.crearDragon(mapa);
         jProtoss.terminarTurno(juego);
         
         this.esperarUnidad(naveCiencia, jTerran, jProtoss, juego);
         
         this.esperarUnidad(dragon, jTerran, jProtoss, juego);
         
         while((naveCiencia.getEnergia() <100)){
        	 jTerran.terminarTurno(juego);
        	 jProtoss.terminarTurno(juego);
         }
         int energiaInicial = naveCiencia.getEnergia();
         
         naveCiencia.lanzarEMP(dragon.getParcela());
         boolean OKEnergia = (naveCiencia.getEnergia() == energiaInicial - NaveCiencia.COSTO_ENERGIA_EMP);
         
         jTerran.terminarTurno(juego);
         
         boolean OKEscudo = (((VitalidadProtoss) dragon.getVitalidad()).getEscudo() == 0);
         
         Assert.assertTrue(OKEnergia && OKEscudo);
    }
    
    @Test
    public void escenarioNaveCienciaQuitaEscudoYMagiaAOTraNaveCienciaYRestaSuMagia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion, ExcepcionEnergiaInsuficiente{
    	 Juego juego = new Juego();
    	 Mapa mapa = juego.getMapa();
         Jugador jTerran = new Jugador("Juan", Color.ROJO, Terran.getInstance());
         Jugador jProtoss = new Jugador("Carlos", Color.AZUL, Protoss.getInstance());
         juego.agregarJugador(jTerran);
         juego.agregarJugador(jProtoss);
         this.crearTodasLasConstrucciones(jTerran, jProtoss, mapa, juego);
         
         PuertoEstelar puertoT = (PuertoEstelar) mapa.devolverElementoEnParcela(new Coordenada(3,3));
         Acceso acceso = (Acceso) mapa.devolverElementoEnParcela(new Coordenada(18,18));
         NaveCiencia naveCiencia = puertoT.crearNaveCiencia(mapa);
         NaveCiencia naveCiencia2 = puertoT.crearNaveCiencia(mapa);
         jTerran.terminarTurno(juego);
         
         Dragon dragon = acceso.crearDragon(mapa);
         jProtoss.terminarTurno(juego);
         
         this.esperarUnidad(naveCiencia, jTerran, jProtoss, juego);
         this.esperarUnidad(naveCiencia2, jTerran, jProtoss, juego);
         
         this.esperarUnidad(dragon, jTerran, jProtoss, juego);
         
         while((naveCiencia.getEnergia() <100)){
        	 jTerran.terminarTurno(juego);
        	 jProtoss.terminarTurno(juego);
         }
         int energiaInicial = naveCiencia.getEnergia();
         //cuando este mover esto hay que cambiarlo por mover
         mapa.ubicarCercaDeParcela(dragon.getParcela(), naveCiencia2);
         
         
         naveCiencia.lanzarEMP(dragon.getParcela());
         boolean OKEnergia = (naveCiencia.getEnergia() == energiaInicial - NaveCiencia.COSTO_ENERGIA_EMP);
         
         jTerran.terminarTurno(juego);
         boolean OKMagia  = (naveCiencia2.getEnergia() == 0);
         boolean OKEscudo = (((VitalidadProtoss) dragon.getVitalidad()).getEscudo() == 0);
         
         Assert.assertTrue(OKEnergia && OKEscudo && OKMagia);
    }
}
