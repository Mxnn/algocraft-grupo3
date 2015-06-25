package fiuba.algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.mapa.Randomizador;
import fiuba.algo3.algocraft.modelo.mapa.RandomizadorTests;

public class GeneradorMapa {
	private Mapa mapa;
	private Randomizador rand;
	
	public GeneradorMapa() throws ExcepcionNumeroDeBasesInvalido{
    	this.mapa = new Mapa (2, 30, 30);
//    	this.rand = new RandomizadorTests();
    	this.rand = new Randomizador();
    	this.crearEspaciosEnElMapa();
    	this.crearMineralesPorElMapa();
    	this.crearBasesEnMapa();
//        this.sistemaDeTurnos = new SistemaDeTurnos(this.jugadores,this.mapa);
	}
	
	public Mapa getMapa(){
		return this.mapa;
	}

    public void setMapaParaTests() throws ExcepcionNumeroDeBasesInvalido{
    	this.mapa = new Mapa (2, 20, 20);
    	this.mapa.llenarMapaConParcelasDeTierra();
    	this.rand = new RandomizadorTests();
    	this.crearEspaciosEnElMapa();
    	this.crearMineralesPorElMapa();
    	this.crearBasesEnMapa();
//    	this.sistemaDeTurnos = new SistemaDeTurnos(this.jugadores,this.mapa);
    }
    
    private void crearBasesEnMapa() {
    	int x = this.rand.randInt(0, 4); //calcular bordes desde el mapa
    	int y = this.rand.randInt(0, this.mapa.getFilas());
//    	System.out.println(x);
//    	System.out.println(y);
    	
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
    }

    private void crearMineralesPorElMapa() {
    	int cantMinerales = this.rand.randInt(10,20); //sacar magic number
    	for(int i=0; i<cantMinerales; i++){
    		int x = this.rand.randInt(0, this.mapa.getColumnas());
        	int y = this.rand.randInt(0, this.mapa.getFilas());
        	Coordenada coordenada = new Coordenada(x,y);
        	if (this.mapa.coordenadaExiste(coordenada))
        		this.mapa.insertarParcela(new ParcelaMineral(coordenada));
    	}
    }

    private void crearEspaciosEnElMapa() {
    	int cantEspacios = this.rand.randInt(3, 8);
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

    }
}
