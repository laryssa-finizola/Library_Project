package interfaces;

import dados.Usuario;
//essa interface esta relacionada ao emprestimo de cada item
public interface Emprestavel {
	//emprestimo
    void emprestaItem(Usuario usuario); //recebe esse parametro pois indica que esta com um usuario em especifico
    //devolução
    void devolveItem();
}
