package fiuba.algo3.algocraft.vista;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;

public class VistaBarraLateral extends JTabbedPane {
    private final Color COLOR_JUGADOR_QUE_NO_JUEGA = Color.gray;
    private static final String LABEL_NOMBRE = "Nombre:";
    private static final String LABEL_MINERALES = "Minerales:";
    private static final String LABEL_GAS = "Gas:";
    private static final String LABEL_POBLACION = "Poblacion/MAX:";

    private ArrayList<JLabel> labelsJ1 = new ArrayList<JLabel>();
	private JLabel nombreJ1;
	private JLabel mineralJ1;
	private JLabel gasJ1;
	private JLabel poblacionJ1;

    private ArrayList<JLabel> labelsJ2 = new ArrayList<JLabel>();
	private JLabel nombreJ2;
	private JLabel mineralJ2;
	private JLabel gasJ2;
	private JLabel poblacionJ2;

	private JLabel error;
	private Representador representador;
	
	public VistaBarraLateral() {
		//hay que modificar para que el tabbedPane se cree desde este constructor
        representador = new Representador();
        int y=0;
        this.setBounds(627, 0, 281, 641);
        JPanel panelInfo = new JPanel();

        this.addTab("Informacion", panelInfo);
        GridBagLayout gbl_panelInfo = new GridBagLayout();
        gbl_panelInfo.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_panelInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelInfo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panelInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelInfo.setLayout(gbl_panelInfo);

        JLabel lblInformacionElementoSeleccionado = new JLabel("Informacion Elemento Seleccionado");
        GridBagConstraints gbc_lblInformacionElementoSeleccionado = new GridBagConstraints();
        gbc_lblInformacionElementoSeleccionado.insets = new Insets(0, 0, 5, 5);
        gbc_lblInformacionElementoSeleccionado.anchor = GridBagConstraints.EAST;
        gbc_lblInformacionElementoSeleccionado.gridx = 2;
        gbc_lblInformacionElementoSeleccionado.gridy = 0;
        panelInfo.add(lblInformacionElementoSeleccionado, gbc_lblInformacionElementoSeleccionado);
        y++;

        JSeparator separator = new JSeparator();
        GridBagConstraints gbc_separator = new GridBagConstraints();
        gbc_separator.insets = new Insets(0, 0, 5, 5);
        gbc_separator.gridx = 2;
        gbc_separator.gridy = y;
        panelInfo.add(separator, gbc_separator);
        y++;

        JLabel lblInformacionJugador = new JLabel("Informacion Jugador 1");
        GridBagConstraints gbc_lblInformacionJugador = new GridBagConstraints();
        gbc_lblInformacionJugador.insets = new Insets(0, 0, 5, 5);
        gbc_lblInformacionJugador.gridx = 2;
        gbc_lblInformacionJugador.gridy = y;
        panelInfo.add(lblInformacionJugador, gbc_lblInformacionJugador);
        y++;

        JLabel lblNombre = new JLabel(LABEL_NOMBRE);
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = y;
        panelInfo.add(lblNombre, gbc_lblNombre);

        JLabel lblNombreJ1 = new JLabel("");
        this.nombreJ1 = lblNombreJ1;
        GridBagConstraints gbc_lblNombreJ1 = new GridBagConstraints();
        gbc_lblNombreJ1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombreJ1.gridx = 2;
        gbc_lblNombreJ1.gridy = y;
        panelInfo.add(lblNombreJ1, gbc_lblNombreJ1);
        y++;

        JLabel lblMinerales = new JLabel(LABEL_MINERALES);
        GridBagConstraints gbc_lblMinerales = new GridBagConstraints();
        gbc_lblMinerales.insets = new Insets(0, 0, 5, 5);
        gbc_lblMinerales.gridx = 1;
        gbc_lblMinerales.gridy = y;
        panelInfo.add(lblMinerales, gbc_lblMinerales);

        JLabel lblCantminj1 = new JLabel("");
        this.mineralJ1 = lblCantminj1;
        GridBagConstraints gbc_lblCantminj1 = new GridBagConstraints();
        gbc_lblCantminj1.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantminj1.gridx = 2;
        gbc_lblCantminj1.gridy = y;
        panelInfo.add(lblCantminj1, gbc_lblCantminj1);
        y++;

        JLabel lblGas = new JLabel(LABEL_GAS);
        GridBagConstraints gbc_lblGas = new GridBagConstraints();
        gbc_lblGas.insets = new Insets(0, 0, 5, 5);
        gbc_lblGas.gridx = 1;
        gbc_lblGas.gridy = y;
        panelInfo.add(lblGas, gbc_lblGas);


        JLabel lblCantgasj1 = new JLabel("");
        this.gasJ1 = lblCantgasj1;
        GridBagConstraints gbc_lblCantgasj1 = new GridBagConstraints();
        gbc_lblCantgasj1.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantgasj1.gridx = 2;
        gbc_lblCantgasj1.gridy = y;
        panelInfo.add(lblCantgasj1, gbc_lblCantgasj1);
        y++;

        JLabel lblSuministros = new JLabel(LABEL_POBLACION);
        GridBagConstraints gbc_lblSuministros = new GridBagConstraints();
        gbc_lblSuministros.insets = new Insets(0, 0, 5, 5);
        gbc_lblSuministros.gridx = 1;
        gbc_lblSuministros.gridy = y;
        panelInfo.add(lblSuministros, gbc_lblSuministros);

        JLabel lblPoblacionj1 = new JLabel("");
        this.poblacionJ1 = lblPoblacionj1;
        GridBagConstraints gbc_lblPoblacionj1 = new GridBagConstraints();
        gbc_lblPoblacionj1.insets = new Insets(0, 0, 5, 5);
        gbc_lblPoblacionj1.gridx = 2;
        gbc_lblPoblacionj1.gridy = y;
        panelInfo.add(lblPoblacionj1, gbc_lblPoblacionj1);
        y++;

        JLabel lblInformacionJugador_1 = new JLabel("Informacion Jugador 2");
        GridBagConstraints gbc_lblInformacionJugador_1 = new GridBagConstraints();
        gbc_lblInformacionJugador_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblInformacionJugador_1.gridx = 2;
        gbc_lblInformacionJugador_1.gridy = y;
        panelInfo.add(lblInformacionJugador_1, gbc_lblInformacionJugador_1);
        y++;

        JLabel label = new JLabel(LABEL_NOMBRE);
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 1;
        gbc_label.gridy = y;
        panelInfo.add(label, gbc_label);

        JLabel lblNombreJ2 = new JLabel("");
        this.nombreJ2 = lblNombreJ2;
        GridBagConstraints gbc_lblNombreJ2 = new GridBagConstraints();
        gbc_lblNombreJ2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombreJ2.gridx = 2;
        gbc_lblNombreJ2.gridy = y;
        panelInfo.add(lblNombreJ2, gbc_lblNombreJ2);
        y++;

        JLabel label_1 = new JLabel(LABEL_MINERALES);
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 1;
        gbc_label_1.gridy = y;
        panelInfo.add(label_1, gbc_label_1);

        JLabel lblCantminj2 = new JLabel("");
        this.mineralJ2 = lblCantminj2;
        GridBagConstraints gbc_lblCantminj2 = new GridBagConstraints();
        gbc_lblCantminj2.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantminj2.gridx = 2;
        gbc_lblCantminj2.gridy = y;
        panelInfo.add(lblCantminj2, gbc_lblCantminj2);
        y++;

        JLabel label_2 = new JLabel(LABEL_GAS);
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.insets = new Insets(0, 0, 5, 5);
        gbc_label_2.gridx = 1;
        gbc_label_2.gridy = y;
        panelInfo.add(label_2, gbc_label_2);

        JLabel lblCantgasj2 = new JLabel("");
        this.gasJ2 = lblCantgasj2;
        GridBagConstraints gbc_lblCantgasj2 = new GridBagConstraints();
        gbc_lblCantgasj2.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantgasj2.gridx = 2;
        gbc_lblCantgasj2.gridy = y;
        panelInfo.add(lblCantgasj2, gbc_lblCantgasj2);
        y++;

        JLabel label_3 = new JLabel(LABEL_POBLACION);
        GridBagConstraints gbc_label_3 = new GridBagConstraints();
        gbc_label_3.insets = new Insets(0, 0, 5, 5);
        gbc_label_3.gridx = 1;
        gbc_label_3.gridy = y;
        panelInfo.add(label_3, gbc_label_3);

        JLabel lblPoblacionj2 = new JLabel("");
        this.poblacionJ2 = lblPoblacionj2;
        GridBagConstraints gbc_lblPoblacionj2 = new GridBagConstraints();
        gbc_lblPoblacionj2.insets = new Insets(0, 0, 5, 5);
        gbc_lblPoblacionj2.gridx = 2;
        gbc_lblPoblacionj2.gridy = y;
        panelInfo.add(lblPoblacionj2, gbc_lblPoblacionj2);

        JPanel acciones = new JPanel();
        this.addTab("Acciones", acciones);

        JPanel panelError = new JPanel();
        this.addTab("Errores", null, panelError, null);

        JLabel lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panelError.add(lblError);
        this.error = lblError;

        this.labelsJ1.add(this.nombreJ1);
        this.labelsJ1.add(this.gasJ1);
        this.labelsJ1.add(this.mineralJ1);
        this.labelsJ1.add(this.poblacionJ1);

        this.labelsJ2.add(this.nombreJ2);
        this.labelsJ2.add(this.gasJ2);
        this.labelsJ2.add(this.mineralJ2);
        this.labelsJ2.add(this.poblacionJ2);
	}

	public void refrescar(Juego modelo) {
		Jugador j1 = modelo.getJugadores().get(0);
		Jugador j2 = modelo.getJugadores().get(1);
		
		this.nombreJ1.setText(j1.getNombre());
		this.mineralJ1.setText(Integer.toString(j1.getMinerales()));
		this.gasJ1.setText(Integer.toString(j1.getGasVespeno()));
        this.poblacionJ1.setText(Integer.toString(j1.getPoblacion()) + "/" + Integer.toString(j1.getCapacidadDePoblacion()));
		
		this.nombreJ2.setText(j2.getNombre());
		this.mineralJ2.setText(Integer.toString(j2.getMinerales()));
		this.gasJ2.setText(Integer.toString(j2.getGasVespeno()));
        this.poblacionJ2.setText(Integer.toString(j2.getPoblacion()) + "/" + Integer.toString(j2.getCapacidadDePoblacion()));

		Color colorJugadorQueJuega = representador.getColorTexto(modelo.getJugadorQueJuega());
		
        if ((modelo.getJugadorQueJuega()).equals(modelo.getJugadores().get(0))) {
            this.cambiarColorDeLabels(this.labelsJ1, colorJugadorQueJuega);
            this.cambiarColorDeLabels(this.labelsJ2, COLOR_JUGADOR_QUE_NO_JUEGA);
        }
        else {
            this.cambiarColorDeLabels(this.labelsJ2, colorJugadorQueJuega);
            this.cambiarColorDeLabels(this.labelsJ1, COLOR_JUGADOR_QUE_NO_JUEGA);
        }
        this.setSelectedIndex(0);
        this.repaint();
	}

    private void cambiarColorDeLabels(ArrayList<JLabel> labels, Color color) {
        for (JLabel label: labels) {
            label.setForeground(color);
        }
    }
	
	public void setPanelAcciones(JPanel accion){
		this.setComponentAt(1, accion);
		this.repaint();
	}
	
	public void displayError(String msg){
		this.setSelectedIndex(2);
		this.error.setText(msg);
		this.repaint();
	}
}
