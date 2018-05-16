package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeCachorro extends FabricaDePeca{
    
    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Cachorro("Imagens/cao1.png", 1, linha, coluna); 
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Cachorro("Imagens/cao2.png", 2, linha, coluna);  
    }
    
}
