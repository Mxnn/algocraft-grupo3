package fiuba.algo3.algocraft;
import fiuba.algo3.algocraft.Excepciones.*;

import java.util.HashMap;

public class Mapa {
    private static final int NUMERO_DE_BASES_MAXIMO = 4;

    private int numeroDeBases;
    private int columnas;
    private int filas;
    private HashMap<Coordenada, Parcela> tablero;

    
    public Mapa(int numeroDeBases, int columnas, int filas) throws ExcepcionNumeroDeBasesInvalido {
        this.validarNumeroDeBases(numeroDeBases);
        this.columnas = columnas;
        this.filas = filas;
        this.tablero = new HashMap<Coordenada, Parcela>();
        this.llenarMapaConParcelasDeTierra();
    }

    private void validarNumeroDeBases(int numero) throws ExcepcionNumeroDeBasesInvalido {
        if (numero >= 2 && numero <= NUMERO_DE_BASES_MAXIMO)
            this.numeroDeBases = numero;
        else
            throw new ExcepcionNumeroDeBasesInvalido();
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
    
    public void ubicarElementoEnParcela(Coordenada coordenada, Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        if (this.coordenadaExiste(coordenada)) {
            Parcela parcela = this.tablero.get(coordenada);
            parcela.guardarElemento(elemento);
        }
        else
            throw new ExcepcionCoordenadaFueraDelMapa();
    }
    
    public Interactuable devolverElementoEnParcela(Coordenada coordenada) throws ExcepcionCoordenadaFueraDelMapa {
        if (this.coordenadaExiste(coordenada)) {
            Parcela parcela = this.tablero.get(coordenada);

            return parcela.devolverElemento();
        }
        else
            throw new ExcepcionCoordenadaFueraDelMapa();
    }

    private boolean coordenadaExiste(Coordenada coordenada) {
        return ( (coordenada.getX() >= 0 && coordenada.getX() < this.columnas) && (coordenada.getY() >= 0 && coordenada.getY() < this.filas) );
    }
}
