package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AeronaveController;
import Model.Aeronave;
import javax.swing.ImageIcon;


public class TelaConsultaAeronave extends JFrame {
	
	
	private JPanel contentPaneConsultaAeronave;
	private JTextField txtAeronave;
	private JTable tableConsulta;
	private TelaCadastroAeronave telaCadastroAeronave;

	public TelaConsultaAeronave() {
		setResizable(false);
		getContentPane().setLayout(null);
		initComponents();
	}

	public void initComponents() {

		setTitle("Tela de Consulta");
		setBounds(100, 100, 565, 430);
		setLocationRelativeTo(null);
		contentPaneConsultaAeronave = new JPanel();
		contentPaneConsultaAeronave.setBackground(new Color(192, 192, 192));
		contentPaneConsultaAeronave.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneConsultaAeronave);
		contentPaneConsultaAeronave.setLayout(null);

		JLabel lblConsultarAeronave = new JLabel("Consultar Aeronave");
		lblConsultarAeronave.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConsultarAeronave.setBounds(163, 11, 214, 26);
		contentPaneConsultaAeronave.add(lblConsultarAeronave);

		JLabel lblInfoNome = new JLabel("Informe a Aeronave:");
		lblInfoNome.setToolTipText("");
		lblInfoNome.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblInfoNome.setBounds(10, 76, 115, 14);
		contentPaneConsultaAeronave.add(lblInfoNome);

		txtAeronave = new JTextField();
		txtAeronave.setToolTipText("Aeronave");
		txtAeronave.setBounds(134, 74, 269, 20);
		contentPaneConsultaAeronave.add(txtAeronave);
		txtAeronave.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtAeronave.getText();
				DefaultTableModel tableModel = (DefaultTableModel) tableConsulta.getModel();
				tableModel.setRowCount(0);
				AeronaveController aeronaveController = new AeronaveController();
				try {

					ArrayList<Aeronave> aeronaves = aeronaveController.listaAeronaves(nome);
					aeronaves.forEach((Aeronave aeronave) -> {
						tableModel.addRow(new Object[] { aeronave.getIdAeronave(), aeronave.getFabricante(),
								aeronave.getModelo(), aeronave.getCodigoAeronave(), aeronave.getTipoaeronave()});
					});
					tableConsulta.setModel(tableModel);

				} catch (Exception e2) {
					Logger.getLogger(TelaCadastroAeronave.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		});
		btnConsultar.setBounds(424, 73, 115, 23);
		contentPaneConsultaAeronave.add(btnConsultar);

		JScrollPane scrollPaneConsulta = new JScrollPane();
		scrollPaneConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPaneConsulta.setBounds(10, 113, 539, 197);
		contentPaneConsultaAeronave.add(scrollPaneConsulta);

		tableConsulta = new JTable();
		tableConsulta.setRowSelectionAllowed(false);
		tableConsulta.setShowGrid(false);
		tableConsulta.setShowHorizontalLines(false);
		tableConsulta.setShowVerticalLines(false);
		tableConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Integer idAeronave = (Integer) tableConsulta.getModel().getValueAt(tableConsulta.getSelectedRow(),0);
					String fabricante = (String) tableConsulta.getModel().getValueAt(tableConsulta.getSelectedRow(), 1);
					String modelo = (String) tableConsulta.getModel().getValueAt(tableConsulta.getSelectedRow(), 2);
					String codigo = (String) tableConsulta.getModel().getValueAt(tableConsulta.getSelectedRow(), 3);
					String tipo = (String) tableConsulta.getModel().getValueAt(tableConsulta.getSelectedRow(), 4);
					TelaCadastroAeronave t = new TelaCadastroAeronave();
					t.buscarAeronave(idAeronave, fabricante, modelo, codigo, tipo);
					setVisible(false);
				}
			}
		});

		tableConsulta.setModel(new DefaultTableModel(new Object[][] {{null, null, null, null, null},},
			new String[] 
					{"Id", "Fabricante", "Modelo", "Codigo", "Tipo da Aeronave"}

			
	));
		
		

		
		scrollPaneConsulta.setViewportView(tableConsulta);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAeronave telaConsultaAeronave = new TelaCadastroAeronave();
				telaConsultaAeronave.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(228, 335, 89, 23);
		contentPaneConsultaAeronave.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaConsultaAeronave.class.getResource("/img/nuvem-branca.png")));
		lblNewLabel.setBounds(0, 0, 549, 391);
		contentPaneConsultaAeronave.add(lblNewLabel);
	}

}
