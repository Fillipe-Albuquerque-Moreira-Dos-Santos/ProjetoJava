package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Controller.AeronaveController;
import Controller.TipoAeronaveController;
import Controller.UsuarioController;
import Dao.AeronaveDAO;
import Model.Aeronave;
import Model.TipoAeronave;
import javax.swing.ImageIcon;

public class TelaCadastroAeronave extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPaneCadastroAeronave;
	private JTextField txtFabricante;
	private JTextField txtModelo;
	private JTextField txtCodigo;
	private Integer idAeronave = 0;
	private JTextField txtTipo;

	public TelaCadastroAeronave() {
		setVisible(true);
		initComponents();
	}

	public void buscarAeronave(Integer idAeronave, String fabricante, String modelo, String codigo, String tipo) {
		this.idAeronave = idAeronave;
		this.txtFabricante.setText(fabricante);
		this.txtModelo.setText(modelo);
		this.txtCodigo.setText(codigo);
		this.txtTipo.setText(tipo);
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setTitle("VoeAirlines Cadastro");
		setBounds(100, 100, 565, 271);
		setLocationRelativeTo(null);
		contentPaneCadastroAeronave = new JPanel();
		contentPaneCadastroAeronave.setBackground(new Color(192, 192, 192));
		contentPaneCadastroAeronave.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneCadastroAeronave);
		contentPaneCadastroAeronave.setLayout(null);

		JLabel lblCadastroAeronave = new JLabel("Cadastro Aeronave");
		lblCadastroAeronave.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroAeronave.setBounds(172, 11, 155, 14);
		contentPaneCadastroAeronave.add(lblCadastroAeronave);

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFabricante.setBounds(10, 43, 85, 24);
		contentPaneCadastroAeronave.add(lblFabricante);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblModelo.setBounds(10, 78, 85, 24);
		contentPaneCadastroAeronave.add(lblModelo);

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 113, 85, 24);
		contentPaneCadastroAeronave.add(lblNewLabel);

		txtFabricante = new JTextField();
		txtFabricante.setToolTipText("Fabricante");
		txtFabricante.setBounds(105, 47, 251, 20);
		contentPaneCadastroAeronave.add(txtFabricante);
		txtFabricante.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setToolTipText("Modelo");
		txtModelo.setColumns(10);
		txtModelo.setBounds(105, 82, 251, 20);
		contentPaneCadastroAeronave.add(txtModelo);

		txtCodigo = new JTextField();
		txtCodigo.setToolTipText("Código");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(105, 117, 251, 20);
		contentPaneCadastroAeronave.add(txtCodigo);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AeronaveDAO dao = new AeronaveDAO();
				AeronaveController Aeronave = new AeronaveController();
				Aeronave modelo = new Aeronave();
				try {
					if (txtFabricante.getText().trim().isEmpty() || txtModelo.getText().trim().isEmpty()
							|| txtCodigo.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "É obrigatório preencher os campos");
					} else {
						System.out.println("Botao clicado");
						modelo.setFabricante(txtFabricante.getText());
						modelo.setModelo(txtModelo.getText());
						modelo.setCodigoAeronave(txtCodigo.getText());
						modelo.setTipoaeronave(txtTipo.getText());
						dao.cadastrarAeronave(modelo);
						JOptionPane.showMessageDialog(null, "O avião foi cadastrado com sucesso no sistema VoeArlines");
						txtFabricante.setText("");
						txtModelo.setText("");
						txtCodigo.setText("");
						txtTipo.setText("");

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro:" + ex);
				}
			}
		});

		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrar.setBounds(400, 45, 120, 23);
		contentPaneCadastroAeronave.add(btnCadastrar);

	

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaAeronave telaConsultaAeronave = new TelaConsultaAeronave();
				telaConsultaAeronave.setVisible(true);
				setVisible(false);
			}
		});
		btnConsultar.setBounds(400, 80, 120, 23);
		contentPaneCadastroAeronave.add(btnConsultar);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBorder(new LineBorder(new Color(204, 0, 0)));
		btnApagar.setForeground(new Color(255, 0, 0));
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso;
				String message = "Deseja realmente apagar a aeronave?";
				String title = "Confirmação";
				// Exibe caixa de dialogo (veja figura) solicitando confirmação ou não.
				// Se o usuário clicar em "Sim" retorna 0 pra variavel reply, se informado não
				// retorna 1
				int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					try {
						AeronaveController aeronaveController = new AeronaveController();
						sucesso = aeronaveController.apagarAeronave(idAeronave);

						if (sucesso == true) {
							JOptionPane.showMessageDialog(null, "O usuario foi apagado com sucesso");
							txtFabricante.setText("");
							txtModelo.setText("");
							txtCodigo.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Os campos não estão preenchidos corretamente.");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnApagar.setBounds(400, 115, 120, 23);
		contentPaneCadastroAeronave.add(btnApagar);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTipo.setBounds(10, 148, 85, 24);
		contentPaneCadastroAeronave.add(lblTipo);

		txtTipo = new JTextField();
		txtTipo.setToolTipText("Código");
		txtTipo.setColumns(10);
		txtTipo.setBounds(105, 151, 251, 20);
		contentPaneCadastroAeronave.add(txtTipo);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(TelaCadastroAeronave.class.getResource("/img/nuvem-branca.png")));
		lblNewLabel_1.setBounds(0, 0, 549, 232);
		contentPaneCadastroAeronave.add(lblNewLabel_1);
	}
}
