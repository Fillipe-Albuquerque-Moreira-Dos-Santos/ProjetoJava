package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.UsuarioController;



public class TelaLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pwdSenha;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	
public TelaLogin() {
		
		setBackground(new Color(240, 240, 240));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 378, 247);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUsuario.setBounds(81, 56, 68, 14);
		contentPane.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSenha.setBounds(81, 106, 68, 14);
		contentPane.add(lblSenha);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setForeground(new Color(0, 0, 0));
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setBounds(159, 51, 124, 28);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		pwdSenha = new JPasswordField();
		pwdSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdSenha.setForeground(new Color(0, 0, 0));
		pwdSenha.setBackground(new Color(255, 255, 255));
		pwdSenha.setBounds(159, 101, 124, 28);
		contentPane.add(pwdSenha);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtUsuario.getText().equals("") && new String(pwdSenha.getPassword()).equals("")) {
						JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente.");

					} else {
						UsuarioController usuarioController = new UsuarioController();
						usuarioController.validarAcesso(txtUsuario.getText(), new String(pwdSenha.getPassword()));
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro:" + ex);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(169, 150, 89, 23);
		contentPane.add(btnLogin);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/img/aviao.jpg")));
		lblNewLabel.setBounds(0, 0, 362, 208);
		contentPane.add(lblNewLabel);
	}
}
