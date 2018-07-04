package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeGato extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Gato("Imagens/gato1.png", linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Gato("Imagens/gato2.png", linha, coluna);
    }
    
}
