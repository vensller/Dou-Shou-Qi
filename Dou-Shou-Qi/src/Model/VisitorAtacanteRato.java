package Model;

/**
 *
 * @author Ivens
 */
public class VisitorAtacanteRato extends VisitorAtacanteAnimal{
    
    public VisitorAtacanteRato(Animal atacante) {
        super(atacante);
    }
    
    
    @Override
    public void visit(Peca peca) {
        super.visit(peca);
    }
    
    @Override
    public void visit(Elefante e){
        listaPosicoes.add(new Posicao(e.getColuna(), e.getLinha()));
    }
    
}
