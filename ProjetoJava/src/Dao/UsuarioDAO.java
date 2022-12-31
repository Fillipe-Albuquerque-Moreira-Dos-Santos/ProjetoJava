package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Usuario;
import View.TelaLogin;
import View.TelaPrincipal;



public class UsuarioDAO {

	public void cadastrarUsuario(Usuario usuario) throws Exception {

		String sql = "INSERT INTO usuario (usuario, senha) VALUES (?,?)";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = new Conexao().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());

			stmt.execute();
		} catch (SQLException e) {
			throw new Exception("Erro ao cadastrar usuario: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement: " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão: " + e);
			}
		}
	}

	public ArrayList<Usuario> listaUsuarios(String nome) throws Exception {
		String sql = "SELECT * FROM usuario WHERE usuario like '%" + nome + "%' order by usuario";

		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<Usuario> usuarios = null;

		try {
			con = new Conexao().getConnetion();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			if (rs != null) {
				usuarios = new ArrayList<Usuario>();
				while (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setIdUsuario(rs.getInt("idUsuario"));
					usuario.setUsuario(rs.getString("usuario"));
					usuario.setSenha(rs.getString("senha"));
					usuarios.add(usuario);
				}
			}
		} catch (Exception e) {
			throw new Exception("Erro ao consultar Usuarios: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement: " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão: " + e);
			}
		}
		return usuarios;
	}

	public void alterarUsuario(Usuario usuario) throws Exception {
		String sql = "UPDATE usuario set usuario = ?, senha = ? WHERE idUsuario=?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = new Conexao().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			stmt.setInt(3, usuario.getIdUsuario());
			stmt.execute();
		} catch (SQLException e) {
			throw new Exception("Erro ao alterar usuario: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement: " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão: " + e);
			}
		}
	}

	public void apagarUsuario(Usuario usuario) throws Exception {
		String sql = "DELETE FROM usuario WHERE idUsuario=?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = new Conexao().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getIdUsuario());
			stmt.execute();
		} catch (SQLException e) {
			throw new Exception("Erro ao cadastrar usuario: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement: " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão: " + e);
			}
		}
	}

	public void validarAcesso(Usuario usuario) throws Exception {
		String sql = "SELECT * FROM usuario WHERE usuario=? and senha=?";
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		TelaLogin exibirLogin = new TelaLogin();
		try {
			con = new Conexao().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());

			rs = stmt.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null,"Você foi logado com sucesso ");
				TelaPrincipal exibir = new TelaPrincipal();
				exibir.setVisible(true);
				if (rs.next() == true) {
					
					exibirLogin.setVisible(false);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreto!");

			}
		} catch (SQLException e) {
			System.out.println("Acesso Realizado " + e);
			throw new Exception("Erro ao realizar o login: " + e);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o rs: " + e);
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement: " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão: " + e);
			}
		}
	}
	
}
