package fiuba.algo3.algocraft.controlador.accionesDeUnidades;

import java.awt.event.ActionEvent;

import fiuba.algo3.algocraft.controlador.comandos.AccionPorTurnoListener;
import fiuba.algo3.algocraft.controlador.JuegoListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaVacia;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadEnemiga;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadNoClonable;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;

public class ObjetivoListener extends JuegoListener {
	private Coordenada ubicacion;
	private Juego modelo;
	
	public ObjetivoListener(Juego modelo,Coordenada ubicacionParcela){
		super(modelo);
		this.modelo = modelo;
		this.ubicacion = ubicacionParcela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			try {
				AccionPorTurnoListener.createInstance().ejecutarAccionDeTurno(this.modelo.getMapa(),this.ubicacion);
			} catch (ExcepcionEnemigoFueraDeAlcance e1) {
				this.mostrarError(e1.getMessage());

			} catch (ExcepcionEnergiaInsuficiente e1) {
				this.mostrarError(e1.getMessage());
			}catch (NullPointerException e1){
				this.mostrarError("Seleccionar Accion Primero");
				
			}catch (ExcepcionEstadoMuerto e1){
				//
			}catch (ExcepcionParcelaVacia e1){
				this.mostrarError(e1.getMessage());
			} catch (ExcepcionUnidadEnemiga e1) {
				this.mostrarError(e1.getMessage());
			} catch (ExcepcionNoHayLugarDisponible e1) {
				this.mostrarError(e1.getMessage());
			} catch (ExcepcionNoHaySuministrosDisponibles e1) {
				this.mostrarError(e1.getMessage());
			} catch (ExcepcionUnidadNoClonable e1) {
				this.mostrarError(e1.getMessage());
			} catch (ExcepcionRecursosInsuficientes e1) {
				this.mostrarError(e1.getMessage());
			}
	}

}
