package ifpe;

import java.util.List;

public class Autenticador {
	private static Usuario usuario;
	private static List<Usuario> usuarios;
	
	public static boolean autenticar(String login, String senha) {
		for(Usuario usuario : usuarios) {
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				Autenticador.usuario = usuario;
				return true;
			}
		}
		return false;
	}
	public static boolean eGerente() {
		if(Autenticador.usuario instanceof Gerente) {
			return true;
		}
		return false;
	}
	public static Usuario getUsuario() {
		return Autenticador.usuario;
	}
	public static List<Usuario> getUsuarios() {
		return usuarios;
	}
	public static void setUsuarios(List<Usuario> usuarios) {
		Autenticador.usuarios = usuarios;
	}
	
}
