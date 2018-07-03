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
        
        
        VisitorAnimaisQuantidade v1 = new VisitorAnimaisQuantidade();
        VisitorAnimaisQuantidade v2 = new VisitorAnimaisQuantidade();
        jogo.getJogador1().accept(v1);
        jogo.getJogador2().accept(v2);
        if (v1.getQtd() == 0 || v2.getQtd() == 0){
            jogo.setEstado(new JogoFinalizado(jogo));
        }
    }
    
}
