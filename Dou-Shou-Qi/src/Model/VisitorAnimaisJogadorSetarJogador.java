package Model;

/**
 *
 * @author Ivens
 */
public class VisitorAnimaisJogadorSetarJogador implements VisitorAnimaisJogador{

    private Jogador jogador;

    public VisitorAnimaisJogadorSetarJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    
    @Override
    public void visit(Animal animal) {
        animal.setJogador(jogador);
    }
    
}
