package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNaveDeTransporteLlena;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsUnidadTerrestre;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaVacia;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadEnemiga;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadNoClonable;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadYaSeEncuentraEnLaNave;
import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveTransporteTerran;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Clon;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadMagica;

public class IntegradoresTest {
	
	private void crearTodasLasConstrucciones(Jugador jTerran, Jugador jProtoss, Mapa mapa, Juego juego)  throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionConstruccionesRequeridasNoCreadas{

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
	
	private void esperarUnidad(Interactuable unidad, Jugador jugador1, Jugador jugador2, Juego juego) throws ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa{
		while(!unidad.estaCreado()){
			jugador1.terminarTurno(juego);
			jugador2.terminarTurno(juego);
		}
	}
	
	private void esperarEnergiaUnidad(UnidadMagica unidad,Jugador jugador1, Jugador jugador2, Juego juego) throws ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa{
		int energia = unidad.getEnergia();
		boolean cambio = true;
		while(cambio){
			jugador1.terminarTurno(juego);
			jugador2.terminarTurno(juego);
			cambio = !(energia == unidad.getEnergia());
			energia = unidad.getEnergia();
        }
	}
    
    @Test
    public void escenarioNaveCienciaQuitaEscudoYRestaSuMagia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion, ExcepcionEnergiaInsuficiente{
    	 Juego juego = new Juego();
    	 juego.setMapaParaTests();
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
         
         this.esperarEnergiaUnidad(naveCiencia, jTerran, jProtoss, juego);
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
    	 juego.setMapaParaTests();
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
         
         this.esperarEnergiaUnidad(naveCiencia, jTerran, jProtoss, juego);
         

         int energiaInicial = naveCiencia.getEnergia();
         
         
         naveCiencia.lanzarEMP(dragon.getParcela());
         boolean OKEnergia = (naveCiencia.getEnergia() == energiaInicial - NaveCiencia.COSTO_ENERGIA_EMP);
         
         jTerran.terminarTurno(juego);
         
         
         boolean OKEscudo = (((VitalidadProtoss) dragon.getVitalidad()).getEscudo() == 0);
         
         jProtoss.terminarTurno(juego);
         
         this.esperarEnergiaUnidad(naveCiencia, jTerran, jProtoss, juego);
         naveCiencia.lanzarEMP(naveCiencia2.getParcela());
         jTerran.terminarTurno(juego);
         
         boolean OKMagia  = (naveCiencia2.getEnergia() == 0);
         
         
         Assert.assertTrue(OKEnergia && OKEscudo && OKMagia);
    }
    
    @Test
    public void escenarioNaveCienciaNoQuitaEscudoNiMagiaCuandoErraYRestaSuMagia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion, ExcepcionEnergiaInsuficiente{
    	 Juego juego = new Juego();
    	 juego.setMapaParaTests();
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
         this.esperarEnergiaUnidad(naveCiencia, jTerran, jProtoss, juego);

         int energiaInicial = naveCiencia.getEnergia();
        
         
         naveCiencia.lanzarEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada(9,9)));
         boolean OKEnergia = (naveCiencia.getEnergia() == energiaInicial - NaveCiencia.COSTO_ENERGIA_EMP);
         
         jTerran.terminarTurno(juego);
         boolean OKMagia  = (naveCiencia2.getEnergia() == 0);
         boolean OKEscudo = (((VitalidadProtoss) dragon.getVitalidad()).getEscudo() == 0);
         
         Assert.assertTrue(OKEnergia && !OKEscudo && !OKMagia);
    }
    
    @Test
    public void escenarioTemplarioLanzaSusAtaquesBienYSusClonesMuerenConEMP() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion, ExcepcionEnergiaInsuficiente, ExcepcionUnidadEnemiga, ExcepcionUnidadNoClonable, ExcepcionParcelaVacia {
    	 Juego juego = new Juego();
    	 juego.setMapaParaTests();
    	 Mapa mapa = juego.getMapa();
         Jugador jTerran = new Jugador("Juan", Color.ROJO, Terran.getInstance());
         Jugador jProtoss = new Jugador("Carlos", Color.AZUL, Protoss.getInstance());
         juego.agregarJugador(jTerran);
         juego.agregarJugador(jProtoss);
         this.crearTodasLasConstrucciones(jTerran, jProtoss, mapa, juego);
         
         PuertoEstelar puertoT = (PuertoEstelar) mapa.devolverElementoEnParcela(new Coordenada(3,3));
         Acceso acceso = (Acceso) mapa.devolverElementoEnParcela(new Coordenada(18,18));
         ArchivosTemplarios archivos = (ArchivosTemplarios) mapa.devolverElementoEnParcela(new Coordenada(16,16));
         Barraca barraca = (Barraca) mapa.devolverElementoEnParcela(new Coordenada(1,1));
         
         NaveCiencia naveCiencia = puertoT.crearNaveCiencia(mapa);
         NaveCiencia naveCiencia2 = puertoT.crearNaveCiencia(mapa);
         Marine marine = barraca.crearMarine(mapa);
         jTerran.terminarTurno(juego);
         
         Dragon dragon = acceso.crearDragon(mapa);
         AltoTemplario templario = archivos.crearAltoTemplario(mapa);
         jProtoss.terminarTurno(juego);
         
         this.esperarUnidad(naveCiencia, jTerran, jProtoss, juego);
         this.esperarUnidad(naveCiencia2, jTerran, jProtoss, juego);
         this.esperarUnidad(marine, jTerran, jProtoss, juego);
         
         this.esperarUnidad(dragon, jTerran, jProtoss, juego);
         
         this.esperarUnidad(templario, jTerran, jProtoss, juego);
    
         
         this.esperarEnergiaUnidad(templario, jTerran, jProtoss, juego);
         
         jTerran.terminarTurno(juego);
         
         int vidaPrevioAtaque = naveCiencia2.getVida();

         templario.lanzarTormentaPsionica(puertoT.getParcela());
         
         
         jProtoss.terminarTurno(juego);
         
         System.out.println(puertoT.getParcela().getCoordenada().getX());
         System.out.println(puertoT.getParcela().getCoordenada().getY());
//         System.out.println(naveCiencia2.getParcela().getCoordenada());
         System.out.println(naveCiencia2.getParcela().getCoordenada().getX());
         System.out.println(naveCiencia2.getParcela().getCoordenada().getY());
//         System.out.println(naveCiencia.getParcela().getCoordenada());
         System.out.println(naveCiencia.getParcela().getCoordenada().getX());
         System.out.println(naveCiencia.getParcela().getCoordenada().getY());
         System.out.println(naveCiencia2.getVida());
         System.out.println(naveCiencia.getVida());
         
         
         
         boolean OKVidaNaveCiencia2 = naveCiencia2.getVida() == (vidaPrevioAtaque - 50);
         boolean OKVidaNaveCiencia = naveCiencia.getVida() == (vidaPrevioAtaque - 50);
         Assert.assertTrue(OKVidaNaveCiencia2);
         Assert.assertTrue(OKVidaNaveCiencia);
         
         vidaPrevioAtaque = naveCiencia2.getVida();

         
         
         jTerran.terminarTurno(juego);
         
         boolean OKVidaNaveCiencia2doTurno = naveCiencia.getVida() == (vidaPrevioAtaque - 50);
         boolean OKVidaNaveCiencia22doTurno = naveCiencia2.getVida() == (vidaPrevioAtaque - 50);
         Assert.assertTrue(OKVidaNaveCiencia2doTurno && OKVidaNaveCiencia22doTurno);
         
         jProtoss.terminarTurno(juego);
         
         this.esperarEnergiaUnidad(templario, jTerran, jProtoss, juego);
         
         jTerran.terminarTurno(juego);
                 
         templario.crearAlucinacion(dragon.getParcela(), mapa);
         
         jProtoss.terminarTurno(juego);
         
         mapa.ubicarElementoEnParcela(new Coordenada(17,16), naveCiencia2);
         jTerran.terminarTurno(juego);
         
         Clon clon1 = (Clon) mapa.devolverElementoEnParcela(new Coordenada(16,17));
         Clon clon2 = (Clon) mapa.devolverElementoEnParcela(new Coordenada(16,18));
         
         
         vidaPrevioAtaque = naveCiencia2.getVida();
         clon1.atacar(naveCiencia2.getParcela());
         
         Assert.assertTrue(naveCiencia2.getVida() == vidaPrevioAtaque);
         
         jProtoss.terminarTurno(juego);
         
         this.esperarEnergiaUnidad(naveCiencia2, jTerran, jProtoss, juego);
         
         int unidadesPrevioAtaque = jProtoss.getCantidadDeUnidades();
         
         naveCiencia.lanzarEMP(dragon.getParcela());
         
         jTerran.terminarTurno(juego);
         
         
         Assert.assertTrue(((VitalidadProtoss)clon1.getVitalidad()).getEscudo() == 0);
         Assert.assertTrue(((VitalidadProtoss)clon2.getVitalidad()).getEscudo() == 0);
         
         
         
         Assert.assertTrue(jProtoss.getCantidadDeUnidades() == unidadesPrevioAtaque - 2);

    }

    @Test
    public void transportarConLaNaveDeTransporteLosTransportaBien() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionEstadoMuerto, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionEntidadEnConstruccion, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles, ExcepcionNoEsUnidadTerrestre, ExcepcionNaveDeTransporteLlena, ExcepcionUnidadEnemiga, ExcepcionUnidadYaSeEncuentraEnLaNave {
        Juego juego = new Juego();
        juego.setMapaParaTests();
        Mapa mapa = juego.getMapa();
        Jugador jTerran = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador jProtoss = new Jugador("Carlos", Color.AZUL, Protoss.getInstance());
        juego.agregarJugador(jTerran);
        juego.agregarJugador(jProtoss);
        
        
        this.crearTodasLasConstrucciones(jTerran, jProtoss, mapa, juego);

        

        while(jTerran.getMinerales() <= 10000){
        	jTerran.terminarTurno(juego);
         	 jProtoss.terminarTurno(juego);
        
        }
        
        while(jTerran.getGasVespeno() <= 10000){
        	jTerran.terminarTurno(juego);
         	 jProtoss.terminarTurno(juego);
        }
        
        jTerran.crearAdicionalDeSuministro(mapa, new Coordenada(4, 5));
        jTerran.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(13,13));
        
       
        
        PuertoEstelar puertoT = (PuertoEstelar) mapa.devolverElementoEnParcela(new Coordenada(13,13));
        Barraca barraca = (Barraca) mapa.devolverElementoEnParcela(new Coordenada(1,1));

        this.esperarUnidad(puertoT, jTerran, jProtoss, juego);
        
        NaveTransporteTerran nave = puertoT.crearNaveTransporte(mapa);
        this.esperarUnidad(nave, jTerran, jProtoss, juego);
        

        Marine marine1 = barraca.crearMarine(mapa);
        this.esperarUnidad(marine1, jTerran, jProtoss, juego);
        nave.insertarUnidad(marine1);

        Marine marine2 = barraca.crearMarine(mapa);
        this.esperarUnidad(marine2, jTerran, jProtoss, juego);
        nave.insertarUnidad(marine2);

        Marine marine3 = barraca.crearMarine(mapa);
        this.esperarUnidad(marine3, jTerran, jProtoss, juego);
        nave.insertarUnidad(marine3);

        Marine marine4 = barraca.crearMarine(mapa);
        this.esperarUnidad(marine4, jTerran, jProtoss, juego);
        nave.insertarUnidad(marine4);

        
       
        Coordenada destinoNave = new Coordenada(8,10);
        nave.moverHasta(destinoNave);
 
        while(!(nave.getParcela().getCoordenada()).equals(destinoNave)) {
            jTerran.terminarTurno(juego);
            jProtoss.terminarTurno(juego);
                
        }     

        

          nave.sacarUnidad(mapa, marine1);
        nave.sacarUnidad(mapa, marine2);
        nave.sacarUnidad(mapa, marine3);
        nave.sacarUnidad(mapa, marine4);
        

       Assert.assertEquals(marine1.getParcela().getCoordenada(), new Coordenada(destinoNave.getX()-1, destinoNave.getY()-1));
        Assert.assertEquals(marine2.getParcela().getCoordenada(), new Coordenada(destinoNave.getX()-1, destinoNave.getY()));
        Assert.assertEquals(marine3.getParcela().getCoordenada(), new Coordenada(destinoNave.getX()-1, destinoNave.getY()+1));
        Assert.assertEquals(marine4.getParcela().getCoordenada(), new Coordenada(destinoNave.getX(), destinoNave.getY()-1));
    }
    @Test(expected = ExcepcionNoHaySuministrosDisponibles.class)
    public void seLlegaAlTopeDePoblacion()throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion, ExcepcionEnergiaInsuficiente, ExcepcionParcelaVacia{
    	Juego juego = new Juego();
    	juego.setMapaParaTests();
    	Mapa mapa = juego.getMapa();
        Jugador jTerran = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador jProtoss = new Jugador("Carlos", Color.AZUL, Protoss.getInstance());
        juego.agregarJugador(jTerran);
        juego.agregarJugador(jProtoss);
        
        Interactuable gasT = jTerran.crearExtractorGas(mapa, new Coordenada(0,0));
        Interactuable mineralT = jTerran.crearExtractorMineral(mapa, new Coordenada(0,1));
        while(!gasT.estaCreado() || !mineralT.estaCreado()){
          	 jTerran.terminarTurno(juego);
          	 jProtoss.terminarTurno(juego);
           }
        
        while(jTerran.getMinerales() <= 100000){
        	jTerran.terminarTurno(juego);
         	 jProtoss.terminarTurno(juego);
        }
        for(int i=1; i<19; i++){
        	jTerran.crearAdicionalDeSuministro(mapa, new Coordenada(i,i));
        }
        for(int i=16; i>0; i--){
        	jTerran.crearAdicionalDeSuministro(mapa, new Coordenada(i,i+3));
        }
        for(int i=15; i>0; i--){
        	jTerran.crearAdicionalDeSuministro(mapa, new Coordenada(i,i+4));
        }

        for(int i= 0; i<=6; i++){
        	jTerran.terminarTurno(juego);
       	 	jProtoss.terminarTurno(juego);
        }

        Assert.assertTrue(jTerran.getCapacidadDePoblacion() == 200);
        
        Interactuable basicasT = jTerran.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(12,11));
        while(!basicasT.estaCreado()){
          	 jTerran.terminarTurno(juego);
          	 jProtoss.terminarTurno(juego);
        }
        
        for(int i=0; i<198; i++){
        	new Marine(jTerran);
        }

        Marine marine = ((Barraca)basicasT).crearMarine(mapa);
        Marine marine2 = ((Barraca)basicasT).crearMarine(mapa);
        this.esperarUnidad(marine, jTerran, jProtoss, juego);
        this.esperarUnidad(marine2, jTerran, jProtoss, juego);
        
        Assert.assertTrue(jTerran.getPoblacion() == 200);
        
        while(marine2.getVida()>0){
        	marine.atacar(marine2.getParcela());
        	jTerran.terminarTurno(juego);
         	jProtoss.terminarTurno(juego);
        }
        Assert.assertTrue(jTerran.getPoblacion() == 199);
        
        ((Barraca)basicasT).crearMarine(mapa);
        ((Barraca)basicasT).crearMarine(mapa);
    } 
    @Test
    public void escenarioJugadorPierdeSiNoPuedeObtenerMasSuministros() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion, ExcepcionEnergiaInsuficiente, ExcepcionUnidadEnemiga {
    	 Juego juego = new Juego();
    	 juego.setMapaParaTests();
    	 Mapa mapa = juego.getMapa();
         Jugador jTerran = new Jugador("Juan", Color.ROJO, Terran.getInstance());
         Jugador jProtoss = new Jugador("Carlos", Color.AZUL, Protoss.getInstance());
         juego.agregarJugador(jTerran);
         juego.agregarJugador(jProtoss);

         Interactuable gasP = jProtoss.crearExtractorGas(mapa, new Coordenada(19,19));
         Interactuable mineralP = jProtoss.crearExtractorMineral(mapa, new Coordenada(19,18));
         jTerran.terminarTurno(juego);
         jProtoss.terminarTurno(juego);
         
         while(!gasP.estaCreado() ||  !mineralP.estaCreado()){
        	 jTerran.terminarTurno(juego);
        	 jProtoss.terminarTurno(juego);
         }
         while ((jProtoss.getGasVespeno() <= 2000)&&(jProtoss.getMinerales()<=4000)){
           	 jTerran.terminarTurno(juego);
           	 jProtoss.terminarTurno(juego);
            }
         
         jTerran.terminarTurno(juego);
         Interactuable basicasP = jProtoss.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(18,18));
         jProtoss.terminarTurno(juego);
         
         while( !basicasP.estaCreado()){
        	 jTerran.terminarTurno(juego);
        	 jProtoss.terminarTurno(juego);
         }
         
         
         jTerran.terminarTurno(juego);
         Interactuable avanzadasP = jProtoss.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(17,17));
         jProtoss.terminarTurno(juego);
         
         while(!avanzadasP.estaCreado()){
        	 jTerran.terminarTurno(juego);
        	 jProtoss.terminarTurno(juego);
         }
         
         
         jTerran.terminarTurno(juego);
         Interactuable magicasP = jProtoss.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(16,16));
         jProtoss.terminarTurno(juego);
         
         while( !magicasP.estaCreado()){
        	 jTerran.terminarTurno(juego);
        	 jProtoss.terminarTurno(juego);
         }
         
         
         jTerran.terminarTurno(juego);
         Interactuable suministrosP = jProtoss.crearAdicionalDeSuministro(mapa, new Coordenada(15,15));
         jProtoss.terminarTurno(juego);
         
         while( !suministrosP.estaCreado()){
           	 jTerran.terminarTurno(juego);
           	 jProtoss.terminarTurno(juego);
            }
         jTerran.terminarTurno(juego);
         Interactuable suministrosP2 = jProtoss.crearAdicionalDeSuministro(mapa, new Coordenada(14,14));
         jProtoss.terminarTurno(juego);
         
         while( !suministrosP2.estaCreado()){
           	 jTerran.terminarTurno(juego);
           	 jProtoss.terminarTurno(juego);
         }
         
         jTerran.terminarTurno(juego);
         
         jProtoss.terminarTurno(juego);
         
         
         jTerran.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(5,5));
         //le quedan solo 50
         Assert.assertTrue(jTerran.esPerdedor());

    }
}
