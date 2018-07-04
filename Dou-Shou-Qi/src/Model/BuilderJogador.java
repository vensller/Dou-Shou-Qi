package Model;

/**
 *
 * @author Ivens
 */
public abstract class BuilderJogador {
    
    protected Jogador jogador;
    
    public BuilderJogador(Jogador jogador){
        this.jogador = jogador;
    }
    
    public abstract void constroiArmadilha(Peca[][] objetosTabuleiro, Peca[][] objetosPadroes, FabricaDeArmadilha fabrica);
    public abstract void constroiCachorro(Peca[][] objetosTabuleiro, FabricaDeCachorro fabrica);
    public abstract void constroiElefante(Peca[][] objetosTabuleiro, FabricaDeElefante fabrica);
    public abstract void constroiGato(Peca[][] objetosTabuleiro, FabricaDeGato fabrica);
    public abstract void constroiLeao(Peca[][] objetosTabuleiro, FabricaDeLeao fabrica);
    public abstract void constroiLeopardo(Peca[][] objetosTabuleiro, FabricaDeLeopardo fabrica);
    public abstract void constroiLobo(Peca[][] objetosTabuleiro, FabricaDeLobo fabrica);
    public abstract void constroiRato(Peca[][] objetosTabuleiro, FabricaDeRato fabrica);
    public abstract void constroiTigre(Peca[][] objetosTabuleiro, FabricaDeTigre fabrica);
    public abstract void constroiToca(Peca[][] objetosTabuleiro, Peca[][] objetosPadroes, FabricaDeToca fabrica);
    
}
