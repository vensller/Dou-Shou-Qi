package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeToca extends FabricaDePeca{

    @Override
    public void CriaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[3][0] = new Toca("Imagens/toca.png", 1, 0, 3);    
    }

    @Override
    public void CriaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[3][8] = new Toca("Imagens/toca.png", 2, 8, 3);        
    }
    
}
