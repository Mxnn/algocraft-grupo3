package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.controlador.CerrarFrameControlador;
import fiuba.algo3.algocraft.controlador.NuevoJugadorControlador;
import fiuba.algo3.algocraft.modelo.juego.Juego;

import javax.swing.*;

public class NuevoJugadorVista extends JFrame {
    private JTextField textNombre;
    private JComboBox comboColor;
    private JComboBox comboRaza;
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JPanel panelPrincipal;
    private Juego modelo;

    public NuevoJugadorVista(Juego modelo, String titulo) {
        //Configurando la ventana
        super(titulo);
        this.setContentPane(panelPrincipal);
        this.pack();
        this.setSize(this.getWidth() + 100, this.getHeight());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        this.modelo = modelo;

        //Controladores de botones
        this.botonAceptar.addActionListener(new NuevoJugadorControlador(modelo, this));
        this.botonCancelar.addActionListener(new CerrarFrameControlador(this));
    }

    public int getNumeroDeColorElegido() {
        return this.comboColor.getSelectedIndex();
    }

    public int getNumeroDeRazaElegida() {
        return this.comboRaza.getSelectedIndex();
    }

    public String getNombreElegido() {
        return this.textNombre.getText();
    }
}
