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
        this.llenarMapaConParcelasDeTierra();
    }

    private void llenarMapaConParcelasDeTierra() {
    	for (int fil = 0; fil < this.filas; fil++)
    	     for (int col = 0; col < this.columnas; col++)
    	    	 this.matrizDeParcelas[col][fil] = new ParcelaTierra();
    }
    
    public void ubicarElementoEnParcela(int x, int y, Interactuable elemento) throws ExcepcionElementoInvalidoParaParcela {
    	Parcela parcela = this.matrizDeParcelas[x][y];
    	parcela.guardarElemento(elemento);
    }
    
    public Interactuable devolverElementoEnParcela(int x, int y) {
    	Parcela parcela = this.matrizDeParcelas[x][y];

    	return parcela.devolverElemento();
    }
}
