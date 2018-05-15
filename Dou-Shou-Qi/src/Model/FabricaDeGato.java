package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeGato extends FabricaDePeca{

    @Override
    public void criaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[5][1] = new Gato("Imagens/gato1.png", 1, 1, 5);      
    }

    @Override
    public void criaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[1][7] = new Gato("Imagens/gato2.png", 2, 7, 1);           
    }
    
}
