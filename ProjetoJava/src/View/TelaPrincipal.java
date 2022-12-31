package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

private JPanel contentPaneTelaPrincipal;
	
	public TelaPrincipal() {
		setResizable(false);
		initComponents();
	}
	
	
	public void initComponents() {

		setLocale(new Locale("pt", "BR"));
		setTitle("VoeAirLines");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 430);
		
		setLocationRelativeTo(null);
		contentPaneTelaPrincipal = new JPanel();
		contentPaneTelaPrincipal.setBackground(new Color(192, 192, 192));
		contentPaneTelaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneTelaPrincipal);
		contentPaneTelaPrincipal.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 549, 22);
		contentPaneTelaPrincipal.add(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem jmiCadastrarUserUser = new JMenuItem("Cadastro");
		jmiCadastrarUserUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuario exibir = new TelaCadastroUsuario();
				exibir.setVisible(true);
			}
		});
		jmiCadastrarUserUser.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/seta.png")));
		mnUsuarios.add(jmiCadastrarUserUser);
		
		JMenuItem jmiConsultarUser = new JMenuItem("Consultar");
		jmiConsultarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaUsuario exibir = new TelaConsultaUsuario();
				exibir.setVisible(true);
			}
		});
		jmiConsultarUser.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/seta.png")));
		mnUsuarios.add(jmiConsultarUser);
		
		JMenu mnAeronaves = new JMenu("Aeronaves");
		menuBar.add(mnAeronaves);
		
		JMenuItem jmiCadastrarAero = new JMenuItem("Cadastro");
		jmiCadastrarAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAeronave exibir = new TelaCadastroAeronave();
				exibir.setVisible(true);
			}
		});
		jmiCadastrarAero.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/seta.png")));
		mnAeronaves.add(jmiCadastrarAero);
		
		JMenuItem jmiConsultarAero = new JMenuItem("Consultar");
		jmiConsultarAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaAeronave exibirAeronave = new TelaConsultaAeronave();
				exibirAeronave.setVisible(true);
			}
		});
		jmiConsultarAero.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/seta.png")));
		mnAeronaves.add(jmiConsultarAero);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(mnAjuda);
		
		JMenuItem mnSobre = new JMenuItem("Sobre");
		mnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);	
			}
		});
		mnAjuda.add(mnSobre);
		
		JLabel lblNewLabel = new JLabel("VoeAirLines Voando alto com você!!!");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(102, 33, 356, 62);
		contentPaneTelaPrincipal.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Curso Desenvolvimento Java - SENAI");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(112, 106, 332, 14);
		contentPaneTelaPrincipal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Dev. Fillipe Albuquerque");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_3.setBounds(149, 339, 327, 22);
		contentPaneTelaPrincipal.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/aviao.jpg")));
		lblNewLabel_4.setBounds(0, 21, 549, 370);
		contentPaneTelaPrincipal.add(lblNewLabel_4);
	}
}
