package Model;

/**
 *
 * @author Ivens
 */
public class VisitorAnimaisSetarTabuleiro implements VisitorAnimaisJogador{

    private Peca[][] objetosTabuleiro;

    public VisitorAnimaisSetarTabuleiro(Peca[][] objetosTabuleiro) {
        this.objetosTabuleiro = objetosTabuleiro;
    }
        
    @Override
    public void visit(Animal animal) {
        animal.setObjetosTabuleiro(objetosTabuleiro);
    }
    
}
