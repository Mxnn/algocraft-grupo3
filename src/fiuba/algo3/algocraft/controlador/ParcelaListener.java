package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParcelaListener implements ActionListener {
	int x;
	int y;
	public ParcelaListener(int x, int y) {
        this.x = x;
        this.y = y;
	}

    @Override
	public void actionPerformed(ActionEvent arg0) {
        System.out.println("click en parcela "+x+","+y);
	}
}
