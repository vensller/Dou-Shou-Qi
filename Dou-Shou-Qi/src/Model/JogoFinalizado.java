package Model;

/**
 *
 * @author Ivens
 */
public class JogoFinalizado extends JogoEstado{
    
    public JogoFinalizado(Jogo jogo) {
        super(jogo);
        jogo.encerrarJogo();
    }

    @Override
    public void movimentaPeca(Posicao posicao){
    }
    
}
