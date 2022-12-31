package View;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;

public class Sobre extends JFrame {
	
	
	public Sobre() {

		setTitle("Sobre o sistema");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setBounds(20, 90, 445, 299);
		setLocationRelativeTo( null ); 
		
		JLabel lblNewLabel_1 = new JLabel("©2022 Senai - Fillipe Albuquerque -- Versão 1.0");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		
		
		JLabel lblNewLabel_2 = new JLabel("email: fillipefff@gmail.com");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(57, 178, 317, 36);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("©2022 Senai - Fillipe Albuquerque -- Versão 1.0");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 85, 409, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Sobre.class.getResource("/img/aviao.jpg")));
		lblNewLabel_3.setBounds(0, 0, 429, 260);
		getContentPane().add(lblNewLabel_3);

	}
}