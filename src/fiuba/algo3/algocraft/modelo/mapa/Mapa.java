package fiuba.algo3.algocraft.modelo.mapa;
import java.util.ArrayList;
import java.util.HashMap;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.vista.ObservadorMapa;

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

    public HashMap<Coordenada,Parcela> getTablero(){
    	return this.tablero;
    }
    
    public int getFilas(){
    	return this.filas;
    }

    public int getColumnas(){
    	return this.columnas;
    }

    public void insertarParcela(Parcela parcela) {
        this.tablero.put(parcela.getCoordenada(), parcela);
    }

    private void validarNumeroDeBases(int numero) throws ExcepcionNumeroDeBasesInvalido {
        if (numero < 2 || numero > NUMERO_DE_BASES_MAXIMO)
            throw new ExcepcionNumeroDeBasesInvalido();
    }
//
    public void llenarMapaConParcelasDeTierra() {
    	for (int x = 0; x <=this.filas; x++){
    	     for (int y = 0; y < this.columnas; y++){
    	    	 Coordenada coordenada = new Coordenada(x,y);
    			 Parcela parcela = new ParcelaTierra(coordenada);
    			 this.insertarParcela(parcela);
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

    public boolean coordenadaExiste(Coordenada coordenada) {
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

	
    public ArrayList<Parcela> devolverParcelasEnRadioUno(Parcela parcela) throws ExcepcionCoordenadaFueraDelMapa{
    	ArrayList<Coordenada> coordenadasVecinas = ((parcela).getCoordenada()).obtenerCoordenadasVecinas();
    	ArrayList<Parcela> parcelas = new ArrayList<Parcela>();
    	for (int i = 0; i < coordenadasVecinas.size(); i++) {
    		if(this.coordenadaExiste((coordenadasVecinas).get(i)))
    			parcelas.add(this.obtenerParcelaEnCoordenada((coordenadasVecinas).get(i)));
    	}
    	parcelas.add(parcela);
    	return parcelas;
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
}
