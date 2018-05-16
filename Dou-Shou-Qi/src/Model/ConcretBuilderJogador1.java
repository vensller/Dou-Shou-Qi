package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderJogador1 extends BuilderJogador{

    @Override
    public void constroiArmadilha(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoTabuleiro[][] objetosPadroes, FabricaDeArmadilha fabrica) {
        objetosTabuleiro[2][0] = fabrica.criaPecaJogador1(0, 2); 
        objetosTabuleiro[4][0] = fabrica.criaPecaJogador1(0, 4);
        objetosTabuleiro[3][1] = fabrica.criaPecaJogador1(1, 3); 
        objetosPadroes[2][0] = objetosTabuleiro[2][0];
        objetosPadroes[4][0] = objetosTabuleiro[4][0];
        objetosPadroes[3][1] = objetosTabuleiro[3][1];
    }

    @Override
    public void constroiCachorro(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeCachorro fabrica) {
        objetosTabuleiro[1][1] = fabrica.criaPecaJogador1(1, 1); 
    }

    @Override
    public void constroiElefante(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeElefante fabrica) {
        objetosTabuleiro[6][2] = fabrica.criaPecaJogador1(2, 6); 
    }

    @Override
    public void constroiGato(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeGato fabrica) {
        objetosTabuleiro[5][1] = fabrica.criaPecaJogador1(1, 5); 
    }

    @Override
    public void constroiLeao(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLeao fabrica) {
        objetosTabuleiro[0][0] = fabrica.criaPecaJogador1(0, 0);
    }

    @Override
    public void constroiLeopardo(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLeopardo fabrica) {
        objetosTabuleiro[2][2] = fabrica.criaPecaJogador1(2, 2); 
    }

    @Override
    public void constroiLobo(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLobo fabrica) {
        objetosTabuleiro[4][2] = fabrica.criaPecaJogador1(2, 4);
    }

    @Override
    public void constroiRato(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeRato fabrica) {
        objetosTabuleiro[0][2] = fabrica.criaPecaJogador1(2, 0);        
    }

    @Override
    public void constroiTigre(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeTigre fabrica) {
        objetosTabuleiro[6][0] = fabrica.criaPecaJogador1(0, 6);    
    }

    @Override
    public void constroiToca(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoTabuleiro[][] objetosPadroes, FabricaDeToca fabrica) {
        objetosTabuleiro[3][0] = fabrica.criaPecaJogador1(0, 3);
        objetosPadroes[3][0] = objetosTabuleiro[3][0];
    }
    
}
