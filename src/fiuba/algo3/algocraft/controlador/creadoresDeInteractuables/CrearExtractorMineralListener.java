package fiuba.algo3.algocraft.controlador.creadoresDeInteractuables;

import java.awt.event.ActionEvent;

import fiuba.algo3.algocraft.controlador.ConstruccionListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;

public class CrearExtractorMineralListener extends ConstruccionListener {
	public CrearExtractorMineralListener(Juego modelo, Coordenada ubicacion) {
		super(modelo, ubicacion);
	}

    @Override
    public void actionPerformed(ActionEvent e){
		try {
		    this.modelo.getJugadorQueJuega().crearExtractorMineral(this.modelo.getMapa(), this.ubicacion);
        } catch (ExcepcionRecursosInsuficientes e1) {
            this.mostrarError(msjRecursosInsuficientes);
        } catch (ExcepcionParcelaOcupada e1) {
            this.mostrarError(msjParcelaOcupada);
        } catch (ExcepcionElementoNoAdmitidoEnParcela e1) {
            this.mostrarError(msjElementoNoAdmitido);
        } catch (ExcepcionCoordenadaFueraDelMapa e1) {
            this.mostrarError(msjCoordenadaFueraDelMapa);
        }
    }
}