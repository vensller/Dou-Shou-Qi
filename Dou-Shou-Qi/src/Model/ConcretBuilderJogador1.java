package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderJogador1 extends BuilderJogador{

    public ConcretBuilderJogador1(Jogador jogador) {
        super(jogador);
    }

    @Override
    public void constroiArmadilha(Peca[][] objetosTabuleiro, Peca[][] objetosPadroes, FabricaDeArmadilha fabrica) {
        objetosTabuleiro[2][0] = fabrica.criaPecaJogador1(0, 2); 
        objetosTabuleiro[4][0] = fabrica.criaPecaJogador1(0, 4);
        objetosTabuleiro[3][1] = fabrica.criaPecaJogador1(1, 3); 
        objetosPadroes[2][0] = objetosTabuleiro[2][0];
        objetosPadroes[4][0] = objetosTabuleiro[4][0];
        objetosPadroes[3][1] = objetosTabuleiro[3][1];
        jogador.addArmadilha((Armadilha) objetosTabuleiro[2][0]);
        jogador.addArmadilha((Armadilha) objetosTabuleiro[4][0]);
        jogador.addArmadilha((Armadilha) objetosTabuleiro[3][1]);
    }

    @Override
    public void constroiCachorro(Peca[][] objetosTabuleiro, FabricaDeCachorro fabrica) {
        objetosTabuleiro[1][1] = fabrica.criaPecaJogador1(1, 1); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[1][1]);
    }

    @Override
    public void constroiElefante(Peca[][] objetosTabuleiro, FabricaDeElefante fabrica) {
        objetosTabuleiro[6][2] = fabrica.criaPecaJogador1(2, 6);         
        jogador.adicionaPeca((Animal) objetosTabuleiro[6][2]);
    }

    @Override
    public void constroiGato(Peca[][] objetosTabuleiro, FabricaDeGato fabrica) {
        objetosTabuleiro[5][1] = fabrica.criaPecaJogador1(1, 5);         
        jogador.adicionaPeca((Animal) objetosTabuleiro[5][1]);
    }

    @Override
    public void constroiLeao(Peca[][] objetosTabuleiro, FabricaDeLeao fabrica) {
        objetosTabuleiro[0][0] = fabrica.criaPecaJogador1(0, 0);
        jogador.adicionaPeca((Animal) objetosTabuleiro[0][0]);
    }

    @Override
    public void constroiLeopardo(Peca[][] objetosTabuleiro, FabricaDeLeopardo fabrica) {
        objetosTabuleiro[2][2] = fabrica.criaPecaJogador1(2, 2); 
        jogador.adicionaPeca((Animal) objetosTabuleiro[2][2]);
    }

    @Override
    public void constroiLobo(Peca[][] objetosTabuleiro, FabricaDeLobo fabrica) {
        objetosTabuleiro[4][2] = fabrica.criaPecaJogador1(2, 4);
        jogador.adicionaPeca((Animal) objetosTabuleiro[4][2]);
    }

    @Override
    public void constroiRato(Peca[][] objetosTabuleiro, FabricaDeRato fabrica) {
        objetosTabuleiro[0][2] = fabrica.criaPecaJogador1(2, 0);        
        jogador.adicionaPeca((Animal) objetosTabuleiro[0][2]);
    }

    @Override
    public void constroiTigre(Peca[][] objetosTabuleiro, FabricaDeTigre fabrica) {
        objetosTabuleiro[6][0] = fabrica.criaPecaJogador1(0, 6);    
        jogador.adicionaPeca((Animal) objetosTabuleiro[6][0]);
    }

    @Override
    public void constroiToca(Peca[][] objetosTabuleiro, Peca[][] objetosPadroes, FabricaDeToca fabrica) {
        objetosTabuleiro[3][0] = fabrica.criaPecaJogador1(0, 3);
        objetosPadroes[3][0] = objetosTabuleiro[3][0];
        jogador.setToca((Toca)objetosTabuleiro[3][0]);
    }
    
}
