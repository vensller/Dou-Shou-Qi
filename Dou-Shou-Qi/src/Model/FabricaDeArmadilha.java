package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeArmadilha extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Armadilha("Imagens/armadilha.png", linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Armadilha("Imagens/armadilha.png", linha, coluna);
    }
   
}
