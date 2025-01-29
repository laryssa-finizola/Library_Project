package dados;
//representa um usuario
public class Usuario {
//atributos
	private String nome, telefone;
	private static int codigo = 1;
	private int codigoUsuario;
//construtor	
	public Usuario(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.codigoUsuario = codigo;
		codigo++;
	}
//metodos get e set para cada atributo
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}


}