package armazenamento;

import java.util.ArrayList;

import dados.Usuario;

public class RegistraUsuario {
	
	private ArrayList<Usuario> usuarios;

	public RegistraUsuario() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public void adicionaUsuario (Usuario usuario) {
		usuarios.add(usuario);
	}

	public Usuario getUsuario (int i) {
		return usuarios.get(i);
	}
	
	public void removeUsuario (Usuario usuario) {
		usuarios.remove(usuario);
	}
	
	public void removeIdUsuario (int i) {
		usuarios.remove(i);
	}
	
	public int size() {
		return usuarios.size();
	}

}