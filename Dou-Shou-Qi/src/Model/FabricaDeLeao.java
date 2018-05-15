package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLeao extends FabricaDePeca{

    @Override
    public void criaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[0][0] = new Leao("Imagens/leao1.png", 1, 0, 0);
    
    }

    @Override
    public void criaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[6][8] = new Leao("Imagens/leao2.png", 2, 8, 6);        
    }
    
}
