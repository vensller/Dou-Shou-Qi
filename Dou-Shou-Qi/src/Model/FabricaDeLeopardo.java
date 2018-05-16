package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLeopardo extends FabricaDePeca{

    @Override
    public Peca criaPecaJogador1(int linha, int coluna) {
        return new Leopardo("Imagens/leopardo1.png", 1, linha, coluna); 
    }

    @Override
    public Peca criaPecaJogador2(int linha, int coluna) {
        return new Leopardo("Imagens/leopardo2.png", 2, linha, coluna);
    }
    
}
