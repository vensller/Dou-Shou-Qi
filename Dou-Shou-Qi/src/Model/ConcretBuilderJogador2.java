package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderJogador2 extends BuilderJogador{

    public ConcretBuilderJogador2(Jogador jogador) {
        super(jogador);
    }

    @Override
    public void constroiArmadilha(Peca[][] objetosTabuleiro, Peca[][] objetosPadroes, FabricaDeArmadilha fabrica) {
        objetosTabuleiro[2][8] = fabrica.criaPecaJogador2(8, 2);
        objetosTabuleiro[4][8] = fabrica.criaPecaJogador2(8, 4);
        objetosTabuleiro[3][7] = fabrica.criaPecaJogador2(7, 3);
        objetosPadroes[2][8] = objetosTabuleiro[2][8];
        objetosPadroes[4][8] = objetosTabuleiro[4][8];
        objetosPadroes[3][7] = objetosTabuleiro[3][7];        
    }

    @Override
    public void constroiCachorro(Peca[][] objetosTabuleiro, FabricaDeCachorro fabrica) {
        objetosTabuleiro[5][7] = fabrica.criaPecaJogador2(7, 5); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[5][7]);
    }

    @Override
    public void constroiElefante(Peca[][] objetosTabuleiro, FabricaDeElefante fabrica) {
        objetosTabuleiro[0][6] = fabrica.criaPecaJogador2(6, 0); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[0][6]);
    }

    @Override
    public void constroiGato(Peca[][] objetosTabuleiro, FabricaDeGato fabrica) {
        objetosTabuleiro[1][7] = fabrica.criaPecaJogador2(7, 1); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[1][7]);
    }

    @Override
    public void constroiLeao(Peca[][] objetosTabuleiro, FabricaDeLeao fabrica) {
        objetosTabuleiro[6][8] = fabrica.criaPecaJogador2(8, 6);
        jogador.adicionaPeca((Animal) objetosTabuleiro[6][8]);
    }

    @Override
    public void constroiLeopardo(Peca[][] objetosTabuleiro, FabricaDeLeopardo fabrica) {
        objetosTabuleiro[4][6] = fabrica.criaPecaJogador2(6, 4);
        jogador.adicionaPeca((Animal) objetosTabuleiro[4][6]);
    }

    @Override
    public void constroiLobo(Peca[][] objetosTabuleiro, FabricaDeLobo fabrica) {
        objetosTabuleiro[2][6] = fabrica.criaPecaJogador2(6, 2);
        jogador.adicionaPeca((Animal) objetosTabuleiro[2][6]);
    }

    @Override
    public void constroiRato(Peca[][] objetosTabuleiro, FabricaDeRato fabrica) {
        objetosTabuleiro[6][6] = fabrica.criaPecaJogador2(6, 6); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[6][6]); 
    }

    @Override
    public void constroiTigre(Peca[][] objetosTabuleiro, FabricaDeTigre fabrica) {
        objetosTabuleiro[0][8] = fabrica.criaPecaJogador2(8, 0); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[0][8]);
    }

    @Override
    public void constroiToca(Peca[][] objetosTabuleiro, Peca[][] objetosPadroes, FabricaDeToca fabrica) {
        objetosTabuleiro[3][8] = fabrica.criaPecaJogador2(8, 3);  
        objetosPadroes[3][8] = objetosTabuleiro[3][8];
        jogador.setToca((Toca)objetosTabuleiro[3][8]);
    }
    
}
