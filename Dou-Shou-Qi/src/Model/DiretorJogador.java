package Model;

import java.util.HashMap;

/**
 *
 * @author Ivens
 */
public class DiretorJogador {
    
    private BuilderJogador builder;
    private HashMap<String, FabricaDePeca> fabricas;
    
    public DiretorJogador(BuilderJogador builder, HashMap<String, FabricaDePeca> fabricas){
        this.builder = builder;
        this.fabricas = fabricas;
    }
    
    public void construir(Peca[][] objetosTabuleiro, Peca[][] objetosPadroes){
        builder.constroiArmadilha(objetosTabuleiro, objetosPadroes, (FabricaDeArmadilha)fabricas.get("Armadilha"));
        builder.constroiCachorro(objetosTabuleiro, (FabricaDeCachorro)fabricas.get("Cachorro"));
        builder.constroiElefante(objetosTabuleiro, (FabricaDeElefante)fabricas.get("Elefante"));
        builder.constroiGato(objetosTabuleiro, (FabricaDeGato)fabricas.get("Gato"));
        builder.constroiLeao(objetosTabuleiro, (FabricaDeLeao)fabricas.get("Leao"));
        builder.constroiLeopardo(objetosTabuleiro, (FabricaDeLeopardo)fabricas.get("Leopardo"));
        builder.constroiLobo(objetosTabuleiro, (FabricaDeLobo)fabricas.get("Lobo"));
        builder.constroiRato(objetosTabuleiro, (FabricaDeRato)fabricas.get("Rato"));
        builder.constroiTigre(objetosTabuleiro, (FabricaDeTigre)fabricas.get("Tigre"));
        builder.constroiToca(objetosTabuleiro, objetosPadroes, (FabricaDeToca)fabricas.get("Toca"));
    } 
    
}
