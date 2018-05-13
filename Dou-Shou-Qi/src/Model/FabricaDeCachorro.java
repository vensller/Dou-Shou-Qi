package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeCachorro extends FabricaDePeca{

    @Override
    public void CriaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[1][1] = new Cachorro("Imagens/cao1.png", 1, 1, 1);       
    }

    @Override
    public void CriaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[5][7] = new Cachorro("Imagens/cao2.png", 2, 7, 5);        
    }
    
}
