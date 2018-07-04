package Model;

/**
 *
 * @author Ivens
 */
public abstract class JogoEstado {
    
    protected Jogo jogo;
    
    public JogoEstado(Jogo jogo){
        this.jogo = jogo;
    }    
    
    public abstract void movimentaPeca(Posicao posicao);
        
}
