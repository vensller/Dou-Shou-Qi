package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeArmadilha extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Armadilha("Imagens/armadilha.png", 1, linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Armadilha("Imagens/armadilha.png", 2, linha, coluna);
    }
   
}
