package fiuba.algo3.algocraft.vista;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class VistaBotonInteractuable extends JButton {

	public VistaBotonInteractuable(){
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
