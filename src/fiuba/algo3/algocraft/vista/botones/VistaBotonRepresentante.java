package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;

public abstract class VistaBotonRepresentante extends VistaBotonInteractuable {
    protected Interactuable elementoRepresentado;

    public VistaBotonRepresentante(Interactuable elemento) {
        this.elementoRepresentado = elemento;
        this.setEnabled(elemento.estaCreado());
    }
}
