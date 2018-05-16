package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeElefante extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Elefante("Imagens/elefante1.png", 1, linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Elefante("Imagens/elefante2.png", 2, linha, coluna);
    }
    
}
