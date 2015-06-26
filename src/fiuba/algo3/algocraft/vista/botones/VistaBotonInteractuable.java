package fiuba.algo3.algocraft.vista.botones;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class VistaBotonInteractuable extends JButton{

	public VistaBotonInteractuable(){
		//no se por que quedan mas grandes que la parcela, como que le comen el borde
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setEnabled(false); 
//        Font font = this.getFont();
//	    font = font.deriveFont(font.getSize() * 0.8f);
//	    this.setFont(font);
	}
}
