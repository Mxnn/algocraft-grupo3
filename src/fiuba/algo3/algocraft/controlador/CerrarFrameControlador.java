package fiuba.algo3.algocraft.controlador;

import javax.swing.*;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CerrarFrameControlador implements ActionListener {
    private Window frame;
    public CerrarFrameControlador(Window frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.frame.dispose();
    }
}
