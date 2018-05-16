package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLeao extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Leao("Imagens/leao1.png", 1, linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Leao("Imagens/leao2.png", 2, linha, coluna);
    }
    
}
