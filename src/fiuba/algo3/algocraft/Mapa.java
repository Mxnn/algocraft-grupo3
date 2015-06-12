package fiuba.algo3.algocraft;
import fiuba.algo3.algocraft.excepciones.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Mapa {
    private static final int NUMERO_DE_BASES_MAXIMO = 4;

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

    public void insertarParcela(Parcela parcela) {
        this.tablero.put(parcela.getCoordenada(), parcela);
    }

    private void validarNumeroDeBases(int numero) throws ExcepcionNumeroDeBasesInvalido {
        if (numero >= 2 && numero <= NUMERO_DE_BASES_MAXIMO)
            throw new ExcepcionNumeroDeBasesInvalido();
    }

    private void llenarMapaConParcelasDeTierra() {
    	for (int x = 0; x < this.filas; x++){
    	     for (int y = 0; y < this.columnas; y++){
    	    	 Coordenada coordenada = new Coordenada(x,y);
    			 Parcela parcela = new ParcelaTierra(coordenada);
    	    	 this.tablero.put(coordenada, parcela);
    	     }
    	}
    }

    public void ubicarElementoEnParcela(Coordenada coordenada, Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada {
        if (this.coordenadaExiste(coordenada)) {
            Parcela parcela = this.tablero.get(coordenada);
            parcela.guardarElemento(elemento);
            elemento.setParcela(parcela);
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

	public void calcularItinerario(Coordenada desde, Coordenada hasta) throws ExcepcionCoordenadaFueraDelMapa { 
		
		LinkedList<Coordenada> elItinerario = new LinkedList<Coordenada>();
		
		/*int auxX = desde.getX();
		int auxY = desde.getY();
		
	 	int hastaX = hasta.getX();
		int hastaY= hasta.getY();
		elItinerario.add(new Coordenada(auxX,auxY));
		
		while ((auxX!=hasta.getX())||(auxY!=hasta.getY())){
			System.out.println("avant llego auxX=");
			System.out.println(auxX);
			System.out.println("nollego");
			System.out.println("auxX=");
			System.out.println(auxX);
			System.out.println("hastaX=");
			System.out.println(hasta.getX());
			if (auxX!=hasta.getX()){
				int direccion;
				if (auxX<hastaX){
					direccion = 1;
				}else{
					direccion = -1;
				}
				
				System.out.println(direccion);	
				
				while ((this.devolverElementoEnParcela(new Coordenada(auxX+ direccion, auxY))==null) && (auxX!=hastaX)){
					auxX = auxX + direccion;
					elItinerario.add(new Coordenada(auxX,auxY));
					System.out.println("x");
					System.out.println("auxX=");
					System.out.println(auxX);
				}
				System.out.println("apres while auxX=");
				System.out.println(auxX);
			}
			System.out.println("apres while et sorti if auxX=");
			System.out.println(auxX);
			
			if(auxY!=hasta.getY()){
			
				int direccion;
				if (auxY<hastaY){
					direccion = 1;
				}else{
					direccion = -1;
				}
				
				System.out.println(direccion);
				
				while ((this.devolverElementoEnParcela(new Coordenada(auxX, direccion+ auxY))==null)&& (auxY!=hastaY)){
					auxY=auxY + direccion;
					elItinerario.add(new Coordenada(auxX,auxY));
					System.out.println("y");
				}
				
			}
			
			System.out.println("a while auxX=");
			System.out.println(auxX);
		}*/
		
		Parcela parcelaPartida = this.tablero.get(desde);
		Unidad laUnidad = (Unidad) parcelaPartida.elemento;
		laUnidad.itinerario = elItinerario;
		
		elItinerario.clear();
		elItinerario.add(desde); // la unidad se teleporta , tenemos que hacer un mejor calcul de itinerario
		elItinerario.add(hasta);

		laUnidad.itinerario = elItinerario;
		
	}

	public void ubicarCercaDeParcela(Parcela parcela, Interactuable elemento) throws ExcepcionNoHayLugarDisponible{
		Boolean elementoUbicado = false;
        ArrayList<Coordenada> coordenadasVecinas = ((parcela).getCoordenada()).obtenerCoordenadasVecinas();
		while (!elementoUbicado && coordenadasVecinas.size() > 0) {
            try {
                this.ubicarElementoEnParcela(coordenadasVecinas.get(0), elemento);
            }
            catch (ExcepcionElementoNoAdmitidoEnParcela e) {
                coordenadasVecinas.remove(0);
                continue;
            }
            catch (ExcepcionParcelaOcupada e) {
                coordenadasVecinas.remove(0);
                continue;
            }
            catch (ExcepcionCoordenadaFueraDelMapa excepcionCoordenadaFueraDelMapa) {
                coordenadasVecinas.remove(0);
                continue;
            }
            elementoUbicado = true;
        }
		if (coordenadasVecinas.size() <= 0)
          throw new ExcepcionNoHayLugarDisponible();

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
