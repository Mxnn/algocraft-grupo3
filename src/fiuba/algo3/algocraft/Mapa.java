package fiuba.algo3.algocraft;
import fiuba.algo3.algocraft.Excepciones.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
    			 Parcela parcela = new ParcelaTierra(coordenada);
    	    	 this.tablero.put(coordenada,parcela);
    	     }
    	}
    }
    
    public void ubicarElementoEnParcela(Coordenada coordenada, Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada {
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

    public Parcela obtenerParcelaEnCoordenada(Coordenada coordenada) throws ExcepcionCoordenadaFueraDelMapa {
        if (this.coordenadaExiste(coordenada)) {
            return this.tablero.get(coordenada);
        }
        else {
            throw new ExcepcionCoordenadaFueraDelMapa();
        }
    }

	public void calcularItinerario(Coordenada desde, Coordenada hasta) { 
		//metodo a mejorar , no se evite edificios y quisas las coordenadas no existen en el tablero
		 
		LinkedList<Coordenada> elItinerario = new LinkedList<Coordenada>();
		
		int auxX = desde.getX();
		int auxY = desde.getY();
		Coordenada aux = new Coordenada(auxX,auxY);
		
		while ((auxX!=hasta.getX()) &&(auxY!=hasta.getY()) ){
			if(auxX<hasta.getX()){
				auxX +=1;
			}else{
				if (auxY<hasta.getY()){	
				auxY +=1;
			
				}else{
					if(auxX>hasta.getX()){
						auxX -=1;
					}else{
						if(auxY>hasta.getY()){
							auxY -=1;
						}
					}
				}
		
			}
			elItinerario.add(aux);

		}
		Parcela ParcelaPartida = this.tablero.get(desde);
		Unidad laUnidad = (Unidad) ParcelaPartida.elemento;
		laUnidad.itinerario = elItinerario;
		
	}
	
//	public Coordenada devolverCoordenadaDeElemento(Interactuable elemento) throws ExcepcionElementoNoUbicado{
//		for (HashMap.Entry<Coordenada, Parcela> parCoordenadaParcela : tablero.entrySet()) {
//			Parcela parcela = parCoordenadaParcela.getValue();
//			if (parcela.devolverElemento() == elemento)
//				return parCoordenadaParcela.getKey(); 
//		}
//		throw new ExcepcionElementoNoUbicado();
//	}
//	
//	public int distanciaEntreDosElementos(Interactuable elem1, Interactuable elem2) throws ExcepcionElementoNoUbicado{
//		Coordenada coord1 = this.devolverCoordenadaDeElemento(elem1);
//		Coordenada coord2 = this.devolverCoordenadaDeElemento(elem2);
//		return coord1.distanciaConCoordenada(coord2);
//	}
}
