package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLobo extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Lobo("Imagens/lobo1.png", linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Lobo("Imagens/lobo2.png", linha, coluna);
    }
    
}
