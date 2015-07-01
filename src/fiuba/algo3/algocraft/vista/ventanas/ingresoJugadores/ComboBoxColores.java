package fiuba.algo3.algocraft.vista.ventanas.ingresoJugadores;

import fiuba.algo3.algocraft.modelo.juego.Color;

import javax.swing.*;

public class ComboBoxColores extends JComboBox<Color> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComboBoxColores() {
        this.addItem(Color.ROJO);
        this.addItem(Color.AZUL);
        this.addItem(Color.VERDE);
        this.addItem(Color.AMARILLO);
        this.addItem(Color.VIOLETA);
        this.addItem(Color.NARANJA);
        this.addItem(Color.BLANCO);
        this.addItem(Color.CELESTE);
    }

    public Color getSelectedItem() {
        return (Color) dataModel.getSelectedItem();
    }
}
