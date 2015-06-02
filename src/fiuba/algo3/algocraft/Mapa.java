package fiuba.algo3.algocraft;
import java.util.HashMap;

public class Mapa {
	private String nombre;
    private int columnas;
    private int filas;
    private HashMap<Coordenada, Parcela> tablero;

    
    public Mapa(String nombre, int columnas, int filas) {
        this.nombre = nombre;
        this.columnas = columnas;
        this.filas = filas;
        this.tablero = new HashMap<Coordenada, Parcela>();
        this.llenarMapaConParcelasDeTierra();
    }

    private void llenarMapaConParcelasDeTierra() {
    	for (int x = 0; x < this.filas; x++){
    	     for (int y = 0; y < this.columnas; y++){
    	    	 Coordenada coordenada = new Coordenada(x,y);
    			 Parcela parcela = new ParcelaTierra();
    	    	 this.tablero.put(coordenada,parcela);
    	     }
    	}
    }
    
    public void ubicarElementoEnParcela(int x, int y, Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela {
    	Coordenada coord = new Coordenada(x,y);
    	Parcela parcela = this.tablero.get(coord);
    	parcela.guardarElemento(elemento);
    }
    
    public Interactuable devolverElementoEnParcela(int x, int y) {
    	Coordenada coord = new Coordenada(x,y);
    	Parcela parcela = this.tablero.get(coord);

    	return parcela.devolverElemento();
    }
}
