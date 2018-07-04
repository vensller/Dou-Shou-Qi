package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public abstract class VisitorAtacanteAnimal implements VisitorAtaque{
    
    List<Posicao> listaPosicoes;
    protected Animal atacante;
    
    public VisitorAtacanteAnimal(Animal atacante){
        this.atacante = atacante;
        listaPosicoes = new ArrayList<Posicao>();
    }

    @Override
    public void visit(Peca peca) {
        if (atacante.getForca() > peca.getForca()){
            listaPosicoes.add(new Posicao(peca.getColuna(), peca.getLinha()));
        }
    }

    @Override
    public void visit(Elefante e) {
        visit((Peca) e);
    }
    
    public List<Posicao> getListaPosicoes(){
        return listaPosicoes;
    }
    
}
