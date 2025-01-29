package aplicacao;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import armazenamento.*;
import dados.*;

import javax.swing.*;

public class Biblioteca extends  BibliotecaGUI{

	// Atributos estáticos para uso em métodos estáticos
	private static Scanner tc = new Scanner(System.in);
	private static RegistraLivro livros;
	private static RegistraUsuario usuario;
	private static RegistraArtigo artigos;


		 // Método para listar livros disponíveis
		 public static void listarTodosLivros() {
			System.out.println("=== Lista de livros ===");
			System.out.println("Numero de Registro\t Titulo\t Autor\t Valor" );
			for (int i = 0; i < livros.size(); i++) {
				Livro novoLivro = livros.getLivro(i);
				if(novoLivro.getDataEmprestimo()==null){ //esse bloco é um tratamento de exceção e trata o erro nullpointer se caso a data de emprestimo for nula 
					// Lista os livros 
				System.out.printf ("%s\t %s\t  %s\t %s\t\n",
						novoLivro.getCodigo(), novoLivro.getTitulo(), novoLivro.getAutor(), novoLivro.getValor());
				}
			}
		}

		// Método para listar artigos disponíveis
		public static void listarTodosArtigos() {
		    System.out.println("=== Lista de artigos ===");
		    System.out.println("Num Registro\t Titulo\t Autor\t Valor\t Assunto");
		    for (int i = 0; i < artigos.size(); i++) {
		        Artigo a = artigos.getArtigo(i);
		        if (a.getDataEmprestimo() == null) { //esse bloco é um tratamento de exceção e trata o erro nullpointer se caso a data de emprestimo for nula
		        	// Lista apenas os artigos disponíveis 
		            System.out.printf("%s\t %s\t  %s\t %s\t %s\t\n",
		                    a.getCodigo(), a.getTitulo(), a.getAutor(), a.getValor(), a.getAssunto());
		        }
		    }
		}

		// Método para listar todos os usuários
		public static void listarTodosUsuarios() {
			System.out.println("=== Lista de Usuaerios ===");
			System.out.println("Codigo\t Nome\t\t\t Telefone" );
			for (int i = 0; i < usuario.size(); i++) {
				Usuario login =usuario.getUsuario(i);
				System.out.printf ("%s\t %s\t\t  %s\n",
						login.getCodigoUsuario(),login.getNome(), login.getTelefone());
				}
		}

		// Método para listar todos os livros
		public static void listarLivrosLivres() {
			System.out.println("=== Lista de livros disponiveis ===");
			System.out.println("Cod\t Titulo\t\t\t Autor\t\t Valor\t\t Situacao\t\t Usuario" );
			for (int i = 0; i < livros.size(); i++) {
				Livro novoLivro = livros.getLivro(i);
				if(novoLivro.getDataEmprestimo()==null){ //esse bloco é um tratamento de exceção e trata o erro nullpointer se caso a data de emprestimo for nula
					// Lista os livros disponiveis (sem data de empréstimo)
				System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t Livro Disponivel\n",
						novoLivro.getCodigo(), novoLivro.getTitulo(), novoLivro.getAutor(), novoLivro.getValor());
				}
				else{
				System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t %s\n",
						novoLivro.getCodigo(), novoLivro.getTitulo(), novoLivro.getAutor(), novoLivro.getValor(),novoLivro.getUsuarioComLivro());
				}
			}
		}

		// Método para listar todos os artigos
		public static void listarArtigosLivres() {
			System.out.println("=== Lista de artigos disponiveis ===");
			System.out.println("Codigo\t Titulo\t\t\t Autor\t\t Valor\t\t Situacao\t\t Usuario" );
			for (int i = 0; i < artigos.size(); i++) {
				Artigo a = artigos.getArtigo(i);
				if(a.getDataEmprestimo()==null){ //esse bloco é um tratamento de exceção e trata o erro nullpointer se caso a data de emprestimo for nula
					// Lista os artigos disponiveis (sem data de empréstimo)
				System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t Livro Disponivel\n",
						a.getCodigo(), a.getTitulo(), a.getAutor(), a.getValor());
				}
				else{
				System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t %s\n",
						a.getCodigo(), a.getTitulo(), a.getAutor(), a.getValor(), a.getUsuarioComLivro());
				}
			}
		}

	// Método para adicionar novo livro
	@Override
	protected void btnAdicionaLivroClick(ActionEvent ev) {
		String titulo, autor;
		double valor;
		Livro novoLivro;

		System.out.println("==> Adicionar Livro\n");

		titulo = JOptionPane.showInputDialog("Titulo: ");
		autor = JOptionPane.showInputDialog("Autor: ");
		valor = Double.parseDouble(JOptionPane.showInputDialog("Valor: "));

		// Criando um novo livro e adicionando à lista de livros
		novoLivro= new Livro(titulo, autor, valor);
		livros.addLivro(novoLivro);

		//tratamento de cadastro válido e inválido para o usuário
		if (!titulo.isEmpty() && !autor.isEmpty() && !(valor==0)){
			JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
		}else{
			JOptionPane.showMessageDialog(this, "Erro. Tente novamente!");
		}

	}

	// Método para adicionar novo artigo
	@Override
	protected void btnAdicionaArtigoClick(ActionEvent ev) {
		String titulo, autor, revista;
		double valor;
		Artigo novoArtigo;

		System.out.println("==> Adicionar Artigo\n");

		titulo = JOptionPane.showInputDialog("Titulo: ");
		autor = JOptionPane.showInputDialog("Autor: ");
		valor = Double.parseDouble(JOptionPane.showInputDialog("Valor: "));
		revista = JOptionPane.showInputDialog("Revista: ");

		// Criando um novo artigo e adicionando a lista
		novoArtigo = new Artigo(titulo, autor, valor, revista);
		artigos.addArtigo(novoArtigo);

		//tratamento de cadastro válido e inválido para o usuário
		if (!titulo.isEmpty() && !autor.isEmpty() && !(valor==0)){
			JOptionPane.showMessageDialog(this, "Artigo cadastrado com sucesso!");
		}else{
			JOptionPane.showMessageDialog(this, "Erro. Tente novamente!");
		}
	}

	// Método para adicionar novo usuário
	@Override
	protected void btnAdicionaUsuarioClick(ActionEvent ev) {
		String nome, telefone;
		Usuario login;

		System.out.println("==> Adicionar Usuario\n");

		nome = JOptionPane.showInputDialog("Nome: ");
		telefone = JOptionPane.showInputDialog("Telefone: ");


		// Criando um novo usuário e adicionando à lista de usuários
		login = new Usuario(nome, telefone);
		usuario.adicionaUsuario(login);

		//tratamento de cadastro válido e inválido para o usuário
		if (!nome.isEmpty() && !telefone.isEmpty()){
			JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
		}else{
			JOptionPane.showMessageDialog(this, "Erro. Tente novamente!");
		}
	}

	// Método para emprestar um livro
	@Override
	protected void btnEmprestarLivroClick(ActionEvent ev) {
		boolean emprestimoDisp=false;
		boolean usuarioComLivro=false;
		int codigo;
		int codigo_usuario;

		System.out.print("Emprestar Livro");

		codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do livro a ser emprestado: "));

		codigo_usuario = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do usuario: "));
		// Verifica se o usuário existe
		for (int i = 0; i < usuario.size(); i++) {
			Usuario login = usuario.getUsuario(i);
			if(login.getCodigoUsuario() == codigo_usuario){
				usuarioComLivro=true;
				for (int i1 = 0; i1 < livros.size(); i1++) {
					Livro novoLivro = livros.getLivro(i1);
					if(novoLivro.getCodigo()==codigo&& novoLivro.getDataEmprestimo()==null){
						livros.emprestaLivro(novoLivro,login);
						JOptionPane.showConfirmDialog(this,"Emprestar livro: " + novoLivro.getTitulo() + " para o usuario: "+ login.getNome());
						JOptionPane.showMessageDialog(this, "Data de emprestimo: "+novoLivro.getDataEmprestimo());
						emprestimoDisp=true;
					}
				}
				if(emprestimoDisp==false){ //esse bloco é um tratamento de exceção e trata o de caso o livro não estar disponivel
					JOptionPane.showMessageDialog(this, "Livro não encontrado ou já emprestado.");
				}
			}
		}
		if(usuarioComLivro==false){  //esse bloco é um tratamento de exceção e trata o de caso o usuario não estar na lista
			//System.out.println("Usuario não encontrado.");
			JOptionPane.showMessageDialog(this, "Usuario não encontrado.");
		}
	}

	// Método para devolver um livro
	@Override
	protected void btnDevolverLivroClick(ActionEvent ev) {
		boolean emprestimoDisp=false;
		int codigo;

		codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do livro a ser devolvido: "));

		// Verifica se o livro existe e realiza a devolução
		for (int i = 0; i < livros.size(); i++) {
			Livro novoLivro = livros.getLivro(i);
			if(novoLivro.getCodigo()==codigo){
				novoLivro .setDataEmprestimo(null);
				emprestimoDisp=true;
				JOptionPane.showMessageDialog(this, "Livro: '"+novoLivro.getTitulo()+"' devolvido com sucesso.");
			}
		}
		if(emprestimoDisp==false){
			JOptionPane.showMessageDialog(this, "Livro não encontrado.");
		}
	}

	// Método para listagem de títulos por ordem alfabética
	@Override
	protected void btnListarLivroAZClick(ActionEvent ev) {
		List<String> listaString = new ArrayList<>();
		for (int i=0; i < livros.size(); i++){
			listaString.add(livros.getLivro(i).getTitulo() + "\n");
		}
		Collections.sort(listaString);
		JOptionPane.showMessageDialog(this, listaString);

	}

	// Método para listagem de títulos por ordem alfabética
	@Override
	protected void btnListarArtigoAZClick(ActionEvent ev) {
		List<String> listaString = new ArrayList<>();

			for (int i=0; i < artigos.size(); i++){
				listaString.add(artigos.getArtigo(i).getTitulo() + "\n");
			}
		Collections.sort(listaString);
			JOptionPane.showMessageDialog(this, listaString);
	}

	// Método para encerrar programa
	@Override
	protected void btnSairClick(ActionEvent ev) {
		this.setVisible(false);
		this.dispose();
	}

		public static void main(String[] args) {
			// Inicializando instâncias das classes de registro
			livros = new RegistraLivro();
			usuario = new RegistraUsuario();
			artigos = new RegistraArtigo();
			
			
			// Criando alguns livros, artigos e usuários para exemplo
			
			Livro livro1 = new Livro ("Harry Potter e a Pedra Filosofal", "  J. K. Rowling", 40.50);
			Livro livro2 = new Livro ("É Assim Que Acaba", "Colleen Hoover", 34.60);
			Livro livro3 = new Livro ("O morro dos ventos uivantes", "Emily Brontë", 20.80);
			Livro livro4 = new Livro ("Começando a Programar em Python Para Leigos", "John Paul Mueller", 74.90);
			Livro livro5 = new Livro ("Java para Iniciantes: Crie, Compile e Execute Programas Java Rapidamente", " Herbert Schildt", 160.00);
			livros.addLivro(livro1);
			livros.addLivro(livro2);
			livros.addLivro(livro3);
			livros.addLivro(livro4);
			livros.addLivro(livro5);

			Artigo artigo1 = new Artigo ("Java: o que é, linguagem e um Guia para iniciar na tecnologia", "  André Bessa", 0.0, " java");
			Artigo artigo2 = new Artigo ("Iterando uma lista em Java", "Alex Felipe", 0.0, " java");
			Artigo artigo3 = new Artigo ("Introducao a boas praticas de Programaçao", " Guilherme Vilatoro Santos e Luiz Fernando Braga Lopes", 0.0, "programação");
			artigos.addArtigo(artigo1);
			artigos.addArtigo(artigo2);
			artigos.addArtigo(artigo3);

			Usuario user1 = new Usuario ("Laryssa", "83912345678");
			Usuario user2 = new Usuario ("Ludmila", "83909876543");
			Usuario user3 = new Usuario ("Maria", "83999000099");
			Usuario user4 = new Usuario ("Ana", "8345458888");
			usuario.adicionaUsuario(user1);
			usuario.adicionaUsuario(user2);
			usuario.adicionaUsuario(user3);
			usuario.adicionaUsuario(user4);

			SwingUtilities.invokeLater(() -> {
				Biblioteca janela = new Biblioteca();
				janela.setVisible(true);
			});

		}
	}


		
	