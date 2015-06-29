package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import java.awt.event.ActionEvent;

public class CrearCreadorUnidadesMagicasListener extends ConstruccionListener {
	
	public CrearCreadorUnidadesMagicasListener(Juego modelo, Coordenada ubicacion) {
        super(modelo, ubicacion);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
			this.modelo.getJugadorQueJuega().crearCreadorDeUnidadesMagicas(this.modelo.getMapa(), this.ubicacion);
		} catch (ExcepcionConstruccionesRequeridasNoCreadas e1) {
			this.mostrarError("El creador de unidades avanzadas no fue creado");
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
