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

import Controller.UsuarioController;
import Model.Usuario;

import javax.swing.ImageIcon;




public class TelaConsultaUsuario extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPaneConsultaUsuario;
	private JTextField txtUsuario;
	private JTable tableConsulta;

	private TelaCadastroUsuario telaCadastroUsuario;
	private JScrollPane scrollPaneConsulta;

	public TelaConsultaUsuario() {
		setResizable(false);
		initComponents();
	}

	public void initComponents() {

		setTitle("Tela de Consulta");
		setBounds(100, 100, 565, 430);
		setLocationRelativeTo(null);
		contentPaneConsultaUsuario = new JPanel();
		contentPaneConsultaUsuario.setBackground(new Color(192, 192, 192));
		contentPaneConsultaUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneConsultaUsuario);
		contentPaneConsultaUsuario.setLayout(null);

		JLabel lblConsultarUsuario = new JLabel("Consultar Usuario");
		lblConsultarUsuario.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConsultarUsuario.setBounds(189, 11, 168, 26);
		contentPaneConsultaUsuario.add(lblConsultarUsuario);

		JLabel lblInfoNome = new JLabel("Informe o Usuario:");
		lblInfoNome.setToolTipText("");
		lblInfoNome.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblInfoNome.setBounds(10, 76, 115, 14);
		contentPaneConsultaUsuario.add(lblInfoNome);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Usuario");
		txtUsuario.setBounds(134, 74, 269, 20);
		contentPaneConsultaUsuario.add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtUsuario.getText();
				DefaultTableModel tableModel = (DefaultTableModel) tableConsulta.getModel();
				tableModel.setRowCount(0);
				UsuarioController usuarioController = new UsuarioController();
				try {
					ArrayList<Usuario> usuarios = usuarioController.listaUsuarios(nome);
					usuarios.forEach((Usuario usuario) -> {
						tableModel.addRow(
								new Object[] { usuario.getIdUsuario(), usuario.getUsuario(), usuario.getSenha() });
					});
					tableConsulta.setModel(tableModel);

				} catch (Exception e2) {
					Logger.getLogger(TelaCadastroUsuario.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		});
		btnConsultar.setBounds(424, 73, 115, 23);
		contentPaneConsultaUsuario.add(btnConsultar);

		scrollPaneConsulta = new JScrollPane();
		scrollPaneConsulta.setBounds(10, 113, 529, 197);
		contentPaneConsultaUsuario.add(scrollPaneConsulta);

		tableConsulta = new JTable();
		tableConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Integer idUsuario = (Integer) tableConsulta.getModel().getValueAt(tableConsulta.getSelectedRow(),0);
					String usuario = (String) tableConsulta.getModel().getValueAt(tableConsulta.getSelectedRow(), 1);
					String senha = (String) tableConsulta.getModel().getValueAt(tableConsulta.getSelectedRow(), 2);

					TelaCadastroUsuario tcu = new TelaCadastroUsuario();
					tcu.buscarUsuario(idUsuario, usuario, senha);
					setVisible(false);
				}
			}
		});

		tableConsulta.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Id", "Usuario", "Senha" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		scrollPaneConsulta.setViewportView(tableConsulta);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuario telaConsultaUsuario = new TelaCadastroUsuario();
				telaConsultaUsuario.setVisible(true);

				setVisible(false);
			}
		});
		btnVoltar.setBounds(228, 335, 89, 23);
		contentPaneConsultaUsuario.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaConsultaUsuario.class.getResource("/img/nuvem-branca.png")));
		lblNewLabel.setBounds(0, 0, 549, 391);
		contentPaneConsultaUsuario.add(lblNewLabel);
	}
}
