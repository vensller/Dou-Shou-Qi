package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderJogador2 extends BuilderJogador{

    @Override
    public void constroiArmadilha(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoTabuleiro[][] objetosPadroes, FabricaDeArmadilha fabrica) {
        objetosTabuleiro[2][8] = fabrica.criaPecaJogador2(8, 2);
        objetosTabuleiro[4][8] = fabrica.criaPecaJogador2(8, 4);
        objetosTabuleiro[3][7] = fabrica.criaPecaJogador2(7, 3);
        objetosPadroes[2][8] = objetosTabuleiro[2][8];
        objetosPadroes[4][8] = objetosTabuleiro[4][8];
        objetosPadroes[3][7] = objetosTabuleiro[3][7];        
    }

    @Override
    public void constroiCachorro(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeCachorro fabrica) {
        objetosTabuleiro[5][7] = fabrica.criaPecaJogador2(7, 5); 
    }

    @Override
    public void constroiElefante(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeElefante fabrica) {
        objetosTabuleiro[0][6] = fabrica.criaPecaJogador2(6, 0); 
    }

    @Override
    public void constroiGato(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeGato fabrica) {
        objetosTabuleiro[1][7] = fabrica.criaPecaJogador2(7, 1); 
    }

    @Override
    public void constroiLeao(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLeao fabrica) {
        objetosTabuleiro[6][8] = fabrica.criaPecaJogador2(8, 6);
    }

    @Override
    public void constroiLeopardo(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLeopardo fabrica) {
        objetosTabuleiro[4][6] = fabrica.criaPecaJogador2(6, 4);
    }

    @Override
    public void constroiLobo(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLobo fabrica) {
        objetosTabuleiro[2][6] = fabrica.criaPecaJogador2(6, 2);
    }

    @Override
    public void constroiRato(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeRato fabrica) {
        objetosTabuleiro[6][6] = fabrica.criaPecaJogador2(6, 6);  
    }

    @Override
    public void constroiTigre(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeTigre fabrica) {
        objetosTabuleiro[0][8] = fabrica.criaPecaJogador2(8, 0); 
    }

    @Override
    public void constroiToca(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoTabuleiro[][] objetosPadroes, FabricaDeToca fabrica) {
        objetosTabuleiro[3][8] = fabrica.criaPecaJogador2(8, 3);  
        objetosPadroes[3][8] = objetosTabuleiro[3][8];
    }
    
}
