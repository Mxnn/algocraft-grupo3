package fiuba.algo3.algocraft;

public class Mapa {
	private String nombre;
    private int columnas;
    private int filas;
    HashMap<Coordenada, Parcela> tablero; 

    
    public Mapa(String nombre, int columnas, int filas) {
        this.nombre = nombre;
        this.columnas = columnas;
        this.filas = filas;
        this.tablero = new HashMap<List, Parcela>();
        this.llenarMapaConParcelasDeTierra();
    }

    private void llenarMapaConParcelasDeTierra() {
    	for (int fil = 0; fil < this.filas; fil++){
    	     for (int col = 0; col < this.columnas; col++){
    	    	 Coordenada coordenada = new Coordenada(x,y);
    			 Parcela parcela = new ParcelaTierra();
    	    	 this.tablero.put(coordenada,parcela);
    	     }
    	}
    }
    
    public void ubicarElementoEnParcela(int x, int y, Interactuable elemento) throws ExcepcionElementoInvalidoParaParcela {
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
