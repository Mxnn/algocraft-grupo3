package fiuba.algo3.algocraft.vista.ventanas.creadores;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


public class CreadoresVista extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */



	/**
	 * Create the dialog.
	 */
	public CreadoresVista() {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 339, 188);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRaza = new JLabel("Maximiliano Angel Petrucci\r\n");
		lblRaza.setBounds(140, 68, 173, 19);
		contentPanel.add(lblRaza);
		{
			JLabel lblNombreJugador_2 = new JLabel("Creadores : \r\n\t\t\t\t");
			lblNombreJugador_2.setBounds(24, 38, 106, 29);
			contentPanel.add(lblNombreJugador_2);
		}
		
		JLabel lblMalenaMaffei = new JLabel("Malena Maffei\r\n");
		lblMalenaMaffei.setBounds(140, 43, 129, 19);
		contentPanel.add(lblMalenaMaffei);
		
		JLabel lblMatiasDurruty = new JLabel("Matias Durruty");
		lblMatiasDurruty.setBounds(140, 98, 129, 19);
		contentPanel.add(lblMatiasDurruty);
	}


}
