package armazenamento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import dados.*;

public class RegistraLivro {
		
	private ArrayList<Livro> livros;
		// Construtor para inicializar a lista de livros
	public RegistraLivro() {
			livros = new ArrayList<Livro>();
		}
		
		// Sobrecarga do método addLivro para permitir adicionar 
	public void addLivro(Livro livro) {
	        livros.add(livro);
	    }

	public Livro getLivro (int indice) {
			return livros.get(indice);
		}
		
	public void removeLivro(Livro livro) {
			livros.remove(livro);
		}
		
	public void removeLivro (int indice) {
			livros.remove(indice);
		}
		
	public int size() {
			return livros.size();
		}
	// Método para realizar o empréstimo de um livro a um usuário
		public void emprestaLivro (Livro livro, Usuario usuario){
			 // Obtém a data e hora atuais
			LocalDateTime now = LocalDateTime.now();
			// Configura a data de empréstimo do livro e associa ao usuário
			livro.setDataEmprestimo(now);
			livro.setUsuarioComLivro(usuario);
		}
		
	public void ordenaTituloAZ(){
			Collections.sort(livros);
		}

	}
