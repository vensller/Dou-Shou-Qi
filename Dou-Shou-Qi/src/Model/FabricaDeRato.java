package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeRato extends FabricaDePeca{

    @Override
    public void CriaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[0][2] = new Rato("Imagens/rato1.png", 1, 2, 0);        
    }

    @Override
    public void CriaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[6][6] = new Rato("Imagens/rato2.png", 2, 6, 6);        
    }
    
}
