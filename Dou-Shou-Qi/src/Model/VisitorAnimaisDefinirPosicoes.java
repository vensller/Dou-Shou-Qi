package Model;

/**
 *
 * @author Ivens
 */
public class VisitorAnimaisDefinirPosicoes implements VisitorAnimaisJogador{

    @Override
    public void visit(Animal animal) {
        animal.verificarPosicoesPossiveis();
    }
    
}
