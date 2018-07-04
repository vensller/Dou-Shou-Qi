package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class VisitorAtacanteAnimal implements VisitorAtaque{
    
    protected List<Posicao> listaPosicoes;
    protected Animal atacante;
    
    public VisitorAtacanteAnimal(Animal atacante){
        this.atacante = atacante;
        listaPosicoes = new ArrayList<Posicao>();
    }

    @Override
    public void visit(Peca peca) {
        if (atacante.getForca() >= peca.getForca() || peca.isEstaNaArmadilha()){
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
