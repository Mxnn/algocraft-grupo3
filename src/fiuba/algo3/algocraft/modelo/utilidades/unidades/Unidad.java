package fiuba.algo3.algocraft.modelo.utilidades.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;
import fiuba.algo3.algocraft.vista.ObservadorMapa;

public abstract class Unidad extends Interactuable {
	protected int cupoDeTransporte;
    protected int vision;
    protected int suministro;
    protected Coordenada coordenadaDestinacion;
	private ArrayList<ObservadorMapa> observadores = new ArrayList<ObservadorMapa>(); 

    public Unidad(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro, Costo costo) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes {
        super(propietario, vitalidad, tiempoDeConstruccion, costo);
        this.cupoDeTransporte = cupoDeTransporte;
        this.vision = vision;
        this.suministro = suministro;
        propietario.agregarUnidad(this);
    }

    public void setObservador(ObservadorMapa observador){
    	this.observadores.add(observador);
    }

    public void moverHasta(Coordenada unaCoordenada){
    	this.coordenadaDestinacion = unaCoordenada;
    }
    
    public int getVision() {
        return this.vision;
    }

    @Override
    public void destruir() {
        (this.propietario).eliminarUnidad(this);
    }

    public int getCupoDeTransporte() { return this.cupoDeTransporte; }

    @Override
    public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        parcela.setElemento(this);
    }

    @Override
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }

    @Override
    public void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }

    @Override
    public void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }

    @Override
    public int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnTierra();
    }

    @Override
    public int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnTierra();
    }

    public Jugador getPropietario() {
        return this.propietario;
    }

    public int getSuministro() { 
    	return this.suministro; 
    }
    
    public void recibirEmp(){
    	try {
    		(this.vitalidad).recibirEmp();
    	}
        catch (ExcepcionEstadoMuerto e) {
            this.destruir();
        }
    }

    @Override
    public void vivir(Mapa mapa) throws ExcepcionUnidadParaDeMover {
        (this.vitalidad).regenerar();
       for (int i=0;i<this.vision;i++)
        this.mover(mapa);
    }

	private void mover(Mapa mapa) throws ExcepcionUnidadParaDeMover {
		if (this.parcelaUbicacion != null) {
			Coordenada coordenadaActual = this.parcelaUbicacion.getCoordenada();
			if (coordenadaActual != null && this.coordenadaDestinacion != null) {
				
				if (!coordenadaActual.equals(coordenadaDestinacion)) {
					Coordenada coordenadaSiguiente = coordenadaActual
							.calcularCoordenadaSiguiente(this.coordenadaDestinacion);
					try {
						Parcela parcelaVieja = this.parcelaUbicacion;
						Parcela nuevaParcelaActual = mapa.obtenerParcelaEnCoordenada(coordenadaSiguiente);
						nuevaParcelaActual.guardarElemento(this);
						
//						this.parcelaUbicacion.vaciarParcela();
						parcelaVieja.vaciarParcela();
						this.setParcela(nuevaParcelaActual);
						
				        for (ObservadorMapa observador: this.observadores) {
				    		observador.detectarMovimiento(parcelaVieja.getCoordenada(), nuevaParcelaActual.getCoordenada());
				    	}

					} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
						this.coordenadaDestinacion = null;
						throw new ExcepcionUnidadParaDeMover();
					} catch (ExcepcionParcelaOcupada e) {
						this.coordenadaDestinacion = null;
						throw new ExcepcionUnidadParaDeMover();
					} catch (ExcepcionCoordenadaFueraDelMapa excepcionCoordenadaFueraDelMapa) {
						this.coordenadaDestinacion = null;
						throw new ExcepcionUnidadParaDeMover();
					}
				}else{
					this.coordenadaDestinacion= null;
					throw new ExcepcionUnidadParaDeMover();
				}

			}
		}
	}

}