package Model;

/**
 *
 * @author Ivens
 */
public class VisitorAnimaisNaoDeixarEntrarToca implements VisitorAnimaisJogador{

    private Toca toca;        

    public VisitorAnimaisNaoDeixarEntrarToca(Toca toca) {
        this.toca = toca;
    }
    
    @Override
    public void visit(Animal animal) {
        animal.removerPosicaoToca(toca.getColuna(), toca.getLinha());
    }
    
}
