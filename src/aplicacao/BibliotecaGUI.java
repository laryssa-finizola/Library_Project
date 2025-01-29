package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public abstract class BibliotecaGUI extends JFrame {
    // menu
    protected JPanel menu;

    public JPanel getMenu() {
        if(menu == null){
            menu = new JPanel(new GridLayout(4, 2)); // centraliza os botões na tela

            btnAdicionaLivro = new JButton("Adiciona livro");
            btnAdicionaArtigo = new JButton("Adiciona artigo");
            btnAdicionaUsuario = new JButton("Adiciona usuario");
            btnEmprestarLivro = new JButton("Emprestar livro");
            btnDevolverLivro = new JButton("Devolver livro");
            btnListarLivrosAZ = new JButton("Listar livros A-Z");
            btnListarArtigosAZ = new JButton("Listar artigos A-Z");
            btnSair = new JButton("Sair");

            menu.add(btnAdicionaLivro);
            menu.add(btnAdicionaArtigo);
            menu.add(btnAdicionaUsuario);
            menu.add(btnEmprestarLivro);
            menu.add(btnDevolverLivro);
            menu.add(btnListarLivrosAZ);
            menu.add(btnListarArtigosAZ);
            menu.add(btnSair);

        }
        return menu;
    }

    //botões
    protected JButton btnAdicionaUsuario;
    protected JButton btnAdicionaLivro;
    protected JButton btnAdicionaArtigo;
    protected JButton btnEmprestarLivro;
    protected JButton btnDevolverLivro;
    protected JButton btnListarLivrosAZ;
    protected JButton btnListarArtigosAZ;
    protected JButton btnSair;

    protected abstract void btnAdicionaLivroClick(ActionEvent ev);
    protected abstract void btnAdicionaArtigoClick(ActionEvent ev);
    protected abstract void btnAdicionaUsuarioClick(ActionEvent ev);
    protected abstract void btnEmprestarLivroClick(ActionEvent ev);
    protected abstract void btnDevolverLivroClick(ActionEvent ev);
    protected abstract void btnListarLivroAZClick(ActionEvent ev);
    protected abstract void btnListarArtigoAZClick(ActionEvent ev);
    protected abstract void btnSairClick(ActionEvent ev);


    private void eventos(){
        btnAdicionaLivro.addActionListener(this::btnAdicionaLivroClick);
        btnAdicionaArtigo.addActionListener(this::btnAdicionaArtigoClick);
        btnAdicionaUsuario.addActionListener(this::btnAdicionaUsuarioClick);
        btnEmprestarLivro.addActionListener(this::btnEmprestarLivroClick);
        btnDevolverLivro.addActionListener(this::btnDevolverLivroClick);
        btnListarLivrosAZ.addActionListener(this::btnListarLivroAZClick);
        btnListarArtigosAZ.addActionListener(this::btnListarArtigoAZClick);
        btnSair.addActionListener(this::btnSairClick);
    }

    //construtor da classe
    public BibliotecaGUI() {
        super("Biblioteca");

        this.setSize(1000, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getMenu(), BorderLayout.CENTER);
        this.eventos();

    }



}
