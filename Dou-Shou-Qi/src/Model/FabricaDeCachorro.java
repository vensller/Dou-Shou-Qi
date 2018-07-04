package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeCachorro extends FabricaDePeca{
    
    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Cachorro("Imagens/cao1.png", linha, coluna); 
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Cachorro("Imagens/cao2.png", linha, coluna);  
    }
    
}
