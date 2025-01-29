package armazenamento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dados.*;

public class RegistraArtigo {
    private ArrayList<Artigo> artigos;

    public ArrayList<Artigo> retornaListaArtigos(){
        return artigos;
    }
    
    
 // Construtor que inicializa a lista de artigos
    public RegistraArtigo() {
        artigos = new ArrayList<Artigo>();
    }
    // Método para adicionar um artigo à lista
    // Sobrecarga do método addArtigo para permitir adicionar artigo 
    public void addArtigo(Artigo artigo) {
        artigos.add(artigo);
    }
    // Método para remover um artigo da lista
    // Sobrecarga do método para permitir remover por objeto ou índice
    public Artigo getArtigo(int indice) {
        return artigos.get(indice);
    }

    public void removeArtigo(Artigo artigo) {
        artigos.remove(artigo);
    }

    public void removeArtigo(int indice) {
        artigos.remove(indice);
    }

    public int size() {
        return artigos.size();
    }
 // Método para emprestar um artigo a um usuário
    public void emprestaArtigo(Artigo artigos, Usuario usuario) {
    	// Registra a data e hora atual como data de empréstimo
        LocalDateTime now = LocalDateTime.now();
        artigos.setDataEmprestimo(now);
     // Associa o usuário ao artigo
        artigos.setUsuarioComLivro(usuario);
    }
 // Método para ordenar os artigos por título em ordem alfabética
    public void ordenaTituloAZ() {
        Collections.sort(artigos);
    }
}
