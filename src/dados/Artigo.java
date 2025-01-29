package dados;


import interfaces.Emprestavel;
//A classe Artigo estende a classe Livro e implementa a interface Emprestavel
public class Artigo extends Livro implements Emprestavel {
	// Declaração do atributo específico da classe Artigo
    private String assunto ;
    //chama o construtor da classe Livro usando super()
    public Artigo(String titulo, String autor, double valor, String assunto) {
        super(titulo, autor, valor);
        this.assunto = assunto ;
    }
 //metodo get
    public String getAssunto() {
        return assunto ;
    }
 //metodo set
    public void setAssunto (String assunto ) {
        this.assunto  = assunto;
    }
   
   
}


