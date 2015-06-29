package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.vista.botones.VistaBotonParcela;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHoverParcela implements MouseListener {
    private Color COLOR = Color.white;
    private VistaBotonParcela botonParcela;

    public MouseHoverParcela(VistaBotonParcela buttonActual) {
        this.botonParcela = buttonActual;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.botonParcela.setBorder(new LineBorder(COLOR, 1));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.botonParcela.setBorder(new LineBorder(Color.black, 1));
    }
}
