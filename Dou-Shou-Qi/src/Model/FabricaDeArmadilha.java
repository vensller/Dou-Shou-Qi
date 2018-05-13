package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeArmadilha extends FabricaDePeca{

    @Override
    public void CriaPecaJogador1(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[2][0] = new Armadilha("Imagens/armadilha.png", 1, 0, 2);
        objetosTabuleiro[4][0] = new Armadilha("Imagens/armadilha.png", 1, 0, 4);
        objetosTabuleiro[3][1] = new Armadilha("Imagens/armadilha.png", 1, 1, 3);        
    }

    @Override
    public void CriaPecaJogador2(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[2][8] = new Armadilha("Imagens/armadilha.png", 2, 8, 2);
        objetosTabuleiro[4][8] = new Armadilha("Imagens/armadilha.png", 2, 8, 4);
        objetosTabuleiro[3][7] = new Armadilha("Imagens/armadilha.png", 2, 7, 3);    
    }
    
}
