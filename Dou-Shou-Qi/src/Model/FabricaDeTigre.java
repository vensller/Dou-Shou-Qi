package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeTigre extends FabricaDePeca{

    @Override
    public void criaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[6][0] = new Tigre("Imagens/tigre1.png", 1, 0, 6);                
    }

    @Override
    public void criaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[0][8] = new Tigre("Imagens/tigre2.png", 2, 8, 0);                
    }
    
}
