package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderJogador1Horizontal extends BuilderJogador {

    public ConcretBuilderJogador1Horizontal(Jogador jogador) {
        super(jogador);
    }

    @Override
    public void constroiArmadilha(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoTabuleiro[][] objetosPadroes, FabricaDeArmadilha fabrica) {
        objetosTabuleiro[0][2] = fabrica.criaPecaJogador1(2, 0); 
        objetosTabuleiro[0][4] = fabrica.criaPecaJogador1(4, 0);
        objetosTabuleiro[1][3] = fabrica.criaPecaJogador1(3, 1); 
        objetosPadroes[0][2] = objetosTabuleiro[0][2];
        objetosPadroes[0][4] = objetosTabuleiro[0][4];
        objetosPadroes[1][3] = objetosTabuleiro[1][3];
    }

    @Override
    public void constroiCachorro(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeCachorro fabrica) {
        objetosTabuleiro[1][1] = fabrica.criaPecaJogador1(1, 1); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[1][1]);
    }

    @Override
    public void constroiElefante(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeElefante fabrica) {
        objetosTabuleiro[2][6] = fabrica.criaPecaJogador1(6, 2);         
        jogador.adicionaPeca((Animal) objetosTabuleiro[2][6]);
    }

    @Override
    public void constroiGato(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeGato fabrica) {
        objetosTabuleiro[1][5] = fabrica.criaPecaJogador1(5, 1);         
        jogador.adicionaPeca((Animal) objetosTabuleiro[1][5]);
    }

    @Override
    public void constroiLeao(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLeao fabrica) {
        objetosTabuleiro[0][0] = fabrica.criaPecaJogador1(0, 0);
        jogador.adicionaPeca((Animal) objetosTabuleiro[0][0]);
    }

    @Override
    public void constroiLeopardo(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLeopardo fabrica) {
        objetosTabuleiro[2][2] = fabrica.criaPecaJogador1(2, 2); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[2][2]);
    }

    @Override
    public void constroiLobo(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLobo fabrica) {
        objetosTabuleiro[2][4] = fabrica.criaPecaJogador1(4, 2);
        jogador.adicionaPeca((Animal) objetosTabuleiro[2][4]);
    }

    @Override
    public void constroiRato(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeRato fabrica) {
        objetosTabuleiro[2][0] = fabrica.criaPecaJogador1(0, 2);        
        jogador.adicionaPeca((Animal) objetosTabuleiro[2][0]);
    }

    @Override
    public void constroiTigre(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeTigre fabrica) {
        objetosTabuleiro[0][6] = fabrica.criaPecaJogador1(6, 0);    
        jogador.adicionaPeca((Animal) objetosTabuleiro[0][6]);
    }

    @Override
    public void constroiToca(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoTabuleiro[][] objetosPadroes, FabricaDeToca fabrica) {
        objetosTabuleiro[0][3] = fabrica.criaPecaJogador1(3, 0);
        objetosPadroes[0][3] = objetosTabuleiro[0][3];
    }
}
