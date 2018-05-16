package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeRato extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Rato("Imagens/rato1.png", 1, linha, coluna);
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Rato("Imagens/rato2.png", 2, linha, coluna);
    }
    
}
