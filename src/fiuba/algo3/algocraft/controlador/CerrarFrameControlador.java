package fiuba.algo3.algocraft.controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CerrarFrameControlador implements ActionListener {
    private JFrame frame;
    public CerrarFrameControlador(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.frame.dispose();
    }
}
