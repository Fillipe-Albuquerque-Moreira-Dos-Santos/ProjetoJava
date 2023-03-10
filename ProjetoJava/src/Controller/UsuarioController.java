package Controller;

import java.util.ArrayList;

import Model.Usuario;


public class UsuarioController {

	public boolean cadastrarUsuario(String usuario, String senha) throws Exception {
		if (usuario != null && usuario.length() > 0 && senha != null && senha.length() > 0) {
			Usuario user = new Usuario(usuario, senha);
			user.cadastrarUsuario(user);
			return true;
		}
		return false;
	}

	public ArrayList<Usuario> listaUsuarios(String nome) throws Exception {
		return new Usuario().listaUsuarios(nome);
	}

	public boolean alterarUsuario(Integer idUsuario, String usuario, String senha) throws Exception {
		if (usuario != null && usuario.length() > 0 && senha != null && senha.length() > 0) {
			Usuario user = new Usuario(idUsuario, usuario, senha);
			user.setIdUsuario(idUsuario);
			user.alterarUsuario(user);
			return true;
		}
		return false;
	}

	public boolean apagarUsuario(Integer idUsuario) throws Exception {
		if (idUsuario == 0) {
			return false;
		} else {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(idUsuario);
			usuario.apagarUsuario(usuario);
			return true;
		}
	}

	public boolean validarAcesso(String usuario, String senha) throws Exception {
		if (usuario != null && usuario.length() > 0 && senha != null && senha.length() > 0) {
			Usuario user = new Usuario(usuario, senha);
			user.validarAcesso(user);
			return true;
		}
		return false;
	}
}
