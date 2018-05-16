package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeToca extends FabricaDePeca{
    
    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Toca("Imagens/toca.png", 1, linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Toca("Imagens/toca.png", 2, linha, coluna);
    }
    
}
