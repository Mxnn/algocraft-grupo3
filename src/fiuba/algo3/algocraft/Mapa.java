package fiuba.algo3.algocraft;

public class Mapa {
	private String nombre;
    private int columnas;
    private int filas;
    private int [][] matrizDeParcelas; 
    
    public Mapa(String nombre, int columnas, int filas) {
        this.nombre = nombre;
        this.columnas = columnas;
        this.filas = filas;
        this.matrizDeParcelas = new int [columnas][filas];
        this.llenarMatriz();
    }
 
    private llenarMatriz(){
    	for ( fil = 0; fil<this.filas; fil++ )
    	     for ( col = 0; col<this.columnas; col++ )
    	     {
    	    	 this.matrizDeParcelas [ col][ fil ] = new Parcela();                                         
    	     }
    }
    
    public ubicarEnCoordenada(int x, int y, Interactuable item){
    	Parcela parcela = this.matrizDeParcelas[x][y];
    	parcela.guardar(item);
    	
    }
    
    public devolverElementoEnCoordenada(int x, int y){
    	Parcela parcela = this.matrizDeParcelas[x][y];
    	Interactuable item = parcela.devolverItem();
    	return item;
    }
}
