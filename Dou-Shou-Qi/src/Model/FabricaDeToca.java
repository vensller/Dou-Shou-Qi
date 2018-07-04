package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeToca extends FabricaDePeca{
    
    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Toca("Imagens/toca.png", linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Toca("Imagens/toca.png", linha, coluna);
    }
    
}
