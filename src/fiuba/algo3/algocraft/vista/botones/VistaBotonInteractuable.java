package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.acciones.VistaAcciones;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public abstract class VistaBotonInteractuable extends JButton {
	protected VistaAcciones vistaAcciones;

	public VistaBotonInteractuable() {
        super();
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setEnabled(false);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setFont(this.getFont().deriveFont(this.getFont().getSize() * 0.8f));
	}

    public VistaAcciones getVistaDeAcciones(Juego modelo) {
    	VistaAcciones vistaAcciones = new VistaAcciones(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
