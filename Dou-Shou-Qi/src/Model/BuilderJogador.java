package Model;

/**
 *
 * @author Ivens
 */
public abstract class BuilderJogador {
    
    public abstract void constroiArmadilha(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoTabuleiro[][] objetosPadroes, FabricaDeArmadilha fabrica);
    public abstract void constroiCachorro(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeCachorro fabrica);
    public abstract void constroiElefante(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeElefante fabrica);
    public abstract void constroiGato(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeGato fabrica);
    public abstract void constroiLeao(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLeao fabrica);
    public abstract void constroiLeopardo(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLeopardo fabrica);
    public abstract void constroiLobo(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLobo fabrica);
    public abstract void constroiRato(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeRato fabrica);
    public abstract void constroiTigre(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeTigre fabrica);
    public abstract void constroiToca(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoTabuleiro[][] objetosPadroes, FabricaDeToca fabrica);
    
}
