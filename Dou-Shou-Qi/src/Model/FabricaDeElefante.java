package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeElefante extends FabricaDePeca{

    @Override
    public void criaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
       objetosTabuleiro[6][2] = new Elefante("Imagens/elefante1.png", 1, 2, 6);        
    }

    @Override
    public void criaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {        
       objetosTabuleiro[0][6] = new Elefante("Imagens/elefante2.png", 2, 6, 0);   
    }
    
}
