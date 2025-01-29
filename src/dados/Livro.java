package dados;

import java.time.LocalDateTime;

import interfaces.Emprestavel;


public class Livro implements Comparable<Livro>, Emprestavel{
	//atributos
	private String titulo, autor;
	private LocalDateTime dataEmprestimo;
	private double valor;
	private static int codLv=1;
	private int codigoDoLivro;
    Usuario usuarioComLivro;
	//construtor
	public Livro(String titulo, String autor, double valor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
		dataEmprestimo = null;
        usuarioComLivro = null;
		this.codigoDoLivro = codLv;
		codLv++;
	}
//get e set para cada atributo
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigoDoLivro;
	}

	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getUsuarioComLivro() {
	    return (usuarioComLivro != null) ? usuarioComLivro.getNome() : "N/A";
	}


	public void setUsuarioComLivro(Usuario usuarioComLivro) {
		this.usuarioComLivro = usuarioComLivro;
	}
	
	//Método compareTo da interface Comparable
    @Override
    public int compareTo(Livro l) {
        // Compara e ignora maiusculas/minusculas
        return this.titulo.compareToIgnoreCase(l.getTitulo());
    }
	//implementa o metodo emprestaItem da interface
    @Override
    public void emprestaItem(Usuario usuario) {
        if (getDataEmprestimo() == null) {
            setDataEmprestimo(LocalDateTime.now());
            setUsuarioComLivro(usuario);
            System.out.println("Livro emprestado com sucesso para: " + usuario.getNome());
        } else {
            System.out.println("Livro já emprestado.");
        }
    }
  //implementa o metodo devolveItem da interface
    @Override
    public void devolveItem() {
        if (getDataEmprestimo() != null) {
            setDataEmprestimo(null);
            setUsuarioComLivro(null);
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Livro não emprestado.");
        }
    }

}