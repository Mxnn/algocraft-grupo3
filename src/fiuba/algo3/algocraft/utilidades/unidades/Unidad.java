package fiuba.algo3.algocraft.utilidades.unidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.*;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.Vitalidad;

public abstract class Unidad extends Interactuable {
	protected int cupoDeTransporte;
    protected int vision;
    protected int suministro;
    protected Coordenada coordenadaDestinacion;

    public Unidad(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, vitalidad, tiempoDeConstruccion);
        this.cupoDeTransporte = cupoDeTransporte;
        this.vision = vision;
        this.suministro = suministro;
        propietario.agregarUnidad(this);
    }

    public void moverHasta(Coordenada unaCoordenada){
    	this.coordenadaDestinacion = unaCoordenada;
    }
    
    public int getVision() {
        return this.vision;
    }

    public void destruir() {
        (this.propietario).eliminarUnidad(this);
    }

    public int getCupoDeTransporte() { return this.cupoDeTransporte; }
    
    public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        parcela.setElemento(this);
    }
    
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnTierra();
    }
    
    public int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnTierra();
    }

    public Jugador getPropietario() {
        return this.propietario;
    }

    public int getSuministro() { return this.suministro; }
    
    public void recibirEmp(){
    	try {
    		(this.vitalidad).recibirEmp();
    	}
        catch (ExcepcionEstadoMuerto e) {
            this.destruir();
        }
    }

    public void vivir(Mapa mapa) {
        (this.vitalidad).regenerar();
        this.mover(mapa);
    }

	private void mover(Mapa mapa) {
		if (this.parcelaUbicacion != null) {
			Coordenada coordenadaActual = this.parcelaUbicacion.getCoordenada();
			if (coordenadaActual != null && this.coordenadaDestinacion != null) {
				Coordenada coordenadaSiguiente = coordenadaActual
						.calcularCoordenadaSiguiente(this.coordenadaDestinacion);
				if (!coordenadaActual.equals(coordenadaSiguiente)) {

					try {
						Parcela nuevaParcelaActual = mapa
								.obtenerParcelaEnCoordenada(coordenadaSiguiente);
						nuevaParcelaActual.guardarElemento(this);
						this.parcelaUbicacion.vaciarParcela();
						this.setParcela(nuevaParcelaActual);

					} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
						this.coordenadaDestinacion = null;
					} catch (ExcepcionParcelaOcupada e) {
						this.coordenadaDestinacion = null;
					} catch (ExcepcionCoordenadaFueraDelMapa excepcionCoordenadaFueraDelMapa) {
						this.coordenadaDestinacion = null;
					}
				}

			}
		}
	}

}