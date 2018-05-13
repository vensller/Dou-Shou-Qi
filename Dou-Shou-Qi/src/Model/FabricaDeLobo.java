package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLobo extends FabricaDePeca{

    @Override
    public void CriaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[4][2] = new Lobo("Imagens/lobo1.png", 1, 2, 4);        
    }

    @Override
    public void CriaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[2][6] = new Lobo("Imagens/lobo2.png", 2, 6, 2);
    }
    
}
