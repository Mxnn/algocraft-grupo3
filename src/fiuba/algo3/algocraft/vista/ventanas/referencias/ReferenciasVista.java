package fiuba.algo3.algocraft.vista.ventanas.referencias;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;


public class ReferenciasVista extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */



	/**
	 * Create the dialog.
	 */
	public ReferenciasVista() {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 782, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMalenaMaffei = new JLabel("Referencias Protoss");
		lblMalenaMaffei.setForeground(Color.RED);
		lblMalenaMaffei.setBounds(314, 11, 129, 19);
		contentPanel.add(lblMalenaMaffei);
		
		JLabel lblReferenciasTerran = new JLabel("Referencias Terran");
		lblReferenciasTerran.setForeground(Color.RED);
		lblReferenciasTerran.setBounds(56, 11, 129, 19);
		contentPanel.add(lblReferenciasTerran);
		
		JLabel lblEdificios = new JLabel("Edificios");
		lblEdificios.setForeground(Color.RED);
		lblEdificios.setBounds(80, 53, 129, 19);
		contentPanel.add(lblEdificios);
		
		JLabel lblCmCentroDe = new JLabel("CM:     Centro de mineral");
		lblCmCentroDe.setBounds(38, 83, 203, 19);
		contentPanel.add(lblCmCentroDe);
		
		JLabel lblBaBarraca = new JLabel("Ba:     Barraca");
		lblBaBarraca.setBounds(38, 113, 203, 19);
		contentPanel.add(lblBaBarraca);
		
		JLabel lblDsDepositoDe = new JLabel("DS:     Deposito de suministros");
		lblDsDepositoDe.setBounds(38, 143, 203, 19);
		contentPanel.add(lblDsDepositoDe);
		
		JLabel lblReRefineria = new JLabel("Re:     Refineria");
		lblReRefineria.setBounds(38, 173, 203, 19);
		contentPanel.add(lblReRefineria);
		
		JLabel lblFaFabrica = new JLabel("Fa:     Fabrica");
		lblFaFabrica.setBounds(38, 203, 203, 19);
		contentPanel.add(lblFaFabrica);
		
		JLabel lblPetPuertoEstelar = new JLabel("PET:     Puerto estelar Terran");
		lblPetPuertoEstelar.setBounds(38, 233, 203, 19);
		contentPanel.add(lblPetPuertoEstelar);
		
		JLabel lblUnidades = new JLabel("Unidades\r\n");
		lblUnidades.setForeground(Color.RED);
		lblUnidades.setBounds(81, 263, 203, 19);
		contentPanel.add(lblUnidades);
		
		JLabel lblGolliat = new JLabel("Ma:     Marine\r\n");
		lblGolliat.setBounds(38, 293, 203, 19);
		contentPanel.add(lblGolliat);
		
		JLabel lblGoGolliat = new JLabel("Go:     Golliat\r\n");
		lblGoGolliat.setBounds(38, 323, 203, 19);
		contentPanel.add(lblGoGolliat);
		
		JLabel lblEsEspectro = new JLabel("Es:     Espectro\r\n");
		lblEsEspectro.setBounds(38, 353, 203, 19);
		contentPanel.add(lblEsEspectro);
		
		JLabel lblNcNaveCiencia = new JLabel("NC:     Nave ciencia\r\n");
		lblNcNaveCiencia.setBounds(38, 383, 203, 19);
		contentPanel.add(lblNcNaveCiencia);
		
		JLabel lblNttNaveTransporte = new JLabel("NTT:    Nave transporte Terran\r\n");
		lblNttNaveTransporte.setBounds(38, 413, 203, 19);
		contentPanel.add(lblNttNaveTransporte);
		
		JLabel label_10 = new JLabel("Edificios");
		label_10.setForeground(Color.RED);
		label_10.setBounds(344, 53, 129, 19);
		contentPanel.add(label_10);
		
		JLabel lblNmNexoMineral = new JLabel("NM:     Nexo mineral");
		lblNmNexoMineral.setBounds(294, 83, 179, 19);
		contentPanel.add(lblNmNexoMineral);
		
		JLabel lblPiPilon = new JLabel("Pi:      Pilon");
		lblPiPilon.setBounds(294, 113, 179, 19);
		contentPanel.add(lblPiPilon);
		
		JLabel lblAsAsimilador = new JLabel("As:     Asimilador");
		lblAsAsimilador.setBounds(294, 143, 203, 19);
		contentPanel.add(lblAsAsimilador);
		
		JLabel lblAcAcceso = new JLabel("Ac:     Acceso");
		lblAcAcceso.setBounds(294, 203, 203, 19);
		contentPanel.add(lblAcAcceso);
		
		JLabel lblPepPuertoEstelar = new JLabel("PEP:     Puerto estelar Protoss");
		lblPepPuertoEstelar.setBounds(294, 233, 203, 19);
		contentPanel.add(lblPepPuertoEstelar);
		
		JLabel lblArtAchivosTemplarios = new JLabel("ArT:     Achivos templarios");
		lblArtAchivosTemplarios.setBounds(294, 173, 203, 19);
		contentPanel.add(lblArtAchivosTemplarios);
		
		JLabel label_17 = new JLabel("Unidades\r\n");
		label_17.setForeground(Color.RED);
		label_17.setBounds(348, 263, 203, 19);
		contentPanel.add(label_17);
		
		JLabel lblZeZealot = new JLabel("Ze:     Zealot\r\n");
		lblZeZealot.setBounds(294, 293, 203, 19);
		contentPanel.add(lblZeZealot);
		
		JLabel lblDrDragon = new JLabel("Dr:     Dragon\r\n");
		lblDrDragon.setBounds(294, 323, 203, 19);
		contentPanel.add(lblDrDragon);
		
		JLabel lblScScout = new JLabel("Sc:     Scout\r\n");
		lblScScout.setBounds(294, 353, 203, 19);
		contentPanel.add(lblScScout);
		
		JLabel lblAltAltoTemplario = new JLabel("AlT:    Alto templario\r\n");
		lblAltAltoTemplario.setBounds(294, 383, 203, 19);
		contentPanel.add(lblAltAltoTemplario);
		
		JLabel lblNtpNaveTransporte = new JLabel("NTP:    Nave transporte Protoss\r\n");
		lblNtpNaveTransporte.setBounds(294, 413, 203, 19);
		contentPanel.add(lblNtpNaveTransporte);
		
		JLabel lblReferenciasParcelas = new JLabel("Referencias Parcelas");
		lblReferenciasParcelas.setForeground(Color.RED);
		lblReferenciasParcelas.setBounds(552, 13, 129, 19);
		contentPanel.add(lblReferenciasParcelas);
		
		JLabel lblGrisParcelaDe = new JLabel(" Parcela de tierra(Color Gris)");
		lblGrisParcelaDe.setForeground(Color.BLACK);
		lblGrisParcelaDe.setBounds(540, 83, 179, 19);
		contentPanel.add(lblGrisParcelaDe);
		
		JLabel lblParcelaDeEspacio = new JLabel("         Parcela de espacio(Color Negro)");
		lblParcelaDeEspacio.setBounds(516, 113, 179, 19);
		contentPanel.add(lblParcelaDeEspacio);
		
		JLabel lblParcelaDeMineral = new JLabel("        Parcela de mineral(Color Celeste)");
		lblParcelaDeMineral.setBounds(516, 143, 203, 19);
		contentPanel.add(lblParcelaDeMineral);
		
		JLabel lblParcelaDeVolcan = new JLabel("         Parcela de Volcan(Color Anaranjado)");
		lblParcelaDeVolcan.setBounds(516, 173, 203, 19);
		contentPanel.add(lblParcelaDeVolcan);
		
		JLabel lblNota = new JLabel("Nota: los elementos escritos en color gris son elementos ");
		lblNota.setBounds(442, 293, 361, 19);
		contentPanel.add(lblNota);
		
		JLabel lblDespuesTomanLa = new JLabel("De no estar en construcci\u00F3n toman el color de ");
		lblDespuesTomanLa.setBounds(471, 337, 295, 17);
		contentPanel.add(lblDespuesTomanLa);
		
		JLabel lblCuandoSonEn = new JLabel("que estan en etapa de construcci\u00F3n.");
		lblCuandoSonEn.setBounds(471, 312, 295, 19);
		contentPanel.add(lblCuandoSonEn);
		
		JLabel lblColorDeSu = new JLabel("su jugador.");
		lblColorDeSu.setBounds(471, 353, 261, 19);
		contentPanel.add(lblColorDeSu);
	}
}
