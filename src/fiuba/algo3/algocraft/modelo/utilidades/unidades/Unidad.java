package fiuba.algo3.algocraft.modelo.utilidades.unidades;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
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

public abstract class Unidad extends Interactuable {
	protected int cupoDeTransporte;
    protected int vision;
    protected int suministro;
    protected Coordenada coordenadaDestinacion;

    public Unidad(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro, Costo costo) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, vitalidad, tiempoDeConstruccion, costo);
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

    public int getSuministro() { return this.suministro; }
    
    public void recibirEmp(){
    	try {
    		(this.vitalidad).recibirEmp();
    	}
        catch (ExcepcionEstadoMuerto e) {
            this.destruir();
        }
    }

    @Override
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