package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.UsuarioController;
import javax.swing.ImageIcon;



public class TelaCadastroUsuario extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private Integer idUsuario = 0;

	public TelaCadastroUsuario() {
		setVisible(true);
		initComponents();
	}

	public void buscarUsuario(Integer idUsuario, String usuario, String senha) {
		this.idUsuario = idUsuario;
		this.txtUsuario.setText(usuario);
		this.txtSenha.setText(senha);
	}
	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setBackground(new Color(192, 192, 192));
		setResizable(false);
		setBounds(100, 100, 565, 271);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarUsuario = new JLabel("Cadastro Usuário");
		lblCadastrarUsuario.setForeground(new Color(255, 255, 255));
		lblCadastrarUsuario.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCadastrarUsuario.setBounds(207, 11, 163, 14);
		contentPane.add(lblCadastrarUsuario);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsuario.setBounds(91, 52, 68, 14);
		contentPane.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setBackground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSenha.setBounds(91, 95, 59, 14);
		contentPane.add(lblSenha);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(178, 51, 232, 20);
		contentPane.add(txtUsuario);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(178, 94, 232, 20);
		contentPane.add(txtSenha);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtUsuario.getText().equals("") && txtSenha.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente.");

					} else {
						UsuarioController usuarioController = new UsuarioController();
						usuarioController.cadastrarUsuario(txtUsuario.getText(), txtSenha.getText());
						JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
						txtUsuario.setText("");
						txtSenha.setText("");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro:" + ex);
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrar.setBounds(91, 159, 142, 23);
		contentPane.add(btnCadastrar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaUsuario telaConsultaUsuario = new TelaConsultaUsuario();
				telaConsultaUsuario.setVisible(true);
				setVisible(false);
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.setBounds(290, 159, 142, 23);
		contentPane.add(btnConsultar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso;
				try {
					UsuarioController usuarioController = new UsuarioController();
					sucesso = usuarioController.alterarUsuario(idUsuario, txtUsuario.getText(), txtSenha.getText());

					if (sucesso == true) {
						JOptionPane.showMessageDialog(null, "O cadastro foi alterado com sucesso");
						txtUsuario.setText("");
						txtSenha.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Os campos não estão preenchidos corretamente.");
					}
				} catch (Exception e2) {
				}
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAlterar.setBounds(91, 193, 142, 23);
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Apagar Usuário");
		btnExcluir.setBorder(new LineBorder(new Color(204, 0, 0)));
		btnExcluir.setForeground(new Color(255, 145, 138));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso;
				String message = "Deseja realmente apagar o usuario?";
				String title = "Confirmação";
				// Exibe caixa de dialogo (veja figura) solicitando confirmação ou não.
				// Se o usuário clicar em "Sim" retorna 0 pra variavel reply, se informado não
				// retorna 1
				int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					try {
						UsuarioController usuarioController = new UsuarioController();
						sucesso = usuarioController.apagarUsuario(idUsuario);

						if (sucesso == true) {
							JOptionPane.showMessageDialog(null, "O usuario foi apagado com sucesso");
							txtUsuario.setText("");
							txtSenha.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Os campos não estão preenchidos corretamente.");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExcluir.setBounds(290, 193, 142, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/img/aviao.jpg")));
		lblNewLabel.setBounds(0, 0, 549, 232);
		contentPane.add(lblNewLabel);
	}

}
