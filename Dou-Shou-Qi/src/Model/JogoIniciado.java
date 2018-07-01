package Model;

/**
 *
 * @author Ivens
 */
public class JogoIniciado extends JogoEstado{
    
    public JogoIniciado(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void movimentaPeca() throws Exception{       
        
        if (jogo.getJogador1().getPecas().isEmpty() || jogo.getJogador2().getPecas().isEmpty()){
            jogo.setEstado(new JogoFinalizado(jogo));
        }
    }
    
}
