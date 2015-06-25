package fiuba.algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.mapa.Randomizador;
import fiuba.algo3.algocraft.modelo.mapa.RandomizadorTests;
import fiuba.algo3.algocraft.vista.ObservadorMapa;

public class GeneradorMapa {
	private Mapa mapa;
	private Randomizador rand;
	private ArrayList<ObservadorMapa> observadores;
	
	public GeneradorMapa() throws ExcepcionNumeroDeBasesInvalido{
		this.observadores = new ArrayList<ObservadorMapa>();
    	this.mapa = new Mapa (2, 30, 30);
//    	this.llenarMapaConParcelasDeTierra();
    	this.rand = new Randomizador();
    	this.crearEspaciosEnElMapa();
    	this.crearMineralesPorElMapa();
    	this.crearBasesEnMapa();
	}
	
	public GeneradorMapa(ObservadorMapa observador) throws ExcepcionNumeroDeBasesInvalido {
//		new GeneradorMapa(); probar si funciona despues
		this.observadores = new ArrayList<ObservadorMapa>();
		this.observadores.add(observador);
    	this.mapa = new Mapa (2, 30, 30);
//    	this.llenarMapaConParcelasDeTierra();
    	this.rand = new Randomizador();
    	this.crearEspaciosEnElMapa();
    	this.crearMineralesPorElMapa();
    	this.crearBasesEnMapa();
		
	}

	public Mapa getMapa(){
		return this.mapa;
	}

    public void setMapaParaTests() throws ExcepcionNumeroDeBasesInvalido{
    	this.mapa = new Mapa (2, 20, 20);
//    	this.llenarMapaConParcelasDeTierra();
    	this.rand = new RandomizadorTests();
    	this.crearEspaciosEnElMapa();
    	this.crearMineralesPorElMapa();
    	this.crearBasesEnMapa();
    }

//    public void llenarMapaConParcelasDeTierra() {
//    	for (int x = 0; x <=this.mapa.getFilas(); x++){
//    	     for (int y = 0; y < this.mapa.getColumnas(); y++){
//    	    	 Coordenada coordenada = new Coordenada(x,y);
//    	    	 this.setearParcelaTierra(new Coordenada(x,y));
//    	     }
//    	}
//    }
    
//    private void setearParcelaTierra(Coordenada coordenada){
//    	ParcelaTierra parcela = new ParcelaTierra(coordenada);
//    	this.mapa.insertarParcela(parcela);
//    	for(int i=0; i<this.observadores.size();i++){
//    		ObservadorMapa observador = this.observadores.get(i);
//    		observador.crearVistaParcela(parcela);
//    	}
//    }
    private void setearParcelaMineral(Coordenada coordenada){
    	ParcelaMineral parcela = new ParcelaMineral(coordenada);
    	this.mapa.insertarParcela(parcela);
    	for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearVistaParcela(parcela);
    	}
    }
    
    private void setearParcelaVolcan(Coordenada coordenada){
    	ParcelaVolcan parcela = new ParcelaVolcan(coordenada);
    	this.mapa.insertarParcela(parcela);
    	for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearVistaParcela(parcela);
    	}
    }
    private void setearParcelaEspacio(Coordenada coordenada){
    	ParcelaEspacio parcela = new ParcelaEspacio(coordenada);
    	this.mapa.insertarParcela(parcela);
    	for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearVistaParcela(parcela);
    	}
    }
    
    private void crearBasesEnMapa() {
    	int x = this.rand.randInt(0, 4); //calcular bordes desde el mapa
    	int y = this.rand.randInt(0, this.mapa.getFilas());
//    	System.out.println(x);
//    	System.out.println(y);
    	
//    	this.mapa.insertarParcela(new ParcelaVolcan(new Coordenada(x,y)));
    	this.setearParcelaVolcan(new Coordenada(x,y));
    	
//    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(x+1,y)));
//    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(x+2,y)));
    	this.setearParcelaMineral(new Coordenada(x+1,y));
    	this.setearParcelaMineral(new Coordenada(x+2,y));
    	
//    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(x,y+1)));
//    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(x,y+2)));
    	this.setearParcelaMineral(new Coordenada(x,y+1));
    	this.setearParcelaMineral(new Coordenada(x,y+2));
    	
    	int xEspejada = this.mapa.getColumnas()-1-x;
    	int yEspejada = this.mapa.getFilas()-1-y;
    	
    	Coordenada coordenadaOpuesta = new Coordenada(xEspejada,yEspejada);
//    	this.mapa.insertarParcela(new ParcelaVolcan(new Coordenada(xEspejada,yEspejada)));
    	this.setearParcelaVolcan(coordenadaOpuesta);
    	
//    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(xEspejada-1,yEspejada)));
//    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(xEspejada-2,yEspejada)));
    	this.setearParcelaMineral(new Coordenada(xEspejada-1,yEspejada));
    	this.setearParcelaMineral(new Coordenada(xEspejada-2,yEspejada));
    	
//    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(xEspejada,yEspejada-1)));
//    	this.mapa.insertarParcela(new ParcelaMineral(new Coordenada(xEspejada,yEspejada-2)));
    	this.setearParcelaMineral(new Coordenada(xEspejada,yEspejada-1));
    	this.setearParcelaMineral(new Coordenada(xEspejada,yEspejada-2));
    }

    private void crearMineralesPorElMapa() {
    	int cantMinerales = this.rand.randInt(10,20); //sacar magic number
    	for(int i=0; i<cantMinerales; i++){
    		int x = this.rand.randInt(0, this.mapa.getColumnas());
        	int y = this.rand.randInt(0, this.mapa.getFilas());
        	Coordenada coordenada = new Coordenada(x,y);
        	if (this.mapa.coordenadaExiste(coordenada))
//        		this.mapa.insertarParcela(new ParcelaMineral(coordenada));
        		this.setearParcelaMineral(coordenada);
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
//        			this.mapa.insertarParcela(new ParcelaEspacio(coordenadas.get(j)));
        			this.setearParcelaEspacio(coordenadas.get(j));
        	}	
    	}

    }
}
