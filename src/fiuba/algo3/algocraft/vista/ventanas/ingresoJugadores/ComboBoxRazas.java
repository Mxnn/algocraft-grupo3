package fiuba.algo3.algocraft.vista.ventanas.ingresoJugadores;

import fiuba.algo3.algocraft.modelo.razas.Raza;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;

import javax.swing.*;

public class ComboBoxRazas extends JComboBox<String> {
    public ComboBoxRazas() {
        this.addItem("Terran");
        this.addItem("Protoss");
    }

    public Raza getRazaElegida() {
        if (this.getSelectedIndex() == 0)
            return Terran.getInstance();

        return Protoss.getInstance();
    }
}
