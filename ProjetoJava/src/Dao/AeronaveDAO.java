package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Aeronave;

public class AeronaveDAO {

		public void cadastrarAeronave(Aeronave aeronave) throws Exception {

			String sql = "INSERT INTO aeronave(idTipoAeronave, fabricante, modelo, codigoaeronave,tipoaeronave) VALUES (?,?,?,?,?)";
			PreparedStatement stmt = null;
			Connection con = null;
			try {
				con = new  Conexao().getConnetion();
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, aeronave.getIdAeronave());
				stmt.setString(2, aeronave.getFabricante());
				stmt.setString(3, aeronave.getModelo());
				stmt.setString(4, aeronave.getCodigoAeronave());
				stmt.setString(5, aeronave.getTipoaeronave());
				stmt.execute();
				System.out.println("Funcionou");
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

		public ArrayList<Aeronave> listaAeronaves(String nome) throws Exception {
			String sql = "SELECT * FROM aeronave WHERE modelo like '%" + nome + "%' order by modelo";

			Connection con = null;
			PreparedStatement stmt = null;
			ArrayList<Aeronave> aeronaves = null;

			try {
				con = new  Conexao().getConnetion();
				stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();

				if (rs != null) {
					aeronaves = new ArrayList<Aeronave>();
					while (rs.next()) {
						Aeronave aeronave = new Aeronave();
						aeronave.setIdAeronave(rs.getInt("idTipoAeronave"));
						aeronave.setFabricante(rs.getString("fabricante"));
						aeronave.setModelo(rs.getString("modelo"));
						aeronave.setCodigoAeronave(rs.getString("codigoAeronave"));
						aeronave.setTipoaeronave(rs.getString("tipoaeronave"));
						aeronaves.add(aeronave);
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
			return aeronaves;
		}

		public void alterarAeronave(Aeronave aeronave) throws Exception {
			String sql = "UPDATE aeronave set fabricante = ?, modelo = ?, codigoAeronave = ?,  codigoAeronave = ?,  tipoaeronave = ? WHERE idTipoAeronave=?";
			PreparedStatement stmt = null;
			Connection con = null;
			try {
				con = new Conexao().getConnetion();
				stmt = con.prepareStatement(sql);
				stmt.setString(1, aeronave.getFabricante());
				stmt.setString(2, aeronave.getModelo());
				stmt.setString(3, aeronave.getCodigoAeronave());
				stmt.setString(4, aeronave.getTipoaeronave());
				stmt.setInt(5, aeronave.getIdAeronave());
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

		public void apagarAeronave(Aeronave aeronave) throws Exception {
			String sql = "DELETE FROM aeronave WHERE idTipoAeronave=?";
			PreparedStatement stmt = null;
			Connection con = null;
			try {
				con = new  Conexao().getConnetion();
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, aeronave.getIdAeronave());
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
	}
	

