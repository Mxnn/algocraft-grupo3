package fiuba.algo3.algocraft;

public class Mapa {
	private String nombre;
    private int columnas;
    private int filas;
    private Parcela [][] matrizDeParcelas;

    
    public Mapa(String nombre, int columnas, int filas) {
        this.nombre = nombre;
        this.columnas = columnas;
        this.filas = filas;
        this.matrizDeParcelas = new Parcela [columnas][filas];
        this.llenarMapaConParcelas();
    }

    private void llenarMapaConParcelas() {
    	for (int fil = 0; fil < this.filas; fil++)
    	     for (int col = 0; col < this.columnas; col++)
    	    	 this.matrizDeParcelas[col][fil] = new Parcela();
    }
    
    public void ubicarElementoEnCoordenada(int x, int y, Interactuable item) {
    	Parcela parcela = this.matrizDeParcelas[x][y];
    	parcela.guardarElemento(item);
    }
    
    public Interactuable devolverElementoEnCoordenada(int x, int y) {
    	Parcela parcela = this.matrizDeParcelas[x][y];

    	return parcela.devolverElemento();
    }
}
