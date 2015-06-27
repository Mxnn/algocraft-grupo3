package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCreadorUnidadesBasicasListener implements ActionListener {
	private Juego modelo;
	private int x;
	private int y;
	
	public CrearCreadorUnidadesBasicasListener(Juego modelo, int x, int y){
		this.modelo = modelo;
		this.x = x;
		this.y = y;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
			this.modelo.getJugadorQueJuega().crearCreadorDeUnidadesBasicas(this.modelo.getMapa(), new Coordenada(this.x, this.y));
		} catch (ExcepcionRecursosInsuficientes e1) {
			e1.printStackTrace();
		} catch (ExcepcionParcelaOcupada e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExcepcionElementoNoAdmitidoEnParcela e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExcepcionCoordenadaFueraDelMapa e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}
