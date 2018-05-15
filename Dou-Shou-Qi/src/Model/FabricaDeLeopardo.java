package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLeopardo extends FabricaDePeca{

    @Override
    public void criaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[2][2] = new Leopardo("Imagens/leopardo1.png", 1, 2, 2);        
    }

    @Override
    public void criaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[4][6] = new Leopardo("Imagens/leopardo2.png", 2, 6, 4);
    }
    
}
