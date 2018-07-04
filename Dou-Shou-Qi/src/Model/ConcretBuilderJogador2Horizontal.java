package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderJogador2Horizontal extends BuilderJogador{

    public ConcretBuilderJogador2Horizontal(Jogador jogador) {
        super(jogador);
    }

    @Override
    public void constroiArmadilha(Peca[][] objetosTabuleiro, Peca[][] objetosPadroes, FabricaDeArmadilha fabrica) {
        objetosTabuleiro[8][2] = fabrica.criaPecaJogador2(2, 8);
        objetosTabuleiro[8][4] = fabrica.criaPecaJogador2(4, 8);
        objetosTabuleiro[7][3] = fabrica.criaPecaJogador2(3, 7);
        objetosPadroes[8][2] = objetosTabuleiro[8][2];
        objetosPadroes[8][4] = objetosTabuleiro[8][4];
        objetosPadroes[7][3] = objetosTabuleiro[7][3];        
    }

    @Override
    public void constroiCachorro(Peca[][] objetosTabuleiro, FabricaDeCachorro fabrica) {
        objetosTabuleiro[7][5] = fabrica.criaPecaJogador2(5, 7); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[7][5]);
    }

    @Override
    public void constroiElefante(Peca[][] objetosTabuleiro, FabricaDeElefante fabrica) {
        objetosTabuleiro[6][0] = fabrica.criaPecaJogador2(0, 6); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[6][0]);
    }

    @Override
    public void constroiGato(Peca[][] objetosTabuleiro, FabricaDeGato fabrica) {
        objetosTabuleiro[7][1] = fabrica.criaPecaJogador2(1, 7); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[7][1]);
    }

    @Override
    public void constroiLeao(Peca[][] objetosTabuleiro, FabricaDeLeao fabrica) {
        objetosTabuleiro[8][6] = fabrica.criaPecaJogador2(6, 8);
        jogador.adicionaPeca((Animal) objetosTabuleiro[8][6]);
    }

    @Override
    public void constroiLeopardo(Peca[][] objetosTabuleiro, FabricaDeLeopardo fabrica) {
        objetosTabuleiro[6][4] = fabrica.criaPecaJogador2(4, 6);
        jogador.adicionaPeca((Animal) objetosTabuleiro[6][4]);
    }

    @Override
    public void constroiLobo(Peca[][] objetosTabuleiro, FabricaDeLobo fabrica) {
        objetosTabuleiro[6][2] = fabrica.criaPecaJogador2(2, 6);
        jogador.adicionaPeca((Animal) objetosTabuleiro[6][2]);
    }

    @Override
    public void constroiRato(Peca[][] objetosTabuleiro, FabricaDeRato fabrica) {
        objetosTabuleiro[6][6] = fabrica.criaPecaJogador2(6, 6); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[6][6]); 
    }

    @Override
    public void constroiTigre(Peca[][] objetosTabuleiro, FabricaDeTigre fabrica) {
        objetosTabuleiro[8][0] = fabrica.criaPecaJogador2(0, 8); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[8][0]);
    }

    @Override
    public void constroiToca(Peca[][] objetosTabuleiro, Peca[][] objetosPadroes, FabricaDeToca fabrica) {
        objetosTabuleiro[8][3] = fabrica.criaPecaJogador2(3, 8);  
        objetosPadroes[8][3] = objetosTabuleiro[8][3];
        jogador.setToca((Toca)objetosTabuleiro[8][3]);
    }
    
}
