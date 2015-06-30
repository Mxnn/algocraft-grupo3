package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaVacia;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;

public class ObjetivoListener extends JuegoListener {
	private ControladorAccionPorTurno controladorAccionPorTurno;
	private Coordenada ubicacion;
	private Juego modelo;
	
	public ObjetivoListener(Juego modelo,Coordenada ubicacionParcela){
		super(modelo);
		this.modelo = modelo;
		this.ubicacion = ubicacionParcela;
//		this.controladorAtacar = ControladorAccionPorTurno.createInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			try {
				ControladorAccionPorTurno.createInstance().ejecutarAccionDeTurno(this.modelo.getMapa(),this.ubicacion);
			} catch (ExcepcionEnemigoFueraDeAlcance e1) {
				this.mostrarError(e1.getMessage());

			} catch (ExcepcionEnergiaInsuficiente e1) {
				this.mostrarError(e1.getMessage());
			}catch (NullPointerException e1){
				this.mostrarError("Seleccionar Accion Primero");
				
			}catch (ExcepcionEstadoMuerto e1){
				
			}catch (ExcepcionParcelaVacia e1){
				this.mostrarError(e1.getMessage());
			}
	}

}
