package fiuba.algo3.algocraft.controlador;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CerrarFrameListener implements ActionListener {
    private Window frame;

    public CerrarFrameListener(Window frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        this.frame.dispose();
    }
}
