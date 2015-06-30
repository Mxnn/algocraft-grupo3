package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.NaveTransporte;

import java.awt.event.ActionEvent;

public class NaveTransporteRemoverUnidadListener extends JuegoListener {
    private NaveTransporte representado;

    public NaveTransporteRemoverUnidadListener(Juego modelo, NaveTransporte representado) {
        super(modelo);
        this.representado = representado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.representado.sacarUnidad(this.modelo.getMapa());
        } catch (ExcepcionNoHayLugarDisponible error) {
            this.mostrarError(error.getMessage());
        }
    }
}
