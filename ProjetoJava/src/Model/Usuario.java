package Model;

import java.util.ArrayList;

import Dao.UsuarioDAO;


public class Usuario {
	private Integer idUsuario;
	private String usuario;
	private String senha;

	public Usuario() {

	}

	public Usuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public Usuario(Integer idUsuario, String usuario, String senha) {
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void cadastrarUsuario(Usuario usuario) throws Exception {
		new UsuarioDAO().cadastrarUsuario(usuario);
	}

	public ArrayList<Usuario> listaUsuarios(String nome) throws Exception {
		return new UsuarioDAO().listaUsuarios(nome);
	}

	public void alterarUsuario(Usuario usuario) throws Exception {
		new UsuarioDAO().alterarUsuario(usuario);
	}

	public void apagarUsuario(Usuario usuario) throws Exception {
		new UsuarioDAO().apagarUsuario(usuario);
	}

	public void validarAcesso(Usuario usuario) throws Exception {
		new UsuarioDAO().validarAcesso(usuario);
	}
}

