package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLeao extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Leao("Imagens/leao1.png", linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Leao("Imagens/leao2.png", linha, coluna);
    }
    
}
