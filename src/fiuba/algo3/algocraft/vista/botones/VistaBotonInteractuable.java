package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.MouseHoverParcela;
import fiuba.algo3.algocraft.vista.acciones.VistaAcciones;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public abstract class VistaBotonInteractuable extends JButton {

	public VistaBotonInteractuable() {
        super();
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setFont(this.getFont().deriveFont(this.getFont().getSize() * 0.8f));
        this.addMouseListener(new MouseHoverParcela(this));
	}

    public VistaAcciones getVistaDeAcciones(Juego modelo) {
    	return new VistaAcciones(modelo);
    }
    
    public void removeAllActionListeners(){
    	ActionListener[] listeners = this.getActionListeners(); 
    	for( ActionListener al : listeners) {
            this.removeActionListener( al );
        }
    }
}
