package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeTigre extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Tigre("Imagens/tigre1.png", 1, linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Tigre("Imagens/tigre2.png", 2, linha, coluna);
    }
    
}
