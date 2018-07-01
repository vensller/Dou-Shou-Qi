package Model;

/**
 *
 * @author Ivens
 */
public class VisitorAnimaisSetarTabuleiro implements VisitorAnimaisJogador{

    private ObjetoTabuleiro[][] objetosTabuleiro;

    public VisitorAnimaisSetarTabuleiro(ObjetoTabuleiro[][] objetosTabuleiro) {
        this.objetosTabuleiro = objetosTabuleiro;
    }
        
    @Override
    public void visit(Animal animal) {
        animal.setObjetosTabuleiro(objetosTabuleiro);
    }
    
}
