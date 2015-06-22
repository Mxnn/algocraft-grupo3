package fiuba.algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.mapa.Randomizador;
import fiuba.algo3.algocraft.modelo.mapa.RandomizadorTests;
import fiuba.algo3.algocraft.modelo.razas.Raza;


public class Juego {
    private static int MAXIMO_NUMERO_DE_JUGADORES = 2;


    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Mapa mapa;
    private SistemaDeTurnos sistemaDeTurnos;
    private Randomizador rand;
    
    public Juego() throws ExcepcionNumeroDeBasesInvalido { 
    	this.mapa = new Mapa (2, 20, 20);
    	this.rand = new RandomizadorTests();
    	this.crearEspaciosEnElMapa();
    	this.crearMineralesPorElMapa();
    	this.crearBasesEnMapa();
        this.sistemaDeTurnos = new SistemaDeTurnos(this.jugadores,this.mapa);
        
    }

    public void setMapaParaTests(){
    	this.rand = new RandomizadorTests();
    }
    private void crearBasesEnMapa() {
    	int x = this.rand.randInt(0, 5); //calcular bordes desde el mapa
    	int y = this.rand.randInt(0, this.mapa.getFilas());
    	
    	this.mapa.insertarParcela(new ParcelaVolcan(new Coordenada(x,y)));
    	
    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(x+1,y)));
    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(x+2,y)));
    	
    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(x,y+1)));
    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(x,y+2)));
    	
    	int xEspejada = this.mapa.getColumnas()-1-x;
    	int yEspejada = this.mapa.getFilas()-1-y;
    	Coordenada coordenadaOpuesta = new Coordenada(xEspejada,yEspejada);
    	this.mapa.insertarParcela(new ParcelaVolcan(new Coordenada(xEspejada,yEspejada)));
    	
    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(xEspejada-1,yEspejada)));
    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(xEspejada-2,yEspejada)));
    	
    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(xEspejada,yEspejada-1)));
    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(xEspejada,yEspejada-2)));
    	
////        Base 1
//        this.mapa.insertarParcela(new ParcelaVolcan(new Coordenada(0, 0)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(0, 1)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(0, 2)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(1, 0)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(2, 0)));
//
//        //Base 2
//        this.mapa.insertarParcela(new ParcelaVolcan(new Coordenada(19, 19)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(19, 18)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(19, 17)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(18, 19)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(17, 19)));
    }

    private void crearMineralesPorElMapa() {
    	int cantMinerales = this.rand.randInt(1,7); //sacar magic number
    	for(int i=0; i<cantMinerales; i++){
    		int x = this.rand.randInt(0, this.mapa.getColumnas());
        	int y = this.rand.randInt(0, this.mapa.getFilas());
        	Coordenada coordenada = new Coordenada(x,y);
        	if (this.mapa.coordenadaExiste(coordenada))
        		this.mapa.insertarParcela(new ParcelaMineral(coordenada));
    	}
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(0, 18)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(0, 19)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(1, 19)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(18, 0)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(19, 0)));
//        this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(19, 1)));
    }

    private void crearEspaciosEnElMapa() {
    	int cantEspacios = this.rand.randInt(1, 4);
    	for(int i=0; i<cantEspacios; i++){
    		int x = this.rand.randInt(0, this.mapa.getColumnas());
        	int y = this.rand.randInt(0, this.mapa.getColumnas());
    		Coordenada coordenada = new Coordenada(x,y);
    		ArrayList<Coordenada> coordenadas = coordenada.obtenerCoordenadasVecinas();
    		coordenadas.add(coordenada);
    		for (int j = 0; j < coordenadas.size(); j++) {
        		if(this.mapa.coordenadaExiste((coordenadas).get(j)))
        			this.mapa.insertarParcela(new ParcelaEspacio(coordenadas.get(j)));
        	}	
    	}
//        for (int i = 7; i <= 14; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(0, i)));
//
//        for (int i = 9; i <= 15; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(1, i)));
//
//        for (int i = 12; i <= 15; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(2, i)));
//
//        for (int i = 12; i <= 18; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(3, i)));
//
//        for (int i = 15; i <= 19; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(4, i)));
//
//        for (int i = 16; i <= 19; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(5, i)));
//
//        for (int i = 18; i <= 19; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(6, i)));
//
//        for (int i = 7; i <= 12; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(i, 19)));
//
//        for (int i = 11; i <= 13; i++) {
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(i, 0)));
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(i, 1)));
//        }
//
//        for (int i = 12; i <= 14; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(i, 2)));
//
//        for (int i = 13; i <= 16; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(i, 3)));
//
//        for (int i = 14; i <= 16; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(i, 4)));
//
//        for (int i = 15; i <= 19; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(i, 5)));
//
//        for (int i = 16; i <= 19; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(i, 6)));
//
//        for (int i = 17; i <= 19; i++)
//            this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(i, 7)));
//
//        this.mapa.insertarParcela(new ParcelaEspacio(new Coordenada(19, 8)));
        /*
        De (1,9) a (1,15)
        (2, 12) a (2, 15)
        (3, 12) a (3, 18)
        (4, 15) a (4, 19)
        (5, 16) a (5, 19)
        (6, 18) a (6, 19)
        (7, 19) a (12, 19)

        De (11, 0) (13, 0)
        (11, 1) (13, 1)
        (12, 2) (14, 2)
        (13, 3) (16, 3)
        (14, 4) (16, 4)
        (15, 5) (19, 5)
        (16, 6) (19, 6)
        (17, 7) (19, 7)
        y (19, 8)
         */
    }

    public ArrayList<Jugador> getJugadores(){
    	return this.jugadores;
    }

    public Mapa getMapa(){
    	return this.mapa;
    }


    public void crearJugador(String nombre, Color color, Raza raza) throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreCorto {
        if (jugadores.size() == MAXIMO_NUMERO_DE_JUGADORES)
            throw new ExcepcionAlcanzadoElMaximoCupoDeJugadores();

        if (this.elNombreEstaEnUso(nombre))
            throw new ExcepcionNombreEnUso();

        if (this.elColorEstaEnUso(color))
            throw new ExcepcionColorEnUso();

        Jugador nuevoJugador = new Jugador(nombre, color, raza);

        this.jugadores.add(nuevoJugador);
    }

    public void agregarJugador(Jugador unJugador) throws ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {
        if (jugadores.size() == MAXIMO_NUMERO_DE_JUGADORES)
            throw new ExcepcionAlcanzadoElMaximoCupoDeJugadores();

        if (this.elNombreEstaEnUso(unJugador.getNombre()))
            throw new ExcepcionNombreEnUso();

        if (this.elColorEstaEnUso(unJugador.getColor()))
            throw new ExcepcionColorEnUso();

        this.jugadores.add(unJugador);
    }

    public int getCantidadDeJugadores() {
        return jugadores.size();
    }

    private boolean elNombreEstaEnUso(String nombre) {
        for (Jugador jugador : jugadores) {
            if ( (jugador.getNombre()).equals(nombre) ) {
               return true;
            }
        }
        return false;
    }

    private boolean elColorEstaEnUso(Color color) {
        for (Jugador jugador : jugadores) {
            if (jugador.getColor() == color) {
                return true;
            }
        }
        return false;
    }

  private void finJuego(Jugador perdedor){
//	  System.out.println(perdedor.getNombre());
	  //fin del juego
  }

    public void pasarTurno(Jugador jugador) throws ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa {
        sistemaDeTurnos.pasarTurno(jugador);
        if(jugador.esPerdedor())
        	this.finJuego(jugador);
    }
}
