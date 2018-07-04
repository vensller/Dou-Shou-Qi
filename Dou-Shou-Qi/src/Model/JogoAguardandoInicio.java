package Model;

/**
 *
 * @author Ivens
 */
public class JogoAguardandoInicio extends JogoEstado{
    
    public JogoAguardandoInicio(Jogo jogo) {
        super(jogo);
    }    

    @Override
    public void movimentaPeca(Posicao posicao){
        jogo.setEstado(new JogoIniciado(jogo));
        jogo.movimentaPeca(posicao);
    }
}
